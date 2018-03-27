package cn.immer.session.redis;

import cn.immer.session.SessionRepository;
import redis.clients.jedis.JedisCluster;

import java.util.Map;

/**
 * redis session repository.
 *
 * @author sdj
 */
public class RedisSessionClusterRespository implements SessionRepository {

    JedisCluster jedisCluster;

    RedisSessionClusterRespository redisSessionClusterRespository;

    @Override
    public int getTimeout() {

        return 0;
    }

    @Override
    public void save(String id, Map<String, String> session) {

    }

    @Override
    public Map<String, String> get(String id) {
        return null;
    }

    @Override
    public void delete(String id) {

    }

    @Override
    public void removeByKV(String key, String value) {

    }
}
