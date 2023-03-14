
package com.sipress.apiRest.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class EtudeFoncierImmeuble {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;
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
