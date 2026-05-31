package com.example.Ekart.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Ekart.entity.Address;

@Repository
public interface AddressRepo extends JpaRepository<Address,Integer>
{
	Optional<Address>findByCity(String city);

}
