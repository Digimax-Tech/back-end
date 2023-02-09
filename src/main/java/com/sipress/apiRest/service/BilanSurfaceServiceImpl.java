package com.sipress.apiRest.service;

import com.sipress.apiRest.models.BilanSurface;
import com.sipress.apiRest.repository.BilanSurfaceRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BilanSurfaceServiceImpl implements BilanSurfaceService {
    private BilanSurfaceRepository bilanSurfaceRepository;

    public BilanSurfaceServiceImpl(BilanSurfaceRepository bilanSurfaceRepository) {
        this.bilanSurfaceRepository = bilanSurfaceRepository;
    }

    @Override
    public BilanSurface saveBilanSurface(BilanSurface bilanSurface) {
        return bilanSurfaceRepository.save(bilanSurface);
    }
//
//    @Override
//    public List<BilanSurface> searchBilanSurface(String query) {
//        return null;
//    }

    @Override
    public List<BilanSurface> fetchBilanSurfaceList() {
        return bilanSurfaceRepository.findAll();
    }

    @Override
    public BilanSurface updateBilanSurfacer(BilanSurface bilanSurface, Long id) {
        BilanSurface bilanSurface1 = bilanSurfaceRepository.findById(id).get();
        bilanSurface.setId(bilanSurface1.getId());
        bilanSurface.setCuisine(bilanSurface1.getCuisine());
        bilanSurface.setChambre(bilanSurface1.getChambre());
        bilanSurface.setDemenagement(bilanSurface1.getDemenagement());
        bilanSurface.setEspaceFamiliale(bilanSurface1.getEspaceFamiliale());
        bilanSurface.setPocheDentre(bilanSurface1.getPocheDentre());
        bilanSurface.setSalon(bilanSurface1.getSalon());
        bilanSurface.setSejour(bilanSurface1.getSejour());
        bilanSurface.setHallDentre(bilanSurface1.getHallDentre());
        bilanSurface.setTerrasse(bilanSurface1.getTerrasse());
        bilanSurface.setToilette(bilanSurface1.getToilette());

        return bilanSurfaceRepository.save(bilanSurface1);
    }

    @Override
    public Optional<BilanSurface> findBilanSurfaceById(Long id) {
        return  bilanSurfaceRepository.findById(id);
    }

    @Override
    public void deleteBilanSurfaceById(Long id) {
        bilanSurfaceRepository.deleteById(id);

    }
}
