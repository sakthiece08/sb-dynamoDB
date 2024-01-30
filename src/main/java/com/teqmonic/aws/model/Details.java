package com.teqmonic.aws.model;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Details {
	
	//@DynamoDBAttribute(attributeName = "market_cap")
	private String marketCap;
	
	//@DynamoDBAttribute(attributeName = "book_value")
	private String bookValue;
	
	//@DynamoDBAttribute(attributeName = "face_value")
	private String faceValue;

}
