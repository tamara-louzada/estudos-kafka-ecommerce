package com.alura.curso.kafka.common.kafka;

import org.apache.kafka.common.serialization.Serializer;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class GsonSerializer<T> implements Serializer<T> {

	private Gson json = new GsonBuilder().create();

	@Override
	public byte[] serialize(String topic, T object) {
		return json.toJson(object).getBytes();
	}

}
