package ru.garant21.core.repositories;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import redis.clients.jedis.Jedis;


@Repository
@RequiredArgsConstructor
public class RedisRepository {

    final String TOKENS_SET = "tokens";
    Jedis jedis = new Jedis();

    public void clearCash() {
        jedis.flushDB();
    }

    public void save(String token) {
        jedis.sadd(TOKENS_SET, token);
    }

    public boolean checkToken(String authorizationHeader) {
        return jedis.sismember (TOKENS_SET, authorizationHeader);
    }
}
