package com.sipress.apiRest.controller;


import com.sipress.apiRest.models.Foncier;
import com.sipress.apiRest.models.Frais;
import com.sipress.apiRest.models.Project;
import com.sipress.apiRest.repository.FoncierRepository;
import com.sipress.apiRest.service.FoncierService;
import org.springframework.web.bind.annotation.*;

import javax.persistence.Transient;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/v1/")
public class FoncierController {

    Foncier foncier;

   private FoncierService foncierService;
   private FoncierRepository foncierRepository;

    public FoncierController(FoncierService foncierService, FoncierRepository foncierRepository) {

        this.foncierService = foncierService;
        this.foncierRepository = foncierRepository;
    }


    @PostMapping("/addFoncier")
    public Foncier saveFoncier(@RequestBody Foncier foncier)
    {
        return foncierService.saveFoncier(foncier);
    }

    @GetMapping("/fonciers")
    public List<Foncier> fetchFoncierList()
    {
        return foncierService.fetchFoncierList();
    }


    @PutMapping("/fonciers/{id}")
    public Foncier updateFoncier(@RequestBody Foncier foncier, @PathVariable("id") Long id)
    {
        return foncierService.updateFoncier(foncier, id);
    }

    @GetMapping("/fonciers/{id}")
    public Optional<Foncier> findFoncierById(@PathVariable("id") Long id)
    {
        return foncierService.findFoncierById(id);
    }

    @DeleteMapping("/fonciers/{id}")
    public String deleteFoncierById(@PathVariable("id") Long id)
    {
        foncierService.deleteFoncierById(id);
        return "Deleted Successfully";
    }


}

