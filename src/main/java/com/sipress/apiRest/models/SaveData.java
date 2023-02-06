package com.sipress.apiRest.models;

import javax.persistence.Transient;

public class SaveData {

    @Transient
    private long prix_achat_terrain_m;
    @Transient
    private double surface_foncier;
    @Transient
    private  static  long prix_achat_terrain;
    @Transient
    private double pourcent_honoraire;
    @Transient
    private double pourcent_enreg;
    @Transient
    private double frais_gen;



    static double frais(double honoraire ,
                        double pourcent_honoraire,
                        double fraisEnregistrement,
                        double pourcent_enreg,
                        double fraisGeneraux,
                        double frais_mut)
    {
        honoraire =prix_achat_terrain*(pourcent_honoraire/100);
        fraisEnregistrement= (pourcent_enreg / 100) * prix_achat_terrain;
        fraisGeneraux= ((1 / 100) * prix_achat_terrain) + 7000;
        double totalFrais =honoraire + fraisEnregistrement + fraisGeneraux;
        return totalFrais;
    }
}
