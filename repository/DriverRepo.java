package com.example.Ekart.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Ekart.entity.Driver;

@Repository
public interface DriverRepo extends JpaRepository<Driver, Integer>
{
	Optional<Driver> findByContact(long Contact);

}
