package cn.immer.session;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * session builder.
 *
 * @author sdj
 */
public class SessionBuilder {
    private String cookieName = "sessionId";

    private Boolean httpOnly = true;

    private SessionRepository repository = new DefaultSessionRepositoryFactory().getSessionRepository();

    public SessionBuilder setCookieName(String cookieName) {
        this.cookieName = cookieName;
        return this;
    }

    public SessionBuilder setSessionRepository(SessionRepository repository) {
        if (repository != null) {
            this.repository = repository;
        }
        return this;
    }

    public SessionBuilder setHttpOnly(Boolean httpOnly) {
        this.httpOnly = httpOnly;
        return this;
    }

    public Session createSession(HttpServletRequest request, HttpServletResponse response) {
        return new Session(repository, request, response, cookieName, httpOnly);
    }
}
