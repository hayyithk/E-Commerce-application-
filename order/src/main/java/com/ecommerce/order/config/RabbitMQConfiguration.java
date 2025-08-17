//package com.ecommerce.order.config;
//
//import org.springframework.amqp.core.*;
//import org.springframework.amqp.rabbit.connection.ConnectionFactory;
//import org.springframework.amqp.rabbit.core.RabbitAdmin;
//import org.springframework.amqp.rabbit.core.RabbitTemplate;
//import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
//import org.springframework.amqp.support.converter.MessageConverter;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//@Configuration
//public class RabbitMQConfiguration {
//
//    @Value("${rabbitmq.queue.name}")
//    private String queueName;
//    @Value("${rabbitmq.exchange.name}")
//    private String exchangeName;
//    @Value("${rabbitmq.routing.key}")
//    private String routingKey;
//
//    @Bean
//    public Queue queue(){
//        return QueueBuilder.durable(queueName).build();
//    }
//
//    @Bean
//    public TopicExchange exchange(){
//        return ExchangeBuilder.topicExchange(exchangeName)
//                .durable(true)
//                .build();
//    }
//
//    @Bean
//    public Binding binding(){
//        return BindingBuilder.bind(queue())
//                .to(exchange())
//                .with(routingKey);
//    }
//
//    @Bean
//    public AmqpAdmin amqpAdmin(ConnectionFactory connectionFactory){
//        RabbitAdmin admin = new RabbitAdmin(connectionFactory);
//        admin.setAutoStartup(true);
//        return admin;
//    }
//
//    @Bean
//    public MessageConverter messageConverter(){
//        return new Jackson2JsonMessageConverter();
//    }
//
//    @Bean
//    public RabbitTemplate rabbitTemplate(ConnectionFactory connectionFactory){
//        RabbitTemplate template = new RabbitTemplate(connectionFactory);
//        template.setMessageConverter(messageConverter());
//        template.setExchange(exchangeName);
//        return template;
//    }
//}
//
////Durable queue meaning this is a queue or this is a type of queue that survives server restarts.
//
////So what did I do I am creating a topic I'm creating a topic exchange okay. Which allows pattern based routing. And the name is again injected from the properties file.
//
////We are saying bind this queue. What is this queue? This queue is this queue that you have created over here.
////To this exchange.
////This exchange is the exchange that you defined here with this routing key.
////So you are you're creating a binding that is linking the queue and exchange together.
////And routing key is controlling which messages should go to this particular queue.
//
////Now what this is doing is this helps automatically declare queues exchanges and binding when the app starts.
////And when we have set auto startup to true this means like no manual registration is needed.
//
//// So this tells RabbitMQ to convert Java objects into JSON when sending messages and vice versa when receiving,
////and it makes it easy for us to work with Java objects.
//
////Okay, so rabbit template over here is used to send messages to rabbit MQ.And what are we doing.
////We are setting the message converter and setting the default exchange over here for rabbit template to work with okay.
//
//// summary
//
////So in summary this entire configuration file is setting up queue exchange binding them together.
////Auto registering them at startup.
////Enabling the Java objects as JSON in with RabbitMQ, RabbitMQ and prepares rabbit template to easily send messages.