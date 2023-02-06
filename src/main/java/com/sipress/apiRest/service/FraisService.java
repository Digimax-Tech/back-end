package com.sipress.apiRest.service;

import com.sipress.apiRest.models.Foncier;
import com.sipress.apiRest.models.Frais;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface FraisService {

     Frais saveFrais(Frais frais);
//     List<Frais> searchFrais(String query);
     List<Frais> fetchFraisList();
     Frais updateFrais(Frais frais, Long id);
     Optional<Frais> findFraisById(Long id);

     void deleteFraisById(Long id);






}

