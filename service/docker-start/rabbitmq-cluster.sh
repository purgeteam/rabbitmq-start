#!/usr/bin/env bash
# 创建多个RabbitMQ容器
docker run -d --hostname rabbit1 --name rabbit1 -p 15672:15672 -p 5672:5672 -e RABBITMQ_ERLANG_COOKIE='rabbitcookie' rabbitmq:3.7.8-management

docker run -d --hostname rabbit2 --name rabbit2 -p 5673:5672 -p 15673:15672 --link myrabbit1:rabbit1 -e RABBITMQ_ERLANG_COOKIE='rabbitcookie' rabbitmq:3.7.8-management

docker run -d --hostname rabbit3 --name rabbit3 -p 5674:5672 -p 15674:15672 --link myrabbit1:rabbit1 --link myrabbit2:rabbit2 -e RABBITMQ_ERLANG_COOKIE='rabbitcookie' rabbitmq:3.7.8-management

