package com.busraciftlik.starbucksproject.adapters;

import com.busraciftlik.starbucksproject.business.abstracts.CustomerCheckService;
import com.busraciftlik.starbucksproject.entities.Customer;

import java.util.Random;

//@Service
public class FakeCustomerCheckManager implements CustomerCheckService {
    @Override
    public boolean checkIfRealCustomer(Customer customer) {
        return new Random().nextBoolean();
    }
}
