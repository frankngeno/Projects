package com.fngeno.messagingservice.services;

import com.fngeno.messagingservice.pojos.BookOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessagePostProcessor;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.jms.JMSException;
import javax.jms.Message;

@Component
public class BookOrderService {
    private static final String Book_QUEUE = "book.order.queue";
    @Autowired
    private JmsTemplate jmsTemplate;

    @Transactional
    public void send(BookOrder bookOrder, String storeId, String orderState){
        jmsTemplate.convertAndSend(Book_QUEUE, bookOrder, new MessagePostProcessor() {
            @Override
            public Message postProcessMessage(Message message) throws JMSException {
                message.setStringProperty("orderId", bookOrder.getBookOrderId());
                message.setStringProperty("storeId", storeId);
                message.setStringProperty("orderState",orderState);
                return message;
            }
        });
    }

}
