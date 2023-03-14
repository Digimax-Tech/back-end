
package com.sipress.apiRest.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Frais{
    @Id @GeneratedValue(strategy = GenerationType.TABLE)
    private  Long id;
    @Transient
    private  double pourcent_enreg;
    @Transient
    private  double prix_achat_terrain;
    @Transient
    private  double pourcent_honoraire;
    @Transient
    private  double Totalhonoraire = prix_achat_terrain*(pourcent_honoraire/100);
    @Transient
    private  double TotalfraisEnregistrement =(pourcent_enreg / 100) * prix_achat_terrain;
    @Transient
    private  double TotalfraisGeneraux = ((1 / 100) * prix_achat_terrain) + 7000;
    @Transient
    private  double totalFrais = Totalhonoraire + TotalfraisEnregistrement + TotalfraisGeneraux;;



    @Transient
    private int constant_mut = 7000;
    private  double honoraire ;
    private  double fraisEnregistrement;
    private  double fraisGeneraux;

//    @OneToOne(mappedBy = "frais")
//    private Simulation simulation;
}


