package com.sipress.apiRest.controller;
import com.sipress.apiRest.models.Frais;
import com.sipress.apiRest.repository.FraisRepository;
import com.sipress.apiRest.service.ExcelService;
import com.sipress.apiRest.service.FraisService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/v1/")
public class FraisController {

  private FraisRepository fraisRepository;
  private FraisService fraisService;
  private ExcelService fileService;

    public FraisController(FraisRepository fraisRepository, FraisService fraisService, ExcelService fileService) {
        this.fraisRepository = fraisRepository;
        this.fraisService = fraisService;
        this.fileService = fileService;
    }


    @PostMapping("/addFrais")
    public Frais saveFrais(@RequestBody Frais frais)
    {
        return fraisService.saveFrais(frais);
    }

    @GetMapping("/frais")
    public List<Frais> fetchFraisList()
    {
        return fraisService.fetchFraisList();
    }


    @PutMapping("/frais/{id}")
    public Frais updateFrais(@RequestBody Frais frais, @PathVariable("id") Long id)
    {
        return fraisService.updateFrais(frais, id);
    }



    @GetMapping("/frais/{id}")
    public Optional<Frais> findFraisById(@PathVariable("id") Long id)
    {
        return fraisService.findFraisById(id);
    }

    @DeleteMapping("/fraiss/{id}")
    public String deleteFraisById(@PathVariable("id") Long id)
    {
        fraisService.deleteFraisById(id);
        return "Deleted Successfully";
    }



}

