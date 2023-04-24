package com.arlanda.customer;

public record CustomerRegistrationRequest (
        String name,
        String email,
        Integer age
){
}
