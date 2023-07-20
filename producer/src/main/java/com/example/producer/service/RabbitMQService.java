package com.example.producer.service;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RabbitMQService {

	@Autowired
	private RabbitTemplate rabbitTemplate;

	public void senMessage(String name){
		rabbitTemplate.convertAndSend("course.hello", "hello" + name);
	}
}
