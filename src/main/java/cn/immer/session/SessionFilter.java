package cn.immer.session;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * self session filter.
 *
 * @author sdj
 */
public class SessionFilter implements Filter {
    private static final Logger LOG = LoggerFactory.getLogger(SessionFilter.class);
    public static String SESSION_REPOSITORY_FACTORY = "SESSION_REPOSITORY_FACTORY";
    public static String SESSION_KEY = "session";
    private String cookieName = "sessionId";
    private Boolean httpOnly = true;
    private SessionRepositoryFactory repositoryFactory;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        String factory = filterConfig.getInitParameter("factory");
        if (factory != null && !"".equals(factory)) {
            try {
                repositoryFactory = (SessionRepositoryFactory) Class.forName(factory).newInstance();
            } catch (Exception e) {
                LOG.error("instantiation session repository factory exception", e);
            }
        }
        if (repositoryFactory == null) {
            repositoryFactory = new DefaultSessionRepositoryFactory();
        }
        filterConfig.getServletContext().setAttribute(SESSION_REPOSITORY_FACTORY, repositoryFactory);
        
        String sessionKey = filterConfig.getInitParameter("sessionKey");
        if (sessionKey != null && !"".equals(sessionKey)) {
            SESSION_KEY = sessionKey;
        }
        String cookieName = filterConfig.getInitParameter("cookieName");
        if (cookieName != null && !"".equals(cookieName)) {
            this.cookieName = cookieName;
        }
        String httpOnly = filterConfig.getInitParameter("httpOnly");
        if (httpOnly != null && !"".equals(httpOnly)) {
            this.httpOnly = Boolean.valueOf(httpOnly);
        }
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response,
                         FilterChain chain) throws IOException, ServletException {
        Session session = new SessionBuilder().setSessionRepository(repositoryFactory.getSessionRepository())
                .setCookieName(cookieName).setHttpOnly(httpOnly)
                .createSession((HttpServletRequest) request, (HttpServletResponse) response);
        request.setAttribute(SESSION_KEY, session);
        chain.doFilter(request, response);
        session.save();
    }

    @Override
    public void destroy() {
    }
}

