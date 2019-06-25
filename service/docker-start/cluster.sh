#!/usr/bin/env bash
# 将RabbitMQ节点加入到集群中

# 1
docker exec -it rabbitcluster1 bash
rabbitmqctl stop_app
rabbitmqctl reset
rabbitmqctl start_app
exit
# 2
docker exec -it rabbitcluster2 bash
rabbitmqctl stop_app
rabbitmqctl reset
rabbitmqctl join_cluster --ram rabbit@rabbit1
rabbitmqctl start_app
exit
# 3
docker exec -it rabbitcluster3 bash
rabbitmqctl stop_app
rabbitmqctl reset
rabbitmqctl join_cluster --ram rabbit@rabbit1
rabbitmqctl start_app
exit