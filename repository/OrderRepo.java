package com.example.Ekart.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Ekart.entity.Orders;

@Repository
public interface OrderRepo extends JpaRepository<Orders,Integer>
{
    
}
