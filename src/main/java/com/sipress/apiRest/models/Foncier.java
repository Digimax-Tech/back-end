
package com.sipress.apiRest.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class Foncier {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;
    private String titrePropriete;
    private double surfaceTerrain;
    private double prixMaitreCarre;
    private double prixTerrain;

    @ManyToOne
    private  Project project;


}


