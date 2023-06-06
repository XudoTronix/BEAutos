package com.example.demo.services;

import com.example.demo.model.Auto;
import com.example.demo.model.Chofer;
import com.example.demo.repository.ChoferRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigurationPackage;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

import java.util.List;

import static org.springframework.http.HttpStatus.*;
import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;

@Service
public class ChoferService {

    private List<Chofer> chofer;
    private final ChoferRepository choferRepository;
    @Autowired
    public ChoferService(ChoferRepository repository) {
        this.choferRepository = repository;
    }

    public ResponseEntity addChofer(Chofer chofer) {
        try{
            choferRepository.save(chofer);
            return ResponseEntity.status(CREATED).build();
        }
        catch (Exception e){
            return ResponseEntity.status(INTERNAL_SERVER_ERROR).build();
        }
    }
    // Read
    public List<Chofer> getAllChofer() {
        return choferRepository.findAll();
    }
    // Update
    public ResponseEntity udpateChofer(Integer id,Chofer chofer) {
            try {
            Chofer choferTemporaly = choferRepository.findById(id).orElseThrow(() -> new HttpClientErrorException(HttpStatus.BAD_REQUEST,"Chofer no encontrado"));
            choferTemporaly.setChofer_id(chofer.getChofer_id());
            choferTemporaly.setNombre(chofer.getNombre());
            choferRepository.save(choferTemporaly);
            return ResponseEntity.status(OK).build();
        }
        catch (Exception e){
            return ResponseEntity.status(INTERNAL_SERVER_ERROR).build();
        }
    }
    // Delete
    public ResponseEntity deleteChofer(Integer id){
        try { choferRepository.deleteById(id);
            return ResponseEntity.status(OK).build();
        }
        catch (Exception e){
            return ResponseEntity.status(INTERNAL_SERVER_ERROR).build();
        }
    }
}
