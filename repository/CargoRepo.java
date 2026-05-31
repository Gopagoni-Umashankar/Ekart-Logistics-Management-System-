package com.example.Ekart.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Ekart.entity.Cargo;

@Repository
public interface CargoRepo extends JpaRepository<Cargo,Integer>
{

}
