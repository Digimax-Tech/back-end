package com.sipress.apiRest.service;

import com.sipress.apiRest.models.Foncier;
import com.sipress.apiRest.repository.FoncierRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FoncierServiceImpl implements FoncierService {
    private FoncierRepository foncierRepository;

    public FoncierServiceImpl(FoncierRepository foncierRepository){
        this.foncierRepository = foncierRepository;

    }

    @Override
    public Foncier saveFoncier(Foncier foncier) {
        return foncierRepository.save(foncier);
    }

    @Override
    public List<Foncier> searchFonciers(String query) {
        List<Foncier> fonciers = foncierRepository.searchFonciers(query);
        return fonciers;

    }

    @Override
    public List<Foncier> fetchFoncierList() {
        return foncierRepository.findAll();
    }

    @Override
    public Foncier updateFoncier(Foncier foncier, Long id) {
        Foncier foncier1 = foncierRepository.findById(id).get();
        foncier.setId(foncier1.getId());
        foncier.setNom(foncier1.getNom());
        foncier.setSurface(foncier1.getSurface());
        foncier.setPrix(foncier1.getPrix());

        return foncierRepository.save(foncier1);
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
