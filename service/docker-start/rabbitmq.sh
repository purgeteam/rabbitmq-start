#!/usr/bin/env bash
# 创建多个RabbitMQ容器
docker run -d --hostname rabbit1 --name myrabbit1 -p 15672:15672 -p 5672:5672 -e RABBITMQ_ERLANG_COOKIE='rabbitcookie' rabbitmq:3.7.8-management

docker run -d --hostname rabbit2 --name myrabbit2 -p 5673:5672 -p 15673:15672 --link myrabbit1:rabbit1 -e RABBITMQ_ERLANG_COOKIE='rabbitcookie' rabbitmq:3.7.8-management

docker run -d --hostname rabbit3 --name myrabbit3 -p 5674:5672 -p 15674:15672 --link myrabbit1:rabbit1 --link myrabbit2:rabbit2 -e RABBITMQ_ERLANG_COOKIE='rabbitcookie' rabbitmq:3.7.8-management

