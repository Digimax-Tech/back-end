
package com.sipress.apiRest.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Foncier{
    @Id @GeneratedValue(strategy = GenerationType.TABLE)
    private  Long id;
    private String nom;
    private double surface;
    private double prix;
    private double prixTerrain;
    private  double total;
//    @ManyToOne
//    private  Project project;

}
