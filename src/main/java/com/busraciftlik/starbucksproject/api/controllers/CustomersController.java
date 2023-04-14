package com.busraciftlik.starbucksproject.api.controllers;

import com.busraciftlik.starbucksproject.business.abstracts.CustomerService;
import com.busraciftlik.starbucksproject.business.dto.requests.CreateCustomerRequest;
import com.busraciftlik.starbucksproject.business.dto.responses.CreateCustomerResponse;
import com.busraciftlik.starbucksproject.business.dto.responses.get.GetAllCustomersResponse;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/customers")
@AllArgsConstructor
public class CustomersController {
    private final CustomerService service;
    @GetMapping
    public List<GetAllCustomersResponse> getAll(){
        return service.getAll();
    }
    @PostMapping
    public CreateCustomerResponse add(@RequestBody CreateCustomerRequest request){
        return service.add(request);
    }
}
