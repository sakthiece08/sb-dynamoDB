package com.teqmonic.aws.model;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBDocument;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTypeConverted;
import com.teqmonic.aws.util.ContactTypeConverterUtil;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@DynamoDBDocument
public class Contact {
	@DynamoDBTypeConverted(converter = ContactTypeConverterUtil.class)
	@DynamoDBAttribute(attributeName = "contact_type")
	private ContactType contactType;
	@DynamoDBAttribute(attributeName = "value")
	private String value;

}
