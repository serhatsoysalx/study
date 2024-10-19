package com.study.confirigation;

import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMqConfiguration {

    @Value("#{@environment.getProperty('rabbit.queue.name')}")
    private String queue;

    @Value("#{@environment.getProperty('rabbit.exchange.name')}")
    private String exchange;


    @Value("#{@environment.getProperty('rabbit.routing.name')}")
    private String routing;

    @Bean
    public Queue queue(){
        return new Queue(queue);
    }

    @Bean
    public DirectExchange directExchange(){
        return new DirectExchange(exchange);
    }

    @Bean
    public Binding binding(final Queue queue,final DirectExchange directExchange){
        return BindingBuilder.bind(queue).to(directExchange).with(routing);
    }


}
