package com.sipress.apiRest.service;

import com.sipress.apiRest.ExcelHelper;
import com.sipress.apiRest.models.Frais;
import com.sipress.apiRest.repository.FraisRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.List;

@Service
public class ExcelService {
   private FraisRepository fraisRepository;

    public ExcelService(FraisRepository fraisRepository) {
        this.fraisRepository = fraisRepository;
    }

    public void save(MultipartFile file) {
        try {
            List<Frais> tutorials = ExcelHelper.excelToFrais(file.getInputStream());
            fraisRepository.saveAll(tutorials);
        } catch (IOException e) {
            throw new RuntimeException("fail to store excel data: " + e.getMessage());
        }
    }

    public List<Frais> getAll() {
        return fraisRepository.findAll();
    }
}
