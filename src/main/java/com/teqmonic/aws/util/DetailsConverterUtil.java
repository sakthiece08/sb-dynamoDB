package com.teqmonic.aws.util;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTypeConverter;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.teqmonic.aws.model.Details;

public class DetailsConverterUtil implements DynamoDBTypeConverter<String, Details>{
	
	private final ObjectMapper objectMapper = new ObjectMapper();

	@Override
	public String convert(Details details) {
		try {
			return objectMapper.writeValueAsString(details);
		} catch (JsonProcessingException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public Details unconvert(String value) {
		try {
			return objectMapper.readValue(value, Details.class);
		} catch (JsonProcessingException e) {
			throw new RuntimeException(e);
		}
	}

}
