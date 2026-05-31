package com.example.Ekart.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Ekart.entity.Truck;

@Repository
public interface TruckRepo extends JpaRepository<Truck,Integer>
{
	Optional<Truck> findByNumber(String Number);
}
