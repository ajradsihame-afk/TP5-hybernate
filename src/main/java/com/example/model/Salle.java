package com.example.model;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "salles")
public class Salle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Le nom est obligatoire")
    @Column(nullable = false)
    private String nom;

    @NotNull(message = "La capacité est obligatoire")
    @Min(value = 1, message = "La capacité minimum est de 1 personne")
    @Column(nullable = false)
    private Integer capacite;

    @Size(max = 500, message = "La description ne peut pas dépasser 500 caractères")
    @Column(length = 500)
    private String description;

    @Column(name = "batiment")
    private String batiment;

    @Column(name = "etage")
    private Integer etage;

    @OneToMany(mappedBy = "salle", cascade = CascadeType.ALL)
    private List<Reservation> reservations = new ArrayList<>();

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(
            name = "salle_equipement",
            joinColumns = @JoinColumn(name = "salle_id"),
            inverseJoinColumns = @JoinColumn(name = "equipement_id")
    )
    private Set<Equipement> equipements = new HashSet<>();

    public Salle(String nom, Integer capacite) {
        this.nom = nom;
        this.capacite = capacite;
    }

    public void setDescription(String salleDeRéunionStandard) {
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setCapacite(Integer capacite) {
        this.capacite = capacite;
    }

    public void setBatiment(String batiment) {
        this.batiment = batiment;
    }

    public void setEtage(Integer etage) {
        this.etage = etage;
    }
    // Constructeurs, getters, setters et méthodes utilitaires
    // ...

    public Long getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public Integer getCapacite() {
        return capacite;
    }

    public String getDescription() {
        return description;
    }

    public String getBatiment() {
        return batiment;
    }

    public Integer getEtage() {
        return etage;
    }

    public void addEquipement(Equipement projecteur) {
    }

    public void setReservations(List<Reservation> reservations) {
        this.reservations = reservations;
    }

    public void setEquipements(Set<Equipement> equipements) {
        this.equipements = equipements;
    }

    public List<Reservation> getReservations() {
        return reservations;
    }

    public Set<Equipement> getEquipements() {
        return equipements;
    }

    public Salle() {
    }

    public Salle(Long id, String nom, Integer capacite, String description, String batiment, Integer etage, List<Reservation> reservations, Set<Equipement> equipements) {
        this.id = id;
        this.nom = nom;
        this.capacite = capacite;
        this.description = description;
        this.batiment = batiment;
        this.etage = etage;
        this.reservations = reservations;
        this.equipements = equipements;
    }

    public Salle(String nom, Integer capacite, String description, String batiment, Integer etage, List<Reservation> reservations, Set<Equipement> equipements) {
        this.nom = nom;
        this.capacite = capacite;
        this.description = description;
        this.batiment = batiment;
        this.etage = etage;
        this.reservations = reservations;
        this.equipements = equipements;
    }
}