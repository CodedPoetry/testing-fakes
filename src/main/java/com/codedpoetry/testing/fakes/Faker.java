package com.codedpoetry.testing.fakes;

import java.util.HashMap;
import java.util.Map;

import com.codedpoetry.testing.fakes.reflect.GetterSetterInvocationHandler;

public abstract class Faker {
	
	public static <T> FakeBuilder<T> newBuilder(Class<T> clazz) {
		return new FakeBuilderImpl<>(clazz);
	}
	
	public static <T> T fake(Class<T> clazz) {
		
		return fake(clazz, new HashMap<>());
	}
	
	public static <T> T fake(Class<T> clazz, Map<String, Object> attributes) {
		return newBuilder(clazz).with(attributes).build();
	}

}
