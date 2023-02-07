package com.sipress.apiRest.service;

import com.sipress.apiRest.models.Frais;
import com.sipress.apiRest.models.Viabilisation;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface ViabilisationService {

     Viabilisation  saveViabilisation(Viabilisation viabilisation);
//     List<Frais> searchFrais(String query);
     List<Viabilisation> fetchViabilisationList();
     Viabilisation updateViabilisation(Viabilisation viabilisation, Long id);
     Optional<Viabilisation> findViabilisationById(Long id);

     void deleteViabilisationById(Long id);






}

