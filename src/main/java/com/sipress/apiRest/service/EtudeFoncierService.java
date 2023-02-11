package com.sipress.apiRest.service;

import com.sipress.apiRest.models.EtudeFoncier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface EtudeFoncierService {

     EtudeFoncier saveEtudeFoncier(EtudeFoncier etudeFoncier);
     List<EtudeFoncier> searchEtudeFonciers(String query);
     List<EtudeFoncier> fetchEtudeFoncierList();
     EtudeFoncier updateEtudeFoncier(EtudeFoncier etudeFoncier, Long id);
     Optional<EtudeFoncier> findEtudeFoncierById(Long id);

     void deleteEtudeFoncierById(Long id);



}

