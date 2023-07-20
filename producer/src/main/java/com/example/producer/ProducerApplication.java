package com.example.producer;

import com.example.producer.entity.Employee;
import com.example.producer.service.EmployeeJsonProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;

@SpringBootApplication
public class ProducerApplication implements CommandLineRunner {

	@Autowired
	private EmployeeJsonProducer producer;

	public static void main(String[] args) {
		SpringApplication.run(ProducerApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		for(int i = 0; i < 5; i++){
			var employee = new Employee("emp", "Employee " + i, LocalDate.now());
			producer.sendMessage(employee);
		}
	}
}
