package com.example.Ekart.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Ekart.entity.Customer;

public interface CustomerRepo extends JpaRepository<Customer,Integer>
{
    Optional<Customer>findByMobno(long mobno);


	
}
