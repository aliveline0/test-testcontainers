package com.hjkim.testcontainers.repository;

import org.springframework.stereotype.Service;

@Service
record SaveSessionAdapter(SaveSessionRepository saveSessionRepository) {

    void saveSession(String sessionId, SessionDto sessionDto) {
        saveSessionRepository.saveSession(sessionId, sessionDto);
    }
}
