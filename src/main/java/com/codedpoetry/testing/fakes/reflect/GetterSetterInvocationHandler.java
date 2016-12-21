package com.codedpoetry.testing.fakes.reflect;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class GetterSetterInvocationHandler implements InvocationHandler{

	private Map<String, Object> attributes;
	
	public GetterSetterInvocationHandler(Map<String, Object> attributes) {
		super();
		this.attributes = attributes;
	}

	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		Object result = attributes.get(method.getName());

		if (result != null){
			return result;
		} else if (isGetter(method)) {
			String attribute = parseGetterSetterAtributte(method);
			result = attributes.get(attribute);
		} else if (isSetter(method)){
			String attribute = parseGetterSetterAtributte(method);
			attributes.put(attribute, args[0]);
		}
		
		return result;
	}

	private String parseGetterSetterAtributte(Method method) {
		return decapitalize(method.getName().substring(3));
	}

	private static boolean isGetter(Method method) {
		return method.getName().startsWith("get") && method.getParameterCount() == 0;
	}
	
	private static boolean isSetter(Method method) {
		return method.getName().startsWith("set") && method.getParameterCount() == 1;
	}
	
	private static String decapitalize(String string){
	    if (string == null || string.length() == 0) {
	        return string;
	    }
	    char c[] = string.toCharArray();
	    c[0] = Character.toLowerCase(c[0]);
	    return new String(c);
	}
}
