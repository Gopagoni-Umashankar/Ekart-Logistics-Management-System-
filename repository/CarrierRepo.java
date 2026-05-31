package com.example.Ekart.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Ekart.entity.Carrier;

@Repository
public interface CarrierRepo extends JpaRepository<Carrier,Integer>
{

	 Optional<Carrier>findBymobno(long mobno);
	 
	 Optional<Carrier>findByMail(String mail);

}
