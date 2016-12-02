package com.codedpoetry.testing.fakes;

import static org.junit.Assert.assertEquals;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import com.codedpoetry.fakes.Dummy;

public class FakeBuilderImplTest {

	FakeBuilder<Dummy> builder;
	
	@Test
	public void testBuild() throws Exception {
		
		Dummy dummy = Faker.newBuilder(Dummy.class)
				.with("foo", "value")
				.build();
		
		assertEquals("value", dummy.getFoo());
	}
	
	@Test
	public void testBuilderConstructor() throws Exception {
		
		Map<String, Object> attributes = new HashMap<>();
		attributes.put("foo", "value");
		builder = new FakeBuilderImpl<>(Dummy.class, attributes);
		Dummy dummy = builder.build();
		
		assertEquals("value", dummy.getFoo());
	}

}
