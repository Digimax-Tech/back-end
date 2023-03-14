
package com.sipress.apiRest.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class EtudeFoncier {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;
    private String designation;
    private String designation1;
    private double surface;
    private double surface1;
    private double nombrePieges;
    private double nombrePieges1;
    private double nombreVilla;
    private double nombreVilla1;
    private double nombreVillaTotal;
    private String designationImmeuble;
    private String designationImmeuble1;
    private double nombrePiegesImmeuble;
    private double nombrePiegesImmeuble1;
    private double nombreAppart;
    private double nombreAppart1;
    private double surfaceImmeuble;
    private double surfaceImmeuble1;
    private double nombreTotalAppart;

    @ManyToOne
    @JsonIgnore
    private  Project project;

}
