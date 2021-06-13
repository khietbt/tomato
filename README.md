# Tomato

A walk on microservices.

## Hierarchy

```text
tomato
\__ tomato.applications
|        \__ tomato.applications.adminservice
|        \__ tomato.applications.configservice
|        \__ tomato.applications.eurekaservice
|        \__ tomato.applications.gatewayservice
|        \__ tomato.applications.productservice
|        \__ tomato.applications.userservice
\__ tomato.configurations
```

## Clone

```shell
git clone --recursive git@github.com:khietbt/tomato.git && cd tomato && git submodule foreach --recursive git checkout master
```

Note: Repositories are public, but a private key linked to a GitHub account is necessary.

## Decisions
### Config First Boostrap

Discovery First Bootstrap forces others services to wait until finishing the registration of the config service with eureka.

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
      name: ${CONFIG_SERVER_USERNAME:username}
      password: ${CONFIG_SERVER_PASSWORD:password}
```

Please note that this setting affects other endpoints.

## References

* SpringBoot v2.5.0