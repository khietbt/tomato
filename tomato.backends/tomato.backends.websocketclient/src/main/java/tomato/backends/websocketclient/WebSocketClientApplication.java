package tomato.backends.websocketclient;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.messaging.converter.MappingJackson2MessageConverter;
import org.springframework.web.socket.client.standard.StandardWebSocketClient;
import org.springframework.web.socket.messaging.WebSocketStompClient;
import org.springframework.web.socket.sockjs.client.RestTemplateXhrTransport;
import org.springframework.web.socket.sockjs.client.SockJsClient;
import org.springframework.web.socket.sockjs.client.Transport;
import org.springframework.web.socket.sockjs.client.WebSocketTransport;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

//@EnableDiscoveryClient
@Slf4j
@SpringBootApplication
public class WebSocketClientApplication implements CommandLineRunner {
    @Value("${spring.application.name}")
    private String applicationName;

    public static void main(String[] args) {
        SpringApplication.run(WebSocketClientApplication.class, args);
    }

    @Override
    @SuppressWarnings("all")
    public void run(String... args) throws Exception {
        final String accessToken = "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ7XCJ1c2VyX2lkXCI6MTkyLFwicm9sZXNcIjpbXCJzdHVkZW50XCJdLFwidXNlcm5hbWVcIjpcIjA5MTI5ODUxMjVcIixcImVtYWlsXCI6bnVsbCxcInByaW5jaXBhbFwiOlwiMDkxMjk4NTEyNVwiLFwiYXBwX2lkXCI6XCJsbXMtd2ViXCIsXCJhY2NvdW50X2lkXCI6XCIwZGZmNjdkYi0wNGE1LTQ4ZDItYjkwZS1hMmRjYmQ4OGIwM2ZcIn0iLCJpYXQiOjE2MjUwMjEwNDAsImV4cCI6MTYyNTYyNTgzOX0.YO92Av6CK50E0FPVZJbSOMGLgc5tSWKLCCai4JH9bsk";
        final String uri = "ws://localhost:8082/ws?access_token=" + accessToken;

        log.error("{} is running", applicationName);

        List<Transport> transports = new ArrayList<>();
        transports.add(new WebSocketTransport(new StandardWebSocketClient()));
        transports.add(new RestTemplateXhrTransport());

        var webSocketClient = new SockJsClient(transports);

        var webSocketStompClient = new WebSocketStompClient(webSocketClient);

        webSocketStompClient.setMessageConverter(new MappingJackson2MessageConverter());

        var handler = new StompSessionHandler();

        var session = webSocketStompClient.connect(uri, handler).get(10, TimeUnit.SECONDS);


        var destination = "/app/chat/private/mikai43";
        session.send(destination, new ObjectMapper().readTree("{\"sender\":\"xxxx\",\"message\":\"xxxxx\"}"));

        log.error("Connected successfully!");

        new Scanner(System.in).nextLine(); // Don't close immediately.
    }
}
