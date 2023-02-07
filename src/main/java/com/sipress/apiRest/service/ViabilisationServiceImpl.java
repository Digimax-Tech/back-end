package com.sipress.apiRest.service;

import com.sipress.apiRest.models.Viabilisation;
import com.sipress.apiRest.repository.ViabilisationRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ViabilisationServiceImpl implements ViabilisationService {
    private ViabilisationRepository viabilisationRepository;

    public ViabilisationServiceImpl(ViabilisationRepository viabilisationRepository) {
        this.viabilisationRepository = viabilisationRepository;
    }

    @Override
    public Viabilisation saveViabilisation(Viabilisation viabilisation) {
        return viabilisationRepository.save(viabilisation);
    }

    @Override
    public List<Viabilisation> fetchViabilisationList() {
        return viabilisationRepository.findAll();
    }

    @Override
    public Viabilisation updateViabilisation(Viabilisation viabilisation, Long id) {
        return null;
    }

    @Override
    public Optional<Viabilisation> findViabilisationById(Long id) {
        return Optional.empty();
    }

    @Override
    public void deleteViabilisationById(Long id) {

    }
}
