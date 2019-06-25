# rabbitmq-start

[![Build Status](https://secure.travis-ci.org/elasticjob/elastic-job-lite.png?branch=master)](https://travis-ci.org/elasticjob/elastic-job-lite)
[![Maven Status](https://maven-badges.herokuapp.com/maven-central/com.dangdang/elastic-job-lite/badge.svg)](https://maven-badges.herokuapp.com/maven-central/com.dangdang/elastic-job-lite)
[![Gitter](https://badges.gitter.im/Elastic-JOB/elastic-job-lite.svg)](https://gitter.im/Elastic-JOB/elasticjob?utm_source=badge&utm_medium=badge&utm_campaign=pr-badge)
[![Coverage Status](https://coveralls.io/repos/elasticjob/elastic-job/badge.svg?branch=master&service=github)](https://coveralls.io/github/elasticjob/elastic-job?branch=master)
[![GitHub release](https://img.shields.io/github/release/elasticjob/elastic-job.svg)](https://github.com/elasticjob/elastic-job/releases)
[![License](https://img.shields.io/badge/license-Apache%202-4EB1BA.svg)](https://www.apache.org/licenses/LICENSE-2.0.html)

### 参考
https://www.cnblogs.com/fanqisoft/p/10402607.html

### 创建多个RabbitMQ容器
```text
cd service/docker-start
sh rabbitmq.sh
```

```text
　　--link　　连接多个容器

　　-d　　后台进程运行

　　--hostname　　RabbitMQ主机名称

　　--name　　容器名称

　　-p port:port　　本地端口:容器端口

　　-e　　参数设置
```

### 将RabbitMQ节点加入到集群中
```text
#!/usr/bin/env bash
# 将RabbitMQ节点加入到集群中

# 1
docker exec -it myrabbit1 bash
rabbitmqctl stop_app
rabbitmqctl reset
rabbitmqctl start_app
exit
# 2
docker exec -it myrabbit2 bash
rabbitmqctl stop_app
rabbitmqctl reset
rabbitmqctl join_cluster --ram rabbit@rabbit1
rabbitmqctl start_app
exit
# 3
docker exec -it myrabbit3 bash
rabbitmqctl stop_app
rabbitmqctl reset
rabbitmqctl join_cluster --ram rabbit@rabbit1
rabbitmqctl start_app
exit
```
```text
--ram　　表示设置为内存节点，忽略该参数则默认为磁盘节点。
```

### 控制台访问

```text
使用http://ip:15672 进行访问了，账号密码默认为guest&guest
```

### 测试调用
```text
http://127.0.0.1:8081/rabbitmq/123
查看product，consumer控制台输出内容
```
