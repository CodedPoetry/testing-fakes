# Testing Fakes

[![Build Status](https://travis-ci.org/CodedPoetry/testing-fakes.svg?branch=master)](https://travis-ci.org/CodedPoetry/testing-fakes)

Easy generate fake implementation of getters and setters

## Usage

```java
Bar bar = Faker.newBuilder(Bar.class)
				.with("foo", "my-value")
				.build();
assertEquals("my-value", bar.getFoo());
```