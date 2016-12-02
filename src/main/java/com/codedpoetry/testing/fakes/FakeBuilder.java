package com.codedpoetry.testing.fakes;

import java.util.Map;

public interface FakeBuilder<T> {
	
	FakeBuilder<T> with(String attribute, Object value);
	
	T build();

	FakeBuilder<T> with(Map<String, Object> attributes);
}
