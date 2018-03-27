package cn.immer.session;

import java.util.Map;

/**
 * session repository.
 *
 * @author sdj
 */
public interface SessionRepository {
    int getTimeout();

    void save(String id, Map<String, String> session);

    Map<String, String> get(String id);

    void delete(String id);

    void removeByKV(String key, String value);
}
