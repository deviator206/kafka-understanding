# kafka-understanding
Simple Attempt to understand Kafka

# Kafka Understanding

### Server's Up
2 servers to be started
<pre>
> bin/zookeeper-server-start.sh config/zookeeper.properties


>bin/kafka-server-start.sh config/server.properties
</pre>
Server is on!

### Java Side Changes
- ProducerConfig - with ProducerFactory & kafkaTemplate - this consist of strategy for message along with template
- ConsumerConfig - with ConsumerFactory & KakfkaListenerContainerFactory 
- configuration in properties file
  <pre>
  kafka.bootstrapAddress=localhost:9092
kafka.consumer.group-id=foo
  </pre>
### Publish event 
<pre>
@Autowired
private KafkaTemplate<String, String> kafkaTemplate;

kafkaTemplate.send("baeldung", "new msg## ");
</pre>

### Listen to events
<pre>
@KafkaListener(topics = "baeldung" , groupId = "foo")
    public void listenGroupFoo(String message) {
        System.out.println("Received Message in group foo: " + message);
    }
</pre>


### Reference

- [QuickStart Kafka ]( https://kafka.apache.org/quickstart )

- [SpringBoot & Kafka](https://www.baeldung.com/spring-kafka)

- [Extra Ref](https://reflectoring.io/spring-boot-kafka/)
