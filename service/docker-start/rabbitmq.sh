#!/usr/bin/env bash

docker run -d --hostname rabbit1 --name rabbit1 -p 15672:15672 -p 5672:5672 -e RABBITMQ_ERLANG_COOKIE='rabbitcookie' rabbitmq:3.7.8-management