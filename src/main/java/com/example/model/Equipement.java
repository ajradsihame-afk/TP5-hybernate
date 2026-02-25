package com.example.model;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "equipements")
public class Equipement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Le nom est obligatoire")
    @Column(nullable = false)
    private String nom;

    @Size(max = 500, message = "La description ne peut pas dépasser 500 caractères")
    @Column(length = 500)
    private String description;

    @ManyToMany(mappedBy = "equipements")
    private Set<Salle> salles = new HashSet<>();

    // Constructeurs, getters, setters
    // ...
    // Constructeur par défaut
    public Equipement() {
    }

    // Constructeur avec paramètres
    public Equipement(String nom, String description) {
        this.nom = nom;
        this.description = description;
    }

    // Constructeur avec tous les attributs
    public Equipement(Long id, String nom, String description, Set<Salle> salles) {
        this.id = id;
        this.nom = nom;
        this.description = description;
        this.salles = salles;
    }


}