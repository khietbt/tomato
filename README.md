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

* git clone --recursive git@github.com:khietbt/tomato.git
* git submodule foreach --recursive git checkout master

## Decisions
### Config First Boostrap

Discovery First Bootstrap forces others services to wait until finishing the registration of the config service with eureka.

It is not a good experience.

Hence, here we go with Config First Bootstrap.