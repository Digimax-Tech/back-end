package com.sipress.apiRest.models;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BilanSurface {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;
    private  int bet;
    private int  adductionDeeau;
    private int Voirie;
    private int  geometrie;
    private int terrassement;
    private int eletrification;
    private int assainissement;
    private int telephone;
    private int marge;
    private int diversImprevus;
    private int fraisDeGestion;
    private int fraisFinancier;


}
