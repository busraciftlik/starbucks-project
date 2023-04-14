package com.busraciftlik.starbucksproject.business.abstracts;

import com.busraciftlik.starbucksproject.business.dto.requests.CreateCustomerRequest;
import com.busraciftlik.starbucksproject.business.dto.responses.CreateCustomerResponse;
import com.busraciftlik.starbucksproject.business.dto.responses.get.GetAllCustomersResponse;

import java.util.List;

public interface CustomerService {
    List<GetAllCustomersResponse> getAll();
    CreateCustomerResponse add(CreateCustomerRequest request);
}
