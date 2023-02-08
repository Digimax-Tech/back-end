package com.sipress.apiRest.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
//@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
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
  //  private  double total;
//    @OneToMany(mappedBy = "project")
//    private List<Foncier> fonciers =new ArrayList<>();


}
