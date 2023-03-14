package com.sipress.apiRest.service;

import com.sipress.apiRest.models.Project;
import com.sipress.apiRest.repository.ProjectRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
public class ExcelService {
   private ProjectRepository projectRepository;

    public ExcelService(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    public void saveCustomersToDatabase(MultipartFile file){
        if(ExcelUploadService.isValidExcelFile(file)){
            try {
                List<Project> customers = ExcelUploadService.getCustomersDataFromExcel(file.getInputStream());
                this.projectRepository.saveAll(customers);
            } catch (IOException e) {
                throw new IllegalArgumentException("The file is not a valid excel file");
            }
        }
    }

    public List<Project> getAll() {
        return projectRepository.findAll();
    }
}
