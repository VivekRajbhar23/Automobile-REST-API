package com.automobile.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.automobile.entity.Automobile;

@Service
public interface AutomoblieService {

    Automobile saveVehicle(Automobile automobile);

    List<Automobile> findVehicles();

    Optional<Automobile> findByIds(int id);

    Automobile updateVehicle(Automobile automobile);

    boolean deleteVehicles(int id);
}
