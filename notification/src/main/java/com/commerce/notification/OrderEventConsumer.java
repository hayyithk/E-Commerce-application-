package com.commerce.notification;

import com.commerce.notification.payload.OrderCreatedEvent;
import com.commerce.notification.payload.OrderStatus;
import lombok.extern.slf4j.Slf4j;
//import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.function.Consumer;

@Service
@Slf4j
public class OrderEventConsumer {

//    @RabbitListener(queues = "${rabbitmq.queue.name}")
//    public void handleOrderEvent(Map<String, Object> orderEvent) {
//        System.out.println("Received Order Event: "+ orderEvent);
//
//        long orderId = Long.parseLong(orderEvent.get("orderId").toString());
//        String orderStatus = orderEvent.get("status").toString();
//
//        System.out.println("Order Id: "+ orderId);
//        System.out.println("Order Status: "+ orderStatus);
//
////        UPDATE DATABASE
////        SEND NOTIFICATION
////        SEND EMAILS
////        GENERATE INVOICE
////        SEND SELLER NOTIFICATION
//    }
    @Bean
    public Consumer<OrderCreatedEvent> orderCreated(){
        return event -> {
            log.info("Received order created event for order: {}",event.getOrderId());
            log.info("Received order created event for user id: {}",event.getUserId());
        };
    }

}
