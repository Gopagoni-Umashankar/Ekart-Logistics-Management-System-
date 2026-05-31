package com.example.Ekart.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Ekart.entity.Unloading;

@Repository
public interface UnloadingRepo extends JpaRepository<Unloading,Integer>
{

}
