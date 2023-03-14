package com.sipress.apiRest.service;

import com.sipress.apiRest.models.Foncier;
import com.sipress.apiRest.models.Project;
import com.sipress.apiRest.repository.FoncierRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FoncierServiceImpl implements FoncierService {
    private FoncierRepository foncierRepository;

    public FoncierServiceImpl(FoncierRepository foncierRepository) {
        this.foncierRepository = foncierRepository;
    }

    @Override
    public Foncier saveFoncier(Foncier foncier) {
        return foncierRepository.save(foncier);
    }

    @Override
    public List<Foncier> fetchFoncierList() {
        return foncierRepository.findAll();
    }

    @Override
    public Foncier updateFoncier(Foncier foncier, Long id) {
        Foncier foncier1 = foncierRepository.findById(id).get();
        foncier.setId(foncier1.getId());
        foncier.setProject(foncier1.getProject());
        foncier.setTitrePropriete(foncier1.getTitrePropriete());
        foncier.setSurfaceTerrain(foncier1.getSurfaceTerrain());
        foncier.setPrixMaitreCarre(foncier1.getPrixMaitreCarre());
        foncier.setSurfaceTerrain(foncier1.getSurfaceTerrain());
        return  foncierRepository.save(foncier1);
    }

    @Override
    public Optional<Foncier> findFoncierById(Long id) {
        return foncierRepository.findById(id);
    }

    @Override
    public void deleteFoncierById(Long id) {
        foncierRepository.deleteById(id);

    }
}
