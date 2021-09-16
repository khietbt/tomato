package tomato.discoveryservice;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@Slf4j
@SpringBootApplication
public class DiscoveryServiceApplication implements CommandLineRunner {
    @Value("${spring.application.name}")
    private String applicationName;

    public static void main(String[] args) {
        SpringApplication.run(DiscoveryServiceApplication.class, args);
    }

    @Override
    @SuppressWarnings("all")
    public void run(String... args) throws Exception {
        log.error("{} is running", applicationName);
    }
}
