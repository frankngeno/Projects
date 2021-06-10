package com.fngeno.messagingservice.services;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class Receiver {
    //@JmsListener(destination = "order-queue", containerFactory = "warehouseFactory")
    @JmsListener(destination = "order-queue")
    public void receiveMessage(String order){
        System.out.println("Order received is " + order);
    }

}
