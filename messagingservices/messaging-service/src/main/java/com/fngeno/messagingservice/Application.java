package com.fngeno.messagingservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.jms.annotation.EnableJms;

@EnableJms
@SpringBootApplication
public class Application extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(Application.class);
	}

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);

	}
}
		//ConfigurableApplicationContext context = SpringApplication.run(Application.class, args);
		//JmsTemplate jmsTemplate = context.getBean(JmsTemplate.class); //this is used for sending the sms
		//jmsTemplate.convertAndSend("order-queue", "Hello!");
//		Sender sender = context.getBean(Sender.class);
//		sender.sendMessage("order-queue", "Hello!");
//	}
/**
	@Bean //
	public JmsListenerContainerFactory warehouseFactory(ConnectionFactory factory,
														DefaultJmsListenerContainerFactoryConfigurer configurer){
	DefaultJmsListenerContainerFactory containerFactory = new DefaultJmsListenerContainerFactory();
	configurer.configure(containerFactory, factory);
	return containerFactory;
	}
/**
	//connecting external activeMQ  connection factory

  @Bean
	public ActiveMQConnectionFactory connectionFactory(){
		ActiveMQConnectionFactory factory = new ActiveMQConnectionFactory("admin",
				"admin", "tcp:localhost:61616");
		return factory;
	}

	//configure jms factory.
	@Bean
	public JmsTemplate jmsTemplate(){
		return new JmsTemplate(connectionFactory());
	}
	//default
	public DefaultJmsListenerContainerFactory defaultJmsListenerContainerFactory() {
		DefaultJmsListenerContainerFactory factory = new
				DefaultJmsListenerContainerFactory();
		factory.setConnectionFactory(connectionFactory());
		factory.setConcurrency("1-1");
		return factory;
	}
**/

