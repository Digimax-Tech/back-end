package com.sipress.apiRest.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public  class Project {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;
    private String nom;
    private String promoteur;
    private String site;
    private String ville;
    private  String description;
    private String titrePropriete;
    private double surfaceTerrain;
    private double prixMaitreCarre;
    private double prixTerrain;


    @CreationTimestamp
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date createdAt;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "project")
    @JsonIgnore
    private List<EtudeFoncier> etudeFonciers;

    @OneToMany(mappedBy = "project")
    @JsonIgnore
    private  List<Foncier> fonciers;

    @Enumerated(EnumType.STRING)
    private ProjectStatus status;

//    @ManyToOne
//    private  Simulation simulation;




}
