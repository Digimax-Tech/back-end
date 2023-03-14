package com.sipress.apiRest.controller;

import com.sipress.apiRest.models.Foncier;
import com.sipress.apiRest.models.Project;
import com.sipress.apiRest.repository.FoncierRepository;
import com.sipress.apiRest.repository.ProjectRepository;
import com.sipress.apiRest.service.FoncierService;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/v1")
public class FoncierController {
    private FoncierService foncierService;
    private FoncierRepository foncierRepository;
    private ProjectRepository projectRepository;

    public FoncierController(FoncierService foncierService, FoncierRepository foncierRepository, ProjectRepository projectRepository) {
        this.foncierService = foncierService;
        this.foncierRepository = foncierRepository;
        this.projectRepository = projectRepository;
    }


    @PostMapping("/fonciers/{id}")
    public Foncier createFoncierByProjectId(@PathVariable (value = "id") Long id,@RequestBody Foncier foncier)
    {
        return projectRepository.findById((long) id).map(project -> {
            foncier.setProject(project);
            return foncierRepository.save(foncier);
        }).orElseThrow(() -> new ResourceNotFoundException("PostId " + id + " not found"));
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

    @GetMapping("/foncier/{id}")
    public Optional<Foncier> findFoncierById(@PathVariable("id") Long id)
    {
        return foncierService.findFoncierById(id);
    }


    @GetMapping("/fonciers/project/{id}")
    public Foncier findFoncierByProjectId(@PathVariable("id") Long id)
    {
        return foncierRepository.findFoncierByProjectId(id);
    }

//    @GetMapping("/search")
//    public ResponseEntity<List<Project>> searchProjects(@RequestParam("query") String query){
//        return ResponseEntity.ok(foncierService.searchProjects(query));
//    }

    @DeleteMapping("/fonciers/{id}")
    public String deleteFoncierById(@PathVariable("id") Long id)
    {
        foncierService.deleteFoncierById(id);
        return "Deleted Successfully";
    }
}

