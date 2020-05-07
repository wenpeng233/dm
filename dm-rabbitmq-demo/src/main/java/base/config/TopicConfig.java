package base.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class TopicConfig {

    @Bean
    public Queue queue1() {
        return new Queue("hello.queue1", true);
    }

    @Bean
    public Queue queue2() {
        return new Queue("hello.queue2", true);
    }

    @Bean
    TopicExchange topicExchange(){
        return new TopicExchange("topicExchange");
    }

    @Bean
    public Binding binding1(){
        return BindingBuilder.bind(queue1())
                .to(topicExchange())
                .with("key.1");
    }

    @Bean
    public Binding binding2(){
        return BindingBuilder.bind(queue2())
                .to(topicExchange())
                .with("key.#");
    }
}
