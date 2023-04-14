package com.busraciftlik.starbucksproject.business.ex;

public class InvalidCustomerException extends RuntimeException {
    public InvalidCustomerException(String firstName, String lastName) {
        super(firstName + " " + lastName);
    }
}
