# Tomato

A walk on microservices.

## Hierarchy

```text
tomato
\__ tomato-config-service
\__ tomato-discovery-service
\__ tomato-gateway-service
\__ tomato-admin-service
\__ tomato-user-service
\__ tomato.backends
|        \__ tomato.backends.productservice
\__ tomato.configurations
```

## Clone

```shell
git clone --recursive git@github.com:khietbt/tomato.git && cd tomato && git submodule foreach --recursive git checkout master
```

Note: Repositories are public, but a private key linked to a GitHub account is necessary.

## Decisions

### Config First Boostrap

Discovery First Bootstrap forces others services to wait until finishing the registration of the config service with
eureka.

It is not a good experience.

Hence, here we go with Config First Bootstrap.

### Liquibase

Modules in this project will use liquibase to initialize data / structures if necessary.

### Actuator

Basically, actuator provides details of running services. In this project, all endpoints are enabled with a setting:

```yaml
management:
  endpoints:
    enabled-by-default: true
    web:
      exposure:
        include: "*"
```

Details of actuator, please take a look at this documentation:

```text
https://docs.spring.io/spring-boot/docs/current/reference/html/actuator.html
```

Here, actuator entries are protected by spring-boot-starter-security with a setting:

```yaml
spring:
  security:
    user:
      name: ${CONFIG_SERVICE_USERNAME:username}
      password: ${CONFIG_SERVICE_PASSWORD:password}
```

Please note that this setting affects other endpoints.

### Tracing

TraceId is put into log lines using spring-boot-starter-sleuth.

## References

* SpringBoot v2.5.0