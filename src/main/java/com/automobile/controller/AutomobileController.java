package com.automobile.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.automobile.entity.Automobile;
import com.automobile.serviceImpl.AutoMobileServiceImpl;

@RestController
public class AutomobileController {

       private AutoMobileServiceImpl autoMobileServiceImpl;

       public AutomobileController(AutoMobileServiceImpl autoMobileServiceImpl) {
              this.autoMobileServiceImpl = autoMobileServiceImpl;
       }

       @PostMapping("/vehicles")
       public ResponseEntity<Automobile> addVehicle(@RequestBody Automobile automobile) {
              Automobile am = null;
              am = autoMobileServiceImpl.saveVehicle(automobile);
              if (am == null) {
                     return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(am);
              } else {
                     return ResponseEntity.status(HttpStatus.CREATED).body(am);
              }
       }

       @GetMapping("/vehicles")
       public ResponseEntity<List<Automobile>> findVehicle() {
              List<Automobile> automobiles = autoMobileServiceImpl.findVehicles();

              if (automobiles == null || automobiles.isEmpty()) {
                     return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
              } else {
                     return ResponseEntity.ok(automobiles);
              }
       }

       @GetMapping("/vehicles/{vehicleId}")
       public ResponseEntity<Optional<Automobile>> findVehicleById(@PathVariable("vehicleId") int id) {
              Optional<Automobile> vId = autoMobileServiceImpl.findByIds(id);
              System.out.println("HERE WE FOUND THE VID " + vId);
              if (vId.isEmpty()) {
                     return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
              } else {
                     return ResponseEntity.status(HttpStatus.FOUND).body(vId);
              }
       }

       @DeleteMapping("/vehicles/{vehicleId}")
       public ResponseEntity<String> deleteVehicle(@PathVariable("vehicleId") int id) {
              boolean deleted = autoMobileServiceImpl.deleteVehicles(id);
              if (deleted) {
                     return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Deleted sucessfully!");
              } else {
                     return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No data found!");
              }
       }

       @PutMapping("/vehicles/{vehicleId}")
       public ResponseEntity<String> update(@RequestBody Automobile automobile, @PathVariable("vehicleId") int id) {
              Automobile updateAutomobile = autoMobileServiceImpl.updateVehicle(automobile);

              if (updateAutomobile != null) {
                     return ResponseEntity.status(HttpStatus.OK).body("Updated Sucessfully!");
              } else {
                     return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No data found!");
              }
       }
}
