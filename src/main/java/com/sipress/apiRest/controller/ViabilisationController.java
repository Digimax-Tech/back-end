package com.sipress.apiRest.controller;

import com.sipress.apiRest.models.EtudeFoncier;
import com.sipress.apiRest.models.Project;
import com.sipress.apiRest.models.Viabilisation;
import com.sipress.apiRest.service.ViabilisationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/v1/")
public class ViabilisationController {
    private ViabilisationService viabilisationService;

    public ViabilisationController(ViabilisationService viabilisationService) {
        this.viabilisationService = viabilisationService;
    }

    @PostMapping("/addViabilisation")
    public Viabilisation saveViabilisation(@RequestBody Viabilisation viabilisation)
    {
        return viabilisationService.saveViabilisation(viabilisation);
    }


    @GetMapping("/viabilisations")
    public List<Viabilisation> fetchViabilisationList()
    {
        return viabilisationService.fetchViabilisationList();
    }

    @PutMapping("/viabilisations/{id}")
    public Viabilisation updateViabilisation(@RequestBody Viabilisation viabilisation, @PathVariable("id") Long id)
    {
        return viabilisationService.updateViabilisation(viabilisation, id);
    }

    @GetMapping("/viable/{id}")
    public Optional<Viabilisation> findProjectById(@PathVariable("id") Long id)
    {
        return viabilisationService.findViabilisationById(id);
    }

//    @GetMapping("/search")
//    public ResponseEntity<List<Project>> searchProjects(@RequestParam("query") String query){
//        return ResponseEntity.ok(viabilisationService.searchProjects(query));
//    }

    @DeleteMapping("/viabilisations/{id}")
    public String deleteViabilisationById(@PathVariable("id") Long id)
    {
       viabilisationService.deleteViabilisationById(id);
        return "Deleted Successfully";
    }
}

