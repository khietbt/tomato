# tomato.backends.configservice

A centralized config server.

## Backends

This project supports 2 kinds of backends:

* git
* jdbc

By settings:

```yaml
spring:
  profiles:
    active: git, jdbc
```

### GIT

```yaml
spring:
  cloud:
    config:
      git:
        uri: git@github.com:khietbt/tomato.configurations.git
        order: 1
```

By default, user's private-key is used to connect to git repo. It can be overwritten by the below settings:

```yaml
spring:
  cloud:
    config:
      git:
        private-key: /path/to/another/private-key
```

### JDBC

```yaml
spring:
  cloud:
    config:
      server:
        jdbc:
          sql: "SELECT p.key, p.value FROM properties p WHERE p.application=? AND p.profile=? AND p.label=?"
          order: 2
```

With the order of 2, JDBC settings will be loaded after the GIT ones.

#### Data Source

It shares the same datasource configuration with spring:

```yaml
spring:
  application:
    name: tomato.backends.configservice
  datasource:
    url: jdbc:mysql://localhost/configservice?createDatabaseIfNotExist=true&characterEncoding=utf8
    username: lika_dev
    password: Vuanh090317
    driver-class-name: com.mysql.cj.jdbc.Driver
  jpa:
    generate-ddl: false
    hibernate:
      ddl-auto: none
    open-in-view: false
    show-sql: false
```

#### Initializing Data

Configs are initialized by using liquibase with dependency in pom.xml:

```xml
<dependency>
    <groupId>org.liquibase</groupId>
    <artifactId>liquibase-core</artifactId>
    <version>4.3.5</version>
</dependency>
```
 
By default, it reads the changelog-master at the address: 

```text
classpath:/db/changelog/db.changelog-master.yaml
```

In case of changing the location, a settings in the bootstrap.yml should be filled:

```yaml
spring:
  liquibase:
    change-log: /path/to/another/changelog-master
```