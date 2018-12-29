package com.util;

import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;

public final class JacksonUtils {
	private static final ObjectMapper objectMapper;

	static {
		objectMapper = new ObjectMapper();
		SimpleModule simpleModule = new SimpleModule();
		simpleModule.addSerializer(Long.class, ToStringSerializer.instance);
		simpleModule.addSerializer(Long.TYPE, ToStringSerializer.instance);
		objectMapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
		objectMapper.registerModule(simpleModule);
	}

	public static String toJson(Object obj) {
		try {
			return objectMapper.writeValueAsString(obj);
		} catch (JsonProcessingException e) {
			throw new RuntimeException(e);
		}
	}

	public static <T> T toObject(String json, Class<T> cl) {
		try {
			return objectMapper.readValue(json, cl);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	public static <T> List<T> toList(String json, Class<T> cl) {
		JavaType javaType = getCollectionType(List.class, cl);
		try {
			return objectMapper.readValue(json, javaType);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	private static JavaType getCollectionType(Class<?> collectionClass, Class<?>... elementClasses) {
		return objectMapper.getTypeFactory().constructParametricType(collectionClass, elementClasses);
	}
}