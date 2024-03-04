package edu.iu.habahram.coffeeorder;

import edu.iu.habahram.coffeeorder.controllers.OrderController;
import edu.iu.habahram.coffeeorder.model.OrderData;
import edu.iu.habahram.coffeeorder.model.Receipt;
import edu.iu.habahram.coffeeorder.repository.OrderRepository;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.test.util.AssertionErrors.*;

@SpringBootTest
class CoffeeOrderApplicationTests {
	public class OrderControllerTest {

		@Test
		public void contextLoads() {
			List<String> coffeeTypes = Arrays.asList("DarkRoast", "HouseBlend", "Decaf", "Espresso");
			List<String> condimentTypes = Arrays.asList("Mocha", "Milk", "Whip", "Soy");

			OrderRepository orderRepositoryMock = new OrderRepositoryMock();
			OrderController orderController = new OrderController(orderRepositoryMock);

			for (String coffeeType : coffeeTypes) {
				for (String condimentType : condimentTypes) {
					OrderData orderData = new OrderData(coffeeType, List.of(condimentType));

					ResponseEntity<?> responseEntity = orderController.add(orderData);

					assertEquals("", HttpStatus.CREATED, responseEntity.getStatusCode());

					assertTrue(responseEntity.getBody() instanceof Receipt);
					Receipt receipt = (Receipt) responseEntity.getBody();

					assertNotNull("", receipt.description());
					assertNotEquals("",0.0f, receipt.cost());
					assertNotEquals("",0, receipt.id());
				}
			}
		}

		private static class OrderRepositoryMock extends OrderRepository {
			@Override
			public Receipt add(OrderData order) {
				return new Receipt("Mock Order", 10.0f, 123);
			}
		}
	}


}
