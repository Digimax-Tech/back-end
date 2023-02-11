package com.sipress.apiRest.controller;


import com.sipress.apiRest.models.BilanSurface;
import com.sipress.apiRest.service.BilanSurfaceService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/v1/")
public class BilanSurfaceController {


  private BilanSurfaceService bilanSurfaceService;


    public BilanSurfaceController(BilanSurfaceService bilanSurfaceService) {
        this.bilanSurfaceService = bilanSurfaceService;

    }


    @PostMapping("/addBilanSurface")
    public BilanSurface saveBilan(@RequestBody BilanSurface bilanSurface)
    {
        return bilanSurfaceService.saveBilanSurface(bilanSurface);
    }

    @GetMapping("/bilans")
    public List<BilanSurface> fetchBilanSurfaceList()
    {
        return bilanSurfaceService.fetchBilanSurfaceList();
    }


    @PutMapping("/bilans/{id}")
    public BilanSurface updateBilanSurface(@RequestBody BilanSurface bilanSurface, @PathVariable("id") Long id)
    {
        return bilanSurfaceService.updateBilanSurfacer(bilanSurface, id);
    }



    @GetMapping("/bilans/{id}")
    public Optional<BilanSurface> findBilanSurfaceById(@PathVariable("id") Long id)
    {
        return bilanSurfaceService.findBilanSurfaceById(id);
    }

    @DeleteMapping("/bilans/{id}")
    public String deleteFoncierById(@PathVariable("id") Long id)
    {
        bilanSurfaceService.deleteBilanSurfaceById(id);
        return "Deleted Successfully";
    }

//
//    @GetMapping("/getBilan")
//    public double frais(double honoraire , double pourcent_honoraire, double fraisEnregistrement, double pourcent_enreg,
//                        double fraisGeneraux,
//                        double frais_mut)
//    {
//        Totalhonoraire =prix_achat_terrain*(pourcent_honoraire/100);
//        TotalfraisEnregistrement= (pourcent_enreg / 100) * prix_achat_terrain;
//        TotalfraisGeneraux= ((1 / 100) * prix_achat_terrain) + 7000;
//        double totalFrais =honoraire + fraisEnregistrement + fraisGeneraux;
//        return totalFrais;
//    }

}




