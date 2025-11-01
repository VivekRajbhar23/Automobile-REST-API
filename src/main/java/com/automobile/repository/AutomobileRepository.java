package com.automobile.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.automobile.entity.Automobile;

@Repository
public interface AutomobileRepository extends JpaRepository<Automobile,Integer>{

  
}
