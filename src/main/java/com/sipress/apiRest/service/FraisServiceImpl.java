package com.sipress.apiRest.service;

import com.sipress.apiRest.models.Frais;
import com.sipress.apiRest.repository.FraisRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class FraisServiceImpl implements FraisService {
    private FraisRepository fraisRepository;

    public FraisServiceImpl(FraisRepository fraisRepository) {
        this.fraisRepository = fraisRepository;
    }

    @Override
    public Frais saveFrais(Frais frais) {
        return fraisRepository.save(frais);
    }

//    @Override
//    public List<Frais> searchFrais(String query) {
//        return fraisRepository.searchFrais(query);
//    }

    @Override
    public List<Frais> fetchFraisList() {
        return fraisRepository.findAll();
    }

    @Override
    public Frais updateFrais(Frais frais, Long id) {
        Frais frais1 = fraisRepository.findById(id).get();
        frais.setId(frais1.getId());
        frais.setHonoraire(frais1.getHonoraire());
        frais.setFraisGeneraux(frais1.getFraisGeneraux());
        frais.setFraisEnregistrement(frais1.getFraisEnregistrement());

        return fraisRepository.save(frais1);
    }

    @Override
    public Optional<Frais> findFraisById(Long id) {
        return fraisRepository.findById(id);
    }

    @Override
    public void deleteFraisById(Long id) {
        fraisRepository.deleteById(id);

    }
}
