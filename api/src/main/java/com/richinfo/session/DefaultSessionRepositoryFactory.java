package com.richinfo.session;

import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * default session repository factory implement.
 *
 * @author sdj
 */
public class DefaultSessionRepositoryFactory implements SessionRepositoryFactory {
    private SessionRepository repository;

    public DefaultSessionRepositoryFactory() {
        repository = new RedisSessionRepository(new JedisPool(new JedisPoolConfig(), "redis.host.name"));
    }

    public SessionRepository getSessionRepository() {
        return repository;
    }
}
