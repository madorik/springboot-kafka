# springboot-kafka
springboot-kafka for window 

## Getting Started 
install kafka

###  kafka 설치
> http://mirror.navercorp.com/apache/kafka/2.7.0

### kafka 시작
```
bin\windows\kafka-server-start.bat config\server.properties
```

### zookeeper 시작
```
bin\windows\zookeeper-server-start.bat config\zookeeper.properties
```

### sample topic 생성
```
bin\windows\kafka-topics.bat --create --zookeeper localhost:2181 --replication-factor 1 --partitions 1 --topic sample_topic_20210403
```

### topic 목록 확인
```
bin\windows\kafka-topics.bat --list --zookeeper localhost:2181
```

### 이벤트 확인
```
bin\windows\kafka-console-consumer.bat --bootstrap-server localhost:9092 --topic sample_topic_20210403
```
