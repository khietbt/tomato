package tomato.backends.gatewayservice.filters;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.cloud.gateway.route.Route;
import org.springframework.cloud.gateway.support.ServerWebExchangeUtils;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.net.URI;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Collections;
import java.util.Objects;
import java.util.Set;

@Slf4j
public class RoutingLogGlobalFilter implements GlobalFilter {
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        LocalDateTime start = LocalDateTime.now();

        return chain
                .filter(exchange)
                .then(
                        Mono.fromRunnable(
                                () -> {
                                    LocalDateTime end = LocalDateTime.now();

                                    Long elapsedTime = ChronoUnit.MILLIS.between(start, end);

                                    Set<URI> uris = exchange.getAttributeOrDefault(
                                            ServerWebExchangeUtils.GATEWAY_ORIGINAL_REQUEST_URL_ATTR,
                                            Collections.emptySet()
                                    );

                                    Route route = exchange.getAttribute(ServerWebExchangeUtils.GATEWAY_ROUTE_ATTR);
                                    URI original = uris.isEmpty() ? null : uris.iterator().next();
                                    URI routed = exchange.getAttribute(ServerWebExchangeUtils.GATEWAY_REQUEST_URL_ATTR);

                                    assert Objects.nonNull(route);
                                    assert Objects.nonNull(routed);

                                    log.info(
                                            "Processed a request: elapsedTime={}ms, httpStatus={}, route=[id={}, {} {} --> {}])"
                                            , elapsedTime
                                            , exchange.getResponse().getStatusCode()
                                            , route.getId()
                                            , exchange.getRequest().getMethod()
                                            , original
                                            , routed
                                    );
                                }
                        )
                );
    }
}
