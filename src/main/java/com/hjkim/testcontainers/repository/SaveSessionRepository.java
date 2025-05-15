package com.hjkim.testcontainers.repository;

import org.springframework.data.redis.core.RedisKeyValueTemplate;
import org.springframework.stereotype.Repository;

@Repository
class SaveSessionRepository {

    private final RedisKeyValueTemplate redisKeyValueTemplate;
    public SaveSessionRepository(RedisKeyValueTemplate redisKeyValueTemplate) {
        this.redisKeyValueTemplate = redisKeyValueTemplate;
    }

    void saveSession(String sessionId, SessionDto sessionDto) {
        redisKeyValueTemplate.insert(sessionId, sessionDto);
    }

    SessionDto findSession(String sessionId) {
        return redisKeyValueTemplate.findById(sessionId, SessionDto.class)
                .orElseThrow(() -> new RuntimeException("Session not found"));
    }
}
