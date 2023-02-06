package com.sipress.apiRest.service;

import com.sipress.apiRest.models.Foncier;
import com.sipress.apiRest.models.Project;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface FoncierService {

     Foncier saveFoncier(Foncier foncier);
     List<Foncier> searchFonciers(String query);
     List<Foncier> fetchFoncierList();
     Foncier updateFoncier(Foncier foncier, Long id);
     Optional<Foncier> findFoncierById(Long id);

     void deleteFoncierById(Long id);



}

