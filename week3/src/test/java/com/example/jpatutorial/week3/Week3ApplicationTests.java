package com.example.jpatutorial.week3;

import com.example.jpatutorial.week3.entities.ProductEntity;
import com.example.jpatutorial.week3.repositories.ProductRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@SpringBootTest
class Week3ApplicationTests {

	@Autowired
	private ProductRepository productRepository;

	@Test
	void contextLoads() {
	}

	@Test
	void repositoryTest() {
		ProductEntity productEntity = ProductEntity.builder()
				.sku("nestle24")
				.title("Nestle Chocolate")
				.price(BigDecimal.valueOf(123.45))
				.quantity(12)
				.build();
		ProductEntity savedEntity = productRepository.save(productEntity);
		System.out.println(savedEntity);
	}

	@Test
	void getRepository(){
//		List<ProductEntity> entities = productRepository.findByCreatedAtAfter(
//				LocalDateTime.of(2024, 1,1,0, 0,0));
//		System.out.println(entities);
		List<ProductEntity> entities = productRepository.findByQuantityGreaterThanAndPriceLessThan(12, BigDecimal.valueOf(123.45));
		System.out.println(entities);
	}

	@Test
	void getSingleFromRepository(){
		Optional<ProductEntity> productEntity = productRepository.findByTitleAndPrice("pepsi", BigDecimal.valueOf(14.5));
		productEntity.ifPresent(System.out::println);
	}

}
