package com.fngeno.messagingservice.services;

import com.fngeno.messagingservice.pojos.BookOrder;
import com.fngeno.messagingservice.pojos.ProcessedBookOrder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.listener.adapter.JmsResponse;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Service;

@Service
public class WareHouseReceiverService {
    private static final Logger LOGGER = LoggerFactory.getLogger(WareHouseReceiverService.class);
    @Autowired
    private WarehouseProcessingService warehouseProcessingService;

    @JmsListener(destination = "book.order.queue")
//  NO NEED FOR  @SendTo("book.order.processed.queue") if you have Jms Response
    public JmsResponse<Message<ProcessedBookOrder>> receive(@Payload BookOrder bookOrder,
                                                           @Header(name = "orderStater") String orderState,
                                                           @Header(name = "bookOrderId") String bookOrderId,
                                                           @Header(name = "storeId") String storeId) throws IllegalAccessException{
        LOGGER.info("received a message");
        LOGGER.info("Message is == " + bookOrder);
        LOGGER.info("Message property orderState = {}, bookOrderId = {}, " +
                "storeId = {}", orderState, bookOrderId, storeId);
        if (bookOrder.getBook().getTitle().startsWith("l")){
            throw new IllegalAccessException("OrderId= "+ bookOrder.getBookOrderId() +
                    " begins with L and these books are " + "not allowed");
        }
        return warehouseProcessingService.processOrder(bookOrder, orderState, storeId);

    }

}
