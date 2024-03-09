package edu.iu.habahram.coffeeorder;

import edu.iu.habahram.coffeeorder.model.*;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class CoffeeOrderApplicationTests {

	@Test
	public void testMilkDR() {
		Beverage beverage = new Milk(new DarkRoast());
		assertEquals(2.39F, beverage.cost(), 0.01);
		assertEquals("Dark roast, Milk", beverage.getDescription());
	}

	@Test
	public void testMilkHB() {
		Beverage beverage = new Milk(new HouseBlend());
		assertEquals(2.05F, beverage.cost(), 0.01);
		assertEquals("House blend, Milk", beverage.getDescription());
	}

	@Test
	public void testMilkDecaf() {
		Beverage beverage = new Milk(new Decaf());
		assertEquals(1.68F, beverage.cost(), 0.01);
		assertEquals("Decaf, Milk", beverage.getDescription());
	}

	@Test
	public void testMilkEspresso() {
		Beverage beverage = new Milk(new Espresso());
		assertEquals(1.74F, beverage.cost(), 0.01);
		assertEquals("Espresso, Milk", beverage.getDescription());
	}

	@Test
	public void testMochaDR() {
		Beverage beverage = new Mocha(new DarkRoast());
		assertEquals(2.29F, beverage.cost(), 0.01);
		assertEquals("Dark roast, Mocha", beverage.getDescription());
	}
	@Test
	public void testMochaHB() {
		Beverage beverage = new Mocha(new HouseBlend());
		assertEquals(1.95F, beverage.cost(),0.01);
		assertEquals("House blend, Mocha", beverage.getDescription());
	}
	@Test
	public void testMochaDecaf() {
		Beverage beverage = new Mocha(new Decaf());
		assertEquals(1.58F, beverage.cost(),0.01);
		assertEquals("Decaf, Mocha", beverage.getDescription());
	}
	@Test
	public void testMochaEspresso() {
		Beverage beverage = new Mocha(new Espresso());
		assertEquals(1.64F, beverage.cost(),0.01);
		assertEquals("Espresso, Mocha", beverage.getDescription());
	}
	@Test
	public void testSoyDR() {
		Beverage beverage = new Soy(new DarkRoast());
		assertEquals(2.79F, beverage.cost(), 0.01);
		assertEquals("Dark roast, Soy", beverage.getDescription());
	}
	@Test
	public void testSoyHB() {
		Beverage beverage = new Soy(new HouseBlend());
		assertEquals(2.45F, beverage.cost(),0.01);
		assertEquals("House blend, Soy", beverage.getDescription());
	}
	@Test
	public void testSoyDecaf() {
		Beverage beverage = new Soy(new Decaf());
		assertEquals(2.08F, beverage.cost(),0.01);
		assertEquals("Decaf, Soy", beverage.getDescription());
	}
	@Test
	public void testSoyEspresso() {
		Beverage beverage = new Soy(new Espresso());
		assertEquals(2.14F, beverage.cost(),0.01);
		assertEquals("Espresso, Soy", beverage.getDescription());
	}
	@Test
	public void testWhipDR() {
		Beverage beverage = new Whip(new DarkRoast());
		assertEquals(2.59F, beverage.cost(), 0.01);
		assertEquals("Dark roast, Whip", beverage.getDescription());
	}
	@Test
	public void testWhipHB() {
		Beverage beverage = new Whip(new HouseBlend());
		assertEquals(2.25F, beverage.cost(),0.01);
		assertEquals("House blend, Whip", beverage.getDescription());
	}
	@Test
	public void testWhipDecaf() {
		Beverage beverage = new Whip(new Decaf());
		assertEquals(1.88F, beverage.cost(),0.01);
		assertEquals("Decaf, Whip", beverage.getDescription());
	}
	@Test
	public void testWhipEspresso() {
		Beverage beverage = new Whip(new Espresso());
		assertEquals(1.94F, beverage.cost(),0.01);
		assertEquals("Espresso, Whip", beverage.getDescription());
	}
}