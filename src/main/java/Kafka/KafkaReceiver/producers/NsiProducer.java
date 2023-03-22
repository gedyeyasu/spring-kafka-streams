package Kafka.KafkaReceiver.producers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class NsiProducer {


    @Autowired
    KafkaTemplate<String, Double> kafkaTemplate;

    @Value("${spring.kafka.nsi-topic}")
    private String nsiTopic;

    public void publishNormalizedSensitivityIndex(Double value){
        System.out.println("publishing normalized sensitivity index value: "+ value + " to topic: "+ nsiTopic);
        kafkaTemplate.send(nsiTopic, value);
    }

}
