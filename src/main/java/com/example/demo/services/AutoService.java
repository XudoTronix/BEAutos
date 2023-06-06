package com.example.demo.services;

import com.example.demo.model.Auto;
import com.example.demo.repository.AutoRepository;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import static org.springframework.http.HttpStatus.*;

@Service
public class AutoService {
    private List<Auto> autos;
    private final AutoRepository autoRepository;
    @Autowired
    public AutoService(AutoRepository repository) {
        this.autoRepository = repository; }
// Create
public ResponseEntity add(Auto auto) {
        try{
            autoRepository.save(auto);
    return ResponseEntity.status(CREATED).build();
        }
        catch (Exception e){
            return ResponseEntity.status(INTERNAL_SERVER_ERROR).build();
        }
    }
// Read
public List<Auto> getAll() {
        return autoRepository.findAll();
    }
// Update
public ResponseEntity udpate(Integer id,Auto auto) {
        try {
            Auto autoTemporaly = autoRepository.findById(id).orElseThrow(() -> new HttpClientErrorException(HttpStatus.BAD_REQUEST,"Car not found"));
            autoTemporaly.setAuto_id(auto.getAuto_id());
            autoTemporaly.setPlate(auto.getPlate());
            autoRepository.save(autoTemporaly);
            return ResponseEntity.status(OK).build();
        }
        catch (Exception e){
            return ResponseEntity.status(INTERNAL_SERVER_ERROR).build();
        }
    }
// Delete
public ResponseEntity deleteAuto(Integer auto_id){
    try { autoRepository.deleteById(auto_id);
            return ResponseEntity.status(OK).build();
        }
        catch (Exception e){
            return ResponseEntity.status(INTERNAL_SERVER_ERROR).build();
        }
    }
}