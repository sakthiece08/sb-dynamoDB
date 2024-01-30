package com.teqmonic.aws.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.teqmonic.aws.model.Business;
import com.teqmonic.aws.service.BusinessService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
public class BusinessController {
	
	private final BusinessService businessService;
	
	@GetMapping("/business/{id}/date_range/{dateRange}")
	public Business getBusinessDetails(@PathVariable String id, @PathVariable String dateRange) {
		return businessService.getBusinessDetails(id, dateRange);
	}

	@PostMapping("/business")
	public void saveBusinessDetails(@RequestBody Business business) {
		 businessService.saveBusinessDetails(business);
	}
	
	@PatchMapping("/business/{id}/date_range/{dateRange}/no_employees/{numberOfEmployees}")
	public void updateBusinessDetails(@PathVariable String id, @PathVariable String dateRange, @PathVariable int numberOfEmployees) {
		 businessService.updateBusinessDetails(id, dateRange, numberOfEmployees);
	}
	
	@GetMapping("/business/{id}/date/{date}")
	public List<Business> getBusinessList(@PathVariable String id, @PathVariable String date) {
		return businessService.getBusinessList(id, date);
	}
	
	@GetMapping("/business/{name}")
	public List<Business> getBusinessListGSI(@PathVariable String name) {
		return businessService.getBusinessListUsingName(name);
	}
	
	@DeleteMapping("/business/{id}/date_range/{dateRange}")
	public void deleteBusinessDetails(@PathVariable String id, @PathVariable String dateRange) {
		 businessService.deleteBusinessDetails(id, dateRange);
	}
}
