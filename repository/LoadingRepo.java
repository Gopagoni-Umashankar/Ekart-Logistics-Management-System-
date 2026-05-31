package com.example.Ekart.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Ekart.entity.Loading;

@Repository
public interface LoadingRepo extends JpaRepository<Loading, Integer>
{

}
