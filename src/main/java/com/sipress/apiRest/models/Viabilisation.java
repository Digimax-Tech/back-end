
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
    private double urbanisation;
    @Transient
    private  double totalUrbanisation;
    private double  geometrie;
    @Transient
    private  double totalGeometrie;

    private double adductionDeeau;
    @Transient
    private double totalAdductionDeau;
    private  double Voirie;
    @Transient
    private  double totalVoirie;
    private  double terrassement;
    @Transient
    private  double totalTerrassement;
    private  double eletrification;
    @Transient
    private  double totalElectrification;
    private double assainissement;
    @Transient
    private  double totalAssainissement;

    private  double telephone;
    @Transient
    private  double totalTelephone;
    private double marge;
    @Transient
    private  double totalMarge;
    private  double diversImprevus;
    @Transient
    private  double totalDiversImprevus;
    private  double fraisDeGestion;
    @Transient
    private  double totalFraisGestion;
    private  double fraisFinancier;
    @Transient
    private double totalFraisFinancer;


}




