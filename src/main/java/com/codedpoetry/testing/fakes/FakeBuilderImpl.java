package com.codedpoetry.testing.fakes;

import java.util.HashMap;
import java.util.Map;

import com.codedpoetry.testing.fakes.reflect.GetterSetterInvocationHandler;

public class FakeBuilderImpl<T> implements FakeBuilder<T>{
	private Map attributes = new HashMap<>();
	private Class<T> clazz;
	
	public FakeBuilderImpl(Class<T> clazz) {
		super();
		this.clazz = clazz;
	}
	
	public FakeBuilderImpl(Class<T> clazz,  Map attributes) {
		super();
		this.clazz = clazz;
		this.attributes = attributes;
	}

	@Override
	public FakeBuilder<T> with(String attribute, Object value) {
		attributes.put(attribute, value);
		return this;
	}
	
	@Override
	public FakeBuilder<T> with(Map<String, Object> attributes) {
		this.attributes = attributes;
		return this;
	}

	@Override
	public T build() {
		return (T) java.lang.reflect.Proxy.newProxyInstance(
                clazz.getClassLoader(),
                new java.lang.Class[] { clazz },
                new GetterSetterInvocationHandler(attributes));
	}

}
