package com.sipress.apiRest.models;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BilanSurface {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;
    private  int pocheDentre;
    private int  sejour;
    private int cuisine;
    private int  salon;
    private int chambre;
    private int hallDentre;
    private int toilette;
    private int demenagement;
    private int espaceFamiliale;
    private int terrasse;



}
