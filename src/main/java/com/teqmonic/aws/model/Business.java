package com.teqmonic.aws.model;

import java.util.Date;
import java.util.List;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAutoGeneratedKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBIndexHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBIndexRangeKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBRangeKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTypeConverted;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBVersionAttribute;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.teqmonic.aws.util.DetailsConverterUtil;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@DynamoDBTable(tableName = "teq_business_details")
public class Business {
	
	 @DynamoDBHashKey(attributeName = "business_id")
	 @DynamoDBAutoGeneratedKey
	 private String id;
	 
	 @DynamoDBRangeKey(attributeName = "date_of_commencement")
	 private String doc;
	 
	 @JsonFormat(pattern = "yyyy-MM-dd", shape = JsonFormat.Shape.STRING)
	 @DynamoDBAttribute(attributeName = "date_of_est")
	 private Date dateOfEst;
	 
	 @DynamoDBAttribute(attributeName = "is_active")
	 private Boolean activeFlag;
	 
	 @DynamoDBAttribute(attributeName = "number_of_employees")
	 private Double numberOfEmployees;
	 
	 // GSI
	 @DynamoDBIndexHashKey(attributeName = "name", globalSecondaryIndexName = "name-gsi")
	 private String name;	 
	 
	 // LSI
	 @DynamoDBAttribute(attributeName = "rank")
	 @DynamoDBIndexRangeKey(localSecondaryIndexName = "rank-index")
	 private int rank;
	 
	 @DynamoDBVersionAttribute(attributeName = "version")
	 private Long version;
	 
	 
	 @DynamoDBAttribute(attributeName = "contact_list")
	 private List<Contact> contact;
	 
	 @DynamoDBAttribute(attributeName = "details")
	 @DynamoDBTypeConverted(converter = DetailsConverterUtil.class)
	 private Details details;

}
