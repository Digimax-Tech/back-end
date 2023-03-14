package com.sipress.apiRest.controller;


import com.sipress.apiRest.models.EtudeFoncier;
import com.sipress.apiRest.models.Project;
import com.sipress.apiRest.repository.EtudeFoncierRepository;
import com.sipress.apiRest.repository.ProjectRepository;
import com.sipress.apiRest.service.EtudeFoncierService;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/v1/")
public class EtudeFoncierController {

  private EtudeFoncierService etudeFoncierService;
  private ProjectRepository projectRepository;
  private EtudeFoncierRepository etudeFoncierRepository;

    public EtudeFoncierController(EtudeFoncierService etudeFoncierService,
                                  ProjectRepository projectRepository,
                                  EtudeFoncierRepository etudeFoncierRepository)
    {
        this.etudeFoncierService = etudeFoncierService;
        this.projectRepository = projectRepository;
        this.etudeFoncierRepository = etudeFoncierRepository;
    }


    @PostMapping("/projects/{id}/addEtudeFonciers")
    public EtudeFoncier createEtudeFoncier(@PathVariable (value = "id") Long id, @Valid
    @RequestBody EtudeFoncier etudeFoncier)
    {
        return projectRepository.findById(id).map(post -> {
            etudeFoncier.setProject(post);
            return etudeFoncierRepository.save(etudeFoncier);
        }).orElseThrow(() -> new ResourceNotFoundException("PostId " + id + " not found"));
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

    @GetMapping("/etudeFonciers/project/{id}")
    public EtudeFoncier  findEtudeFoncierByProjectId(@PathVariable("id") Long id)
    {
        return etudeFoncierRepository.findEtudeFoncierByProjectId(id);
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

    //    @PutMapping("/posts/{postId}/comments/{commentId}")
//    public Comment updateComment(@PathVariable (value = "postId") Long postId,
//                                 @PathVariable (value = "commentId") Long commentId,
//                                 @Valid @RequestBody Comment commentRequest) {
//        if(!postRepository.existsById(postId)) {
//            throw new ResourceNotFoundException("PostId " + postId + " not found");
//        }
//
//        return commentRepository.findById(commentId).map(comment -> {
//            comment.setText(commentRequest.getText());
//            return commentRepository.save(comment);
//        }).orElseThrow(() -> new ResourceNotFoundException("CommentId " + commentId + "not found"));
//    }
//



    @PostMapping("/addEtudeFonciers")
    public EtudeFoncier saveEtudeFoncier(@RequestBody EtudeFoncier etudeFoncier)
    {
        return etudeFoncierService.saveEtudeFoncier(etudeFoncier);
    }



}

