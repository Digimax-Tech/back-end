package com.sipress.apiRest.service;

import com.sipress.apiRest.models.EtudeFoncierImmeuble;
import com.sipress.apiRest.repository.EtudeFoncierimmeubleRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EtudeFoncierImmeubleServiceImpl implements EtudeFoncierImmeubleService {
    private EtudeFoncierimmeubleRepository etudeFoncierimmeubleRepository;

    public EtudeFoncierImmeubleServiceImpl(EtudeFoncierimmeubleRepository etudeFoncierimmeubleRepository) {
        this.etudeFoncierimmeubleRepository = etudeFoncierimmeubleRepository;
    }

    @Override
    public EtudeFoncierImmeuble saveEtudeFoncierImmeuble(EtudeFoncierImmeuble etudeFoncierImmeuble) {
        return etudeFoncierimmeubleRepository.save(etudeFoncierImmeuble);
    }

    @Override
    public List<EtudeFoncierImmeuble> searchEtudeFonciers(String query) {
        return etudeFoncierimmeubleRepository.findAll();
    }

    @Override
    public List<EtudeFoncierImmeuble> fetchEtudeFoncierImmeubleList() {
        return null;
    }

    @Override
    public EtudeFoncierImmeuble updateEEtudeFoncierImmeuble(EtudeFoncierImmeuble etudeFoncierImmeuble, Long id) {
        return null;
    }

    @Override
    public Optional<EtudeFoncierImmeuble> findEtudeFoncierImmeubleById(Long id) {
        return Optional.empty();
    }

    @Override
    public void deleteEtudeFoncierImmeubleById(Long id) {

    }
}
