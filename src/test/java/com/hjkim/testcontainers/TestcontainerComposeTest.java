package com.hjkim.testcontainers;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.testcontainers.containers.ComposeContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

import java.io.File;

/**
 * Testcontainers with Docker Compose
 * https://java.testcontainers.org/modules/docker_compose/
 */
@Testcontainers
public class TestcontainerComposeTest {

    @Container
    static ComposeContainer container =
            new ComposeContainer(new File("src/test/resources/docker-compose-test.yml"))
                    .withExposedService("merchant_admin_db", 3306)
                    .withExposedService("redis", 6379);

    @DynamicPropertySource
    static void setProperties(DynamicPropertyRegistry registry) {
        int merchantAdminDatabasePort = container.getServicePort("merchant_admin_db", 3306);
        int redisPort = container.getServicePort("redis", 6379);

        registry.add("spring.datasource.url", () ->
                String.format("jdbc:mysql://localhost:%d/merchant", merchantAdminDatabasePort));
    }

    @Test
    public void testMerchantAdminDatabase() {
        Assertions.assertThat(1)
                .isEqualTo(1);
    }
}
