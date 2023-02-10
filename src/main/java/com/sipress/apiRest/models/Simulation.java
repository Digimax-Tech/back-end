package com.sipress.apiRest.models;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Simulation {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;
   private  String nom;

    @OneToOne
   private  EtudeFoncier etudeFoncier;
    @OneToOne
    private  Foncier foncier;

  @OneToOne
    private Viabilisation viabilisation;

   @ManyToOne
   private  Project project;

}
