package com.teqmonic.aws.util;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTypeConverter;
import com.teqmonic.aws.model.ContactType;

public class ContactTypeConverterUtil implements DynamoDBTypeConverter<String, ContactType>{

	@Override
	public String convert(ContactType object) {
		return object.name();
	}

	@Override
	public ContactType unconvert(String object) {
		return ContactType.valueOf(object);
	}

}
