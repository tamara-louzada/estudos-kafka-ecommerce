package com.alura.curso.kafka.common.kafka;

import java.util.Map;

import org.apache.kafka.common.serialization.Deserializer;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class GsonDeserializer<T> implements Deserializer<T> {

	public static final String TYPE_CONFIG = "br.com.alura.curso.kafka.type_config";
	
	private final Gson json = new GsonBuilder().create();
	private Class<T> type;

	@Override
	public void configure(Map<String, ?> configs, boolean isKey) {
        String typeName = String.valueOf(configs.get(TYPE_CONFIG));
        try {
            this.type = (Class<T>) Class.forName(typeName);
		} catch (ClassNotFoundException e) {
			throw new RuntimeException("Type para a descerializa��o n�o existe no classpath: ", e);
		}
	}

	@Override
	public T deserialize(String s, byte[] bytes) {
		return json.fromJson(new String(bytes), type);
	}

}
