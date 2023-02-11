
package com.sipress.apiRest.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Viabilisation {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;
    private double bet;
    private double  geometrie;
    private double adductionDeeau;
    private  double Voirie;
    private  double terrassement;
    private  double eletrification;
    private double assainissement;
    private  double telephone;
    private double marge;
    private  double diversImprevus;
    private  double fraisDeGestion;
    private  double fraisFinancier;


    @OneToOne(mappedBy = "viabilisation")
    private  Simulation simulation;

}




