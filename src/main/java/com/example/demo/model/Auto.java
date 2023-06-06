package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@Entity
public class Auto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int auto_id;
    private String plate;
    @OneToMany(mappedBy = "auto")
    @JsonIgnore
    private List<Chofer> choferes;

    public Auto(String plate) {
        this.plate = plate;
    }

    public Auto() { }


}
