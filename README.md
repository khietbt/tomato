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

## References

* SpringBoot v2.5.0