package com.example.demo.controller;

import com.example.demo.model.Auto;
import com.example.demo.model.Chofer;
import com.example.demo.services.AutoService;
import com.example.demo.services.ChoferService;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/chofer")
public class ChoferController {

    @Autowired
    private ChoferService choferService;

    @PostMapping("")
    public ResponseEntity addChofer(@RequestBody final @NotNull Chofer chofer) {

        return choferService.addChofer(chofer);
    }

    @GetMapping("/getAll")
    public List<Chofer> getAllChofer(){
        return choferService.getAllChofer();
    }

    @PostMapping("/{id}/Update")
    public ResponseEntity updateChofer(@PathVariable final @NotNull Integer id, @RequestBody final @NotNull Chofer chofer){
        return choferService.udpateChofer(id, chofer);
    }

    @PostMapping ("/{id}/Delete")
    public ResponseEntity deleteChofer(Integer id){
        return choferService.deleteChofer(id);
    }
}

