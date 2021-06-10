package com.fngeno.messagingservice.services;

import com.fngeno.messagingservice.pojos.BookOrder;
import com.fngeno.messagingservice.pojos.ProcessedBookOrder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.listener.adapter.JmsResponse;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.Queue;

@Service
public class WarehouseProcessingService {
    private static final Logger LOGGER = LoggerFactory.getLogger
            (WarehouseProcessingService.class);
    private static final String PROCESSED_QUEUE = "book.order.processed.queue";
    private static final String CANCELED_QUEUE = "book.order.canceled.queue";
    @Autowired
    private JmsTemplate jmsTemplate;

    @Transactional
    public JmsResponse<Message<ProcessedBookOrder>> processOrder(BookOrder bookOrder, String orderState, String storeId)
            throws IllegalAccessException {
        Message<ProcessedBookOrder> message;
        if("NEW".equalsIgnoreCase(orderState)){
            message = add(bookOrder, storeId);
            return JmsResponse.forQueue(message, PROCESSED_QUEUE);
        } else if("UPDATE".equalsIgnoreCase(orderState)){
           message = add(bookOrder, storeId);
           return JmsResponse.forQueue(message, PROCESSED_QUEUE);
        } else  if("DELETE".equalsIgnoreCase(orderState)) {
           message = delete(bookOrder, storeId);
           return JmsResponse.forQueue(message, CANCELED_QUEUE);
        }
        else {
            throw new IllegalAccessException("warehouseProcessingService." +
                    "processOrder(...) - orderState did not " + "match expected values");
        }

    }
    private Message<ProcessedBookOrder> add(BookOrder bookOrder, String storeId) {
        LOGGER.info("ADDING A NEW ORDER TO THE DB");
        //TODO - do some type of db operation
        return build(new ProcessedBookOrder(
                bookOrder,
                new Date(),
                new Date()
        ), "ADDED", storeId);
    }
    private Message<ProcessedBookOrder> update(BookOrder bookOrder, String storeId) {
        LOGGER.info("UPDATE A NEW ORDER TO THE DB");
        //TODO - do some type of db operation
        return build(new ProcessedBookOrder(
                bookOrder,
                new Date(),
                new Date()
        ),"UPDATED", storeId) ;
    }
    private Message<ProcessedBookOrder> delete(BookOrder bookOrder, String storeId) {
        LOGGER.info("DELETE A NEW ORDER TO THE DB");
        //TODO - do some type of db operation
        return build(new ProcessedBookOrder(
                bookOrder,
                new Date(),
                null
        ),"DELETED", storeId);
    }
    private Message<ProcessedBookOrder> build(ProcessedBookOrder bookOrder,
                                              String orderState,
                                              String storeId){
        return MessageBuilder
                .withPayload(bookOrder)
                .setHeader("orderState", orderState)
                .setHeader("storeId", storeId).build();
    }
}
