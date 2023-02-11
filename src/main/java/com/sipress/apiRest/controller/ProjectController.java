package com.sipress.apiRest.controller;
import com.sipress.apiRest.models.Project;
import com.sipress.apiRest.service.ProjectService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/v1/")
public class ProjectController {
    private ProjectService projectService;


     public ProjectController(ProjectService projectService) {
        this.projectService = projectService;

     }

    @PostMapping("/addProject")
    public Project saveProject(@RequestBody Project project)
    {
        return projectService.saveProject(project);
    }

    @GetMapping("/projects")
    public List<Project> fetchProjectList()
    {
        return projectService.fetchProjectList();
    }

    @PutMapping("/projects/{id}")
    public Project updateProject(@RequestBody Project project, @PathVariable("id") Long id)
    {
        return projectService.updateProject(project, id);
    }

    @GetMapping("/project/{id}")
    public Optional<Project> findProjectById(@PathVariable("id") Long id)
    {
        return projectService.findProjectById(id);
    }

    @GetMapping("/search")
    public ResponseEntity<List<Project>> searchProjects(@RequestParam("query") String query){
        return ResponseEntity.ok(projectService.searchProjects(query));
    }

    @DeleteMapping("/projects/{id}")
    public String deleteProjectById(@PathVariable("id") Long id)
    {
        projectService.deleteProjecttById(id);
        return "Deleted Successfully";
    }
}

