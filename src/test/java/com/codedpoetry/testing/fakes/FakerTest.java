package com.codedpoetry.testing.fakes;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import com.codedpoetry.fakes.Dummy;
import com.codedpoetry.testing.fakes.Faker;

public class FakerTest {
	
	@Test
	public void testFake() {
		Dummy instance = Faker.fake(Dummy.class);
		assertNull("No attribute values given", instance.getFoo());
	}
	
	@Test
	public void testFakeWithAttributes() {
		Map<String, Object> attributes = new HashMap<>();
        attributes.put("foo", "value");
		Dummy instance = Faker.fake(Dummy.class, attributes);
		assertEquals("value", instance.getFoo());
	}
	
	@Test
	public void testFakeSetter() {
		Dummy instance = Faker.fake(Dummy.class);
		assertNull("No attribute values given", instance.getFoo());
		instance.setFoo("value");
		assertEquals("value", instance.getFoo());
	}
	
	@Test
	public void testNoGetter1() {
		Dummy instance = Faker.fake(Dummy.class);
		assertNull("No attribute values given", instance.getFoo());
		instance.setFoo("value");
		assertNull(instance.getSum(null, null));
	}
	
	@Test
	public void testNoGetter2() {
		Dummy instance = Faker.fake(Dummy.class);
		assertNull("No attribute values given", instance.getFoo());
		instance.setFoo("value");
		assertNull(instance.calculateBar());
	}
	
	@Test
	public void testNoSetter() {
		Dummy instance = Faker.fake(Dummy.class);
		assertNull("No attribute values given", instance.getFoo());
		instance.setFoo("value");
		instance.setUp();
	}

}
