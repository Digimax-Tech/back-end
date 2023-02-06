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
        bilanSurface.setBet(bilanSurface1.getBet());
        bilanSurface.setAdductionDeeau(bilanSurface1.getAdductionDeeau());
        bilanSurface.setAssainissement(bilanSurface1.getAssainissement());
        bilanSurface.setDiversImprevus(bilanSurface1.getDiversImprevus());
        bilanSurface.setEletrification(bilanSurface1.getEletrification());
        bilanSurface.setFraisDeGestion(bilanSurface1.getFraisDeGestion());
        bilanSurface.setFraisFinancier(bilanSurface1.getFraisFinancier());
        bilanSurface.setGeometrie(bilanSurface1.getGeometrie());
        bilanSurface.setMarge(bilanSurface1.getMarge());
        bilanSurface.setTelephone(bilanSurface1.getTelephone());
        bilanSurface.setTerrassement(bilanSurface1.getTerrassement());
        bilanSurface.setVoirie(bilanSurface1.getVoirie());

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
