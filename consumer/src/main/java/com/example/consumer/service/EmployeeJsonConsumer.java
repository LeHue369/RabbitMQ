package com.example.consumer.service;

import com.example.consumer.entity.Employee;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeJsonConsumer {

	@Autowired
	private ObjectMapper objectMapper;

	private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeJsonConsumer.class);

	@RabbitListener(queues = "course.employee")
	public void listen(String message) throws JsonProcessingException {
		var employee = objectMapper.readValue(message, Employee.class);
		LOGGER.info("employee is {}", employee);
	}
}
