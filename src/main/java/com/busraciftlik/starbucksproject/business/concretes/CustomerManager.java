package com.busraciftlik.starbucksproject.business.concretes;

import com.busraciftlik.starbucksproject.business.abstracts.CustomerCheckService;
import com.busraciftlik.starbucksproject.business.abstracts.CustomerService;
import com.busraciftlik.starbucksproject.business.dto.requests.CreateCustomerRequest;
import com.busraciftlik.starbucksproject.business.dto.responses.CreateCustomerResponse;
import com.busraciftlik.starbucksproject.business.dto.responses.get.GetAllCustomersResponse;
import com.busraciftlik.starbucksproject.business.ex.InvalidCustomerException;
import com.busraciftlik.starbucksproject.entities.Customer;
import com.busraciftlik.starbucksproject.repository.CustomerRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class CustomerManager implements CustomerService {
    private final CustomerRepository repository;
    private final ModelMapper mapper;
    private final CustomerCheckService customerCheckService;

    @Override
    public List<GetAllCustomersResponse> getAll() {
        List<Customer> customers = repository.findAll();
        List<GetAllCustomersResponse> responses = customers.stream()
                .map(customer -> mapper.map(customer, GetAllCustomersResponse.class)).collect(Collectors.toList());
        return responses;
    }

    @Override
    public CreateCustomerResponse add(CreateCustomerRequest request) {
        Customer customer = mapper.map(request, Customer.class);
        customer.setId(0);
        validateCustomer(request, customer);
        repository.save(customer);

        return mapper.map(customer, CreateCustomerResponse.class);
    }

    private void validateCustomer(CreateCustomerRequest request, Customer customer) {
        if (!customerCheckService.checkIfRealCustomer(customer)) {
            throw new InvalidCustomerException(request.getFirstName(), request.getLastName());

        }
    }
}
