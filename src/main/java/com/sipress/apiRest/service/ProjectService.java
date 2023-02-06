package com.sipress.apiRest.service;

import com.sipress.apiRest.models.Project;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
public interface ProjectService {

     Project saveProject(Project project);
     List<Project> searchProjects(String query);
     List<Project> fetchProjectList();
     Project updateProject(Project project, Long  id);
     Optional<Project> findProjectById(Long id);

     void deleteProjecttById(Long id);



}

