package com.sipress.apiRest.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.catalina.LifecycleState;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public  class Project {
    @Id @GeneratedValue(strategy = GenerationType.TABLE)
    private  Long id;
    private String nom;
    private String promoteur;
    private String site;
    private String ville;
    private  String description;
    private String titrePropriete;
    private double surfaceTerrain;
    private double prixMaitreCarre;
    private double prixTerrain;

    private  double total;

    @OneToOne(mappedBy = "project")
    @JsonIgnore
    private  EtudeFoncier etudeFoncier;


//    @OneToMany(mappedBy = "project")
//    private List<Simulation> simulations;

}
