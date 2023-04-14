package com.busraciftlik.starbucksproject.business.abstracts;

import com.busraciftlik.starbucksproject.entities.Customer;

public interface CustomerCheckService {
    boolean checkIfRealCustomer(Customer customer);
}
