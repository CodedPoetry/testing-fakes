# Testing Fakes

[![Build Status](https://travis-ci.org/CodedPoetry/testing-fakes.svg?branch=master)](https://travis-ci.org/CodedPoetry/testing-fakes)
[![codecov](https://codecov.io/gh/CodedPoetry/testing-fakes/branch/master/graph/badge.svg)](https://codecov.io/gh/CodedPoetry/testing-fakes)

Easy generate fake implementation of getters and setters. Also, canned method returns can be programmed.

## Usage

Faker creates proxy objects that from a Map<String,Object> to generate the output of their method calls. The Map gives the method name and the value to return. Also, a builder can be used to create the fake objects in a more human-readable way:

```java
Bar bar = Faker.newBuilder(Bar.class)
				.with("foo", "my-value")
				.build();
assertEquals("my-value", bar.getFoo());
```

