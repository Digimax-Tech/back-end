package com.sipress.apiRest.service;

import com.sipress.apiRest.models.Project;
import com.sipress.apiRest.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.multipart.MultipartFile;


import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
public interface ProjectService {
     Project saveProject(Project project);
     List<Project> searchProjects(String query);
     List<Project> fetchProjectList();
//     Project updateProject(Project project, Long  id);

     Project updateProject(@PathVariable Long id, @RequestBody Project project);

     Optional<Project> findProjectById(Long id);

     void deleteProjecttById(Long id);


}

