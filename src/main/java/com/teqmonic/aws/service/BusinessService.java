package com.teqmonic.aws.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.teqmonic.aws.model.Business;
import com.teqmonic.aws.repository.BusinessRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class BusinessService {

	private final BusinessRepository businessRepository;

	public Business getBusinessDetails(String id, String dateRange) {
		return businessRepository.getBusinessById(id, dateRange);
	}
	
	public void saveBusinessDetails(Business business) {
		businessRepository.saveBusinessDetails(business);
	}
	
	public void updateBusinessDetails(String id, String dateRangeint, int numberOfEmployees) {
		businessRepository.updateBusinessDetails(id, dateRangeint, numberOfEmployees);
	}
	
	public List<Business> getBusinessList(String id, String date) {
		return businessRepository.queryBusinessDetailsUsingLSI(id, date);
	}
	
	public List<Business> getBusinessListUsingName(String name) {
		return businessRepository.queryBusinessDetailsUsingGSI(name);
	}
	
	public void deleteBusinessDetails(String id, String dateRange) {
		businessRepository.deleteBusinessDetails(id, dateRange);
	}
}
