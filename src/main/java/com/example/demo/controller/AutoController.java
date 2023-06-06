package com.example.demo.controller;

import com.example.demo.model.Auto;
import com.example.demo.services.AutoService;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@RestController
@RequestMapping("/auto")
@CrossOrigin(origins = "*")
public class AutoController {

    @Autowired
    private AutoService autoService;

    @PostMapping("")
    public ResponseEntity add(@RequestBody final @NotNull Auto auto) {

     return autoService.add(auto);
    }

    @GetMapping("/getAll")
    public List<Auto> getAll(){
        return autoService.getAll();
    }

    @PostMapping("/{auto_id}/update")
    public ResponseEntity updateAuto(@PathVariable final @NotNull Integer auto_id, @RequestBody final @NotNull Auto auto){
        return autoService.udpate(auto_id, auto);
    }

    @PostMapping ("/{auto_id}/delete")
    public ResponseEntity delete(@PathVariable Integer auto_id){
        return autoService.deleteAuto(auto_id);
    }
}
