package com.sipress.apiRest.service;

import com.sipress.apiRest.models.EtudeFoncier;
import com.sipress.apiRest.models.EtudeFoncierImmeuble;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface EtudeFoncierImmeubleService {

     EtudeFoncierImmeuble saveEtudeFoncierImmeuble(EtudeFoncierImmeuble etudeFoncierImmeuble);
     List<EtudeFoncierImmeuble> searchEtudeFonciers(String query);
     List<EtudeFoncierImmeuble> fetchEtudeFoncierImmeubleList();
     EtudeFoncierImmeuble updateEEtudeFoncierImmeuble(EtudeFoncierImmeuble etudeFoncierImmeuble, Long id);
     Optional<EtudeFoncierImmeuble> findEtudeFoncierImmeubleById(Long id);

     void deleteEtudeFoncierImmeubleById(Long id);



}

