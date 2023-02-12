
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
    private double surface;
    private double nombrePieges;
    private double nombreVilla;

    @OneToOne
    @JsonIgnore
    private  Project project;

}
