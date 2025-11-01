package com.automobile.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Component;

import com.automobile.entity.Automobile;
import com.automobile.repository.AutomobileRepository;
import com.automobile.service.AutomoblieService;

@Component
public class AutoMobileServiceImpl implements AutomoblieService{

     private AutomobileRepository automobileRepository;

     public AutoMobileServiceImpl(AutomobileRepository automobileRepository)
     {
        this.automobileRepository = automobileRepository;
     }


    @Override
    public Automobile saveVehicle(Automobile automobile) {
        return  automobileRepository.save(automobile);
    }

     @Override
    public Optional<Automobile> findByIds(int id) {
         return automobileRepository.findById(id);
    }

    @Override
    public List<Automobile> findVehicles() {
         return automobileRepository.findAll();
    }

    @Override
    public Automobile updateVehicle(Automobile automobile) {
       return automobileRepository.save(automobile);
    }

    @Override
    public boolean deleteVehicles(int id) {

     if (automobileRepository.existsById(id)) {
          automobileRepository.deleteById(id);
          return true;
     }
         return false;
    }
}
