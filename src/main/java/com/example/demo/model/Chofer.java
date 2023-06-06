package com.example.demo.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.jetbrains.annotations.NotNull;

@Data
@AllArgsConstructor
@Entity
public class Chofer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int chofer_id;
    private String nombre;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "auto_id")
    private Auto auto;

    public Chofer(String nombre) {
        this.nombre = nombre;
    }

    public Chofer(){ }
}
