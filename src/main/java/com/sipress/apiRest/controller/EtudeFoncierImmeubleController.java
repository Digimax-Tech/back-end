package com.sipress.apiRest.controller;


import com.sipress.apiRest.models.EtudeFoncier;
import com.sipress.apiRest.models.EtudeFoncierImmeuble;
import com.sipress.apiRest.repository.EtudeFoncierRepository;
import com.sipress.apiRest.repository.EtudeFoncierimmeubleRepository;
import com.sipress.apiRest.repository.ProjectRepository;
import com.sipress.apiRest.service.EtudeFoncierImmeubleService;
import com.sipress.apiRest.service.EtudeFoncierService;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/v1/")
public class EtudeFoncierImmeubleController {

 private  ProjectRepository projectRepository;
  private EtudeFoncierImmeubleService etudeFoncierImmeubleService;
  private EtudeFoncierimmeubleRepository etudeFoncierimmeubleRepository;

    public EtudeFoncierImmeubleController(ProjectRepository projectRepository,
                                          EtudeFoncierImmeubleService etudeFoncierImmeubleService,
                                          EtudeFoncierimmeubleRepository etudeFoncierimmeubleRepository)
    {

        this.etudeFoncierImmeubleService = etudeFoncierImmeubleService;
        this.etudeFoncierimmeubleRepository = etudeFoncierimmeubleRepository;
        this.projectRepository = projectRepository;
    }


    @PostMapping("/projects/{id}/fonciers")
    public EtudeFoncierImmeuble createEtudeFoncier(@PathVariable (value = "id") Long id, @Valid
    @RequestBody EtudeFoncierImmeuble etudeFoncierImmeuble)
    {
        return projectRepository.findById(id).map(post -> {
            etudeFoncierImmeuble.setProject(post);
            return etudeFoncierimmeubleRepository.save(etudeFoncierImmeuble);
        }).orElseThrow(() -> new ResourceNotFoundException("PostId " + id + " not found"));
    }


    @GetMapping("/etudesFonciersImmeuble")
    public List<EtudeFoncierImmeuble> fetchEtudeFoncierImmeubleList()
    {
        return etudeFoncierImmeubleService.fetchEtudeFoncierImmeubleList();
    }

    @PutMapping("/etudeFonciersImmeuble/{id}")

//    public EtudeFoncier updateEtudeFoncier(@RequestBody EtudeFoncier etudeFoncier, @PathVariable("id") Long id)
//    {
//        return etudeFoncierService.updateEtudeFoncier(etudeFoncier, id);
//    }
//
    @GetMapping("/etudeFonciersImmeuble/project/{id}")
    public EtudeFoncierImmeuble  findEtudeFoncierimmeubleByProjectId(@PathVariable("id") Long id)
    {
        return etudeFoncierimmeubleRepository.findEtudeFoncierImmeubleByProjectId(id);
    }
//
//    @GetMapping("/etudeFonciers/{id}")
//    public Optional<EtudeFoncier> findEtudeFoncierById(@PathVariable("id") Long id)
//    {
//        return etudeFoncierService.findEtudeFoncierById(id);
//    }
//
//    @DeleteMapping("/etudeFonciers/{id}")
//    public String deleteEtudeFoncierById(@PathVariable("id") Long id)
//    {
//        etudeFoncierService.deleteEtudeFoncierById(id);
//        return "Deleted Successfully";
//    }

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



    @PostMapping("/addEtudeFonciersImmeuble")
    public EtudeFoncierImmeuble saveEtudeFoncierImmeuble(@RequestBody EtudeFoncierImmeuble etudeFoncierImmeuble)
    {
        return etudeFoncierImmeubleService.saveEtudeFoncierImmeuble(etudeFoncierImmeuble);
    }



}

