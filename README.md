# Testing Fakes

Easy generate fake implementation of getters and setters

## Usage

```java
Bar bar = Faker.newBuilder(Bar.class)
				.with("foo", "my-value")
				.build();
assertEquals("my-value", bar.getFoo());
```