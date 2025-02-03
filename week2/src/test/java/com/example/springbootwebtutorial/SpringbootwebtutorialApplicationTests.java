package com.example.springbootwebtutorial;

import com.example.springbootwebtutorial.entities.DepartmentEntity;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpringbootwebtutorialApplicationTests {

	@Test
	void contextLoads() {
		DepartmentEntity department  = new DepartmentEntity();
		department.setTitle("1233");
	}

}
