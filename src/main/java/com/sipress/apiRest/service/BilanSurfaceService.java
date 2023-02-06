package com.sipress.apiRest.service;

import com.sipress.apiRest.models.BilanSurface;
import com.sipress.apiRest.models.EtudeFoncier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface BilanSurfaceService {

     BilanSurface saveBilanSurface(BilanSurface bilanSurface);
     //List<BilanSurface> searchBilanSurface(String query);
     List<BilanSurface> fetchBilanSurfaceList();
     BilanSurface updateBilanSurfacer(BilanSurface bilanSurface, Long id);
     Optional<BilanSurface> findBilanSurfaceById(Long id);

     void deleteBilanSurfaceById(Long id);



}


