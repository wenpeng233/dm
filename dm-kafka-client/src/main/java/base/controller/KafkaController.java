package base.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class KafkaController {

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    @RequestMapping(value="/sendMsgToKafka")
    public String sendMsgToKafka(){
        for (int i = 0; i < 10; i++){
            kafkaTemplate.send("user_consumer", "dm", "hello,Kafka! ---> " + i);
        }

        return "发送消息到kafka完毕";
    }
}
