package com.fngeno.messagingservice.config;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;
import org.springframework.jms.connection.CachingConnectionFactory;
import org.springframework.jms.connection.JmsTransactionManager;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.support.converter.MappingJackson2MessageConverter;
import org.springframework.jms.support.converter.MessageConverter;
import org.springframework.jms.support.converter.MessageType;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableTransactionManagement
@EnableJms
@Configuration
public class JmsConfig { // implements JmsListenerConfigurer {
	private static final Logger LOGGER = LoggerFactory.getLogger(JmsConfig.class);

	@Value("${spring.activemq.broker-url}")
	private String brokerUrl;

	@Value("${spring.activemq.user}")
	private String user;

	@Value("${spring.activemq.password}")
	private String password;

	@Bean
	public MessageConverter jacksonJmsMessageConverter() {
		MappingJackson2MessageConverter converter = new
				MappingJackson2MessageConverter();
		converter.setTargetType(MessageType.TEXT);
		converter.setTypeIdPropertyName("_type"); //does not matter what "-type"make sure they are the same
		// if you want to use it in a different place.
		return converter;
	}

	@Bean
	public CachingConnectionFactory connectionFactory() {
		CachingConnectionFactory factory = new CachingConnectionFactory(
				new ActiveMQConnectionFactory(user, password, brokerUrl));
		factory.setClientId("StoreFront");
		factory.setSessionCacheSize(100);
		return factory;
	}

	@Bean
	public DefaultJmsListenerContainerFactory jmsListenerContainerFactory() {
		DefaultJmsListenerContainerFactory factory = new
				DefaultJmsListenerContainerFactory();
		factory.setConnectionFactory(connectionFactory());
		factory.setMessageConverter(jacksonJmsMessageConverter()); //to use explicit to  use msg converter
		//factory.setMessageConverter(xmlMarshallingMessageConverter());
		factory.setTransactionManager(jmsTransactionManager());
		factory.setErrorHandler(t -> {
			LOGGER.info("Handling error in listener for messages, errors " + t.getMessage());
		});
		return factory;
	}

	@Bean
	public PlatformTransactionManager jmsTransactionManager() {
		return new JmsTransactionManager(connectionFactory());
	}

//		configure jms factory.
	 @Bean
    public JmsTemplate jmsTemplate(){
        JmsTemplate jmsTemplate = new JmsTemplate(connectionFactory());
        jmsTemplate.setMessageConverter(jacksonJmsMessageConverter());
        jmsTemplate.setDeliveryPersistent(true);
        jmsTemplate.setSessionTransacted(true);
        return jmsTemplate;

    }
}

//	@Bean
//	public MessageConverter xmlMarshallingMessageConverter() {
//		MarshallingMessageConverter converter = new MarshallingMessageConverter(xmlStreamMarshaller());
//		converter.setTargetType(MessageType.TEXT);
//		return converter;
//	}

//	@Bean
//	public XStreamMarshaller xmlStreamMarshaller() {
//		XStreamMarshaller marshaller = new XStreamMarshaller();
//		marshaller.setSupportedClasses(Book.class, Customer.class, BookOrder.class);
//		return marshaller;
//	}


	  //connecting external activeMQ  connection factory
//	  @Bean
//	  public SingleConnectionFactory connectionFactory(){
//		ActiveMQConnectionFactory factory = new ActiveMQConnectionFactory(user, password, brokerUrl);
//		SingleConnectionFactory singleConnectionFactory = new SingleConnectionFactory(factory);
//		singleConnectionFactory.setReconnectOnException(true);
//		singleConnectionFactory.setClientId("myClientID");
//		return singleConnectionFactory;
//	  }




//	@Bean
//	public JmsTemplate jmsTemplate(){
//		JmsTemplate jmsTemplate = new JmsTemplate(connectionFactory());
//		jmsTemplate.setMessageConverter(jacksonJmsMessageConverter());
//		jmsTemplate.setDeliveryPersistent(true);//to persist msg
//		jmsTemplate.setSessionTransacted(true);
//		return jmsTemplate;
//	}

	/**
	@Bean //for book Listner
	public BookOrderProcessingMessageListener jmsMessageListener(){
    	BookOrderProcessingMessageListener listener =  new BookOrderProcessingMessageListener();
    	return listener;
	}
	 */
	/**
	@Override
	public void configureJmsListeners(JmsListenerEndpointRegistrar registrar) {
		SimpleJmsListenerEndpoint endpoint = new SimpleJmsListenerEndpoint();
		endpoint.setMessageListener(jmsMessageListener());
		endpoint.setDestination("book.order.processed.queue");
		endpoint.setId("book-order-processed-queue");
		endpoint.setSubscription("my-subscription");
		endpoint.setConcurrency("1");
		registrar.setContainerFactory(jmsListenerContainerFactory());
		registrar.registerEndpoint(endpoint, jmsListenerContainerFactory());
	}

}
	*/



