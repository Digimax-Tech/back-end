package com.sipress.apiRest.service;

import com.sipress.apiRest.models.EtudeFoncier;
import com.sipress.apiRest.repository.EtudeFoncierRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EtudeFoncierServiceImpl implements EtudeFoncierService {
    private EtudeFoncierRepository etudeFoncierRepository;

    public EtudeFoncierServiceImpl(EtudeFoncierRepository etudeFoncierRepository) {
        this.etudeFoncierRepository = etudeFoncierRepository;
    }


    @Override
    public EtudeFoncier saveEtudeFoncier(EtudeFoncier etudeFoncier) {
        return etudeFoncierRepository.save(etudeFoncier);
    }

    @Override
    public List<EtudeFoncier> searchEtudeFonciers(String query) {
        return null;
    }

//    @Override
//    public List<EtudeFoncier> searchEtudeFonciers(String query) {
//        return  etudeFoncierRepository.sea;
//    }

    @Override
    public List<EtudeFoncier> fetchEtudeFoncierList() {
        return etudeFoncierRepository.findAll();
    }

    @Override
    public EtudeFoncier updateEtudeFoncier(EtudeFoncier etudeFoncier, Long id) {
        return null;
    }

    @Override
    public Optional<EtudeFoncier> findEtudeFoncierById(Long id) {
        return etudeFoncierRepository.findById(id);
    }

    @Override
    public void deleteEtudeFoncierById(Long id) {
       etudeFoncierRepository.deleteById(id);

    }
}
