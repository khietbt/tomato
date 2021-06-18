package tomato.backends.gatewayservice.configurations;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import tomato.backends.gatewayservice.filters.RoutingLogGlobalFilter;

@Configuration
@Slf4j
public class GlobalFilterConfiguration {
    @Bean
    @Order(-1)
    public GlobalFilter routingLogGlobalFilter() {
        return new RoutingLogGlobalFilter();
    }
}
