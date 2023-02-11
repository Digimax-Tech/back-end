package com.sipress.apiRest.controller;


import com.sipress.apiRest.models.EtudeFoncier;
import com.sipress.apiRest.repository.EtudeFoncierRepository;
import com.sipress.apiRest.service.EtudeFoncierService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/v1/")
public class EtudeFoncierController {

  private EtudeFoncierService etudeFoncierService;
  private EtudeFoncierRepository etudeFoncierRepository;

    public EtudeFoncierController(EtudeFoncierService etudeFoncierService, EtudeFoncierRepository etudeFoncierRepository) {
        this.etudeFoncierService = etudeFoncierService;
        this.etudeFoncierRepository = etudeFoncierRepository;
    }


    @PostMapping("/addEtudeFonciers")
    public EtudeFoncier saveEtudeFoncier(@RequestBody EtudeFoncier etudeFoncier)
    {
        return etudeFoncierService.saveEtudeFoncier(etudeFoncier);
    }

    @GetMapping("/etudesFonciers")
    public List<EtudeFoncier> fetchEtudeFoncierList()
    {
        return etudeFoncierService.fetchEtudeFoncierList();
    }


    @PutMapping("/etudeFonciers/{id}")
    public EtudeFoncier updateEtudeFoncier(@RequestBody EtudeFoncier etudeFoncier, @PathVariable("id") Long id)
    {
        return etudeFoncierService.updateEtudeFoncier(etudeFoncier, id);
    }



    @GetMapping("/etudeFonciers/{id}")
    public Optional<EtudeFoncier> findEtudeFoncierById(@PathVariable("id") Long id)
    {
        return etudeFoncierService.findEtudeFoncierById(id);
    }

    @DeleteMapping("/etudeFonciers/{id}")
    public String deleteEtudeFoncierById(@PathVariable("id") Long id)
    {
        etudeFoncierService.deleteEtudeFoncierById(id);
        return "Deleted Successfully";
    }

}

