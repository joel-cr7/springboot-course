package com.example.course.week1;

import com.example.course.week1.BeanLecture.Apple;
import com.example.course.week1.DependencyInjectionLecture.DBService;
import com.example.course.week1.Homework.CakeBaker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class Week1Application implements CommandLineRunner {

//	@Autowired
//	Apple apple;
	// first search by bean name then by type
	// if bean name if found duplicate in application context preference is given to the @Configuration bean
	// if name is not matching with the beans in application context and types are bean types defined are 2 then exception

//	@Autowired
//	private ApplicationContext applicationContext;

//	@Autowired
//	DBService dbService;

	@Autowired
	CakeBaker cakeBaker;



	public static void main(String[] args) {
		SpringApplication.run(Week1Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// bean lecture
//		apple.eatApple();
//		String[] beans = applicationContext.getBeanDefinitionNames();
//		for (String bean : beans) {
//			System.out.println(bean);
//		}

		// Dependency injection lecture
//		System.out.println(dbService.getData());

		cakeBaker.bakeCake();
	}
}
