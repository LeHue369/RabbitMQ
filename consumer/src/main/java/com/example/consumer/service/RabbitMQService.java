package com.example.consumer.service;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class RabbitMQService {

	@RabbitListener(queues = "course.hello")
	public void getMessage(String message){
		System.out.println("Consuming " + message);
	}
}
