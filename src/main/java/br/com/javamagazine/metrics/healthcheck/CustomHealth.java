package br.com.javamagazine.metrics.healthcheck;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

/**
 * Created by lucaso on 16/02/16.
 */
@Component
public class CustomHealth implements HealthIndicator {

    @Override
    public Health health() {
        int errorCode = check(); // perform some specific healthcheck check
        if (errorCode != 0) {
            return Health.down().withDetail("Error Code", errorCode).build();
        }
        return Health.up().build();
    }

    private int check() {
        return 0;
    }
}
