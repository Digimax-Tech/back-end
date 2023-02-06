package com.sipress.apiRest.controller;
import com.sipress.apiRest.ExcelHelper;
import com.sipress.apiRest.models.Frais;
import com.sipress.apiRest.models.ResponseMessage;
import com.sipress.apiRest.repository.FraisRepository;
import com.sipress.apiRest.service.ExcelService;
import com.sipress.apiRest.service.FraisService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/v1/")
public class FraisController {

  private FraisRepository fraisRepository;
  private FraisService fraisService;
  private ExcelService fileService;

    public FraisController(FraisRepository fraisRepository, FraisService fraisService, ExcelService fileService) {
        this.fraisRepository = fraisRepository;
        this.fraisService = fraisService;
        this.fileService = fileService;
    }


    @PostMapping("/addFrais")
    public Frais saveFrais(@RequestBody Frais frais)
    {
        return fraisService.saveFrais(frais);
    }

    @GetMapping("/frais")
    public List<Frais> fetchFraisList()
    {
        return fraisService.fetchFraisList();
    }


    @PostMapping("/upload")
    public ResponseEntity<ResponseMessage> uploadFile(@RequestParam("file") MultipartFile file) {
        String message = "";

        if (ExcelHelper.hasExcelFormat(file)) {
            try {
                fileService.save(file);

                message = "Uploaded the file successfully: " + file.getOriginalFilename();
                return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage(message));
            } catch (Exception e) {
                message = "Could not upload the file: " + file.getOriginalFilename() + "!";
                return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseMessage(message));
            }
        }

        message = "Please upload an excel file!";
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ResponseMessage(message));
    }

//    @GetMapping("/download")
//    public ResponseEntity<Resource> getFile() {
//        String filename = "frais.csv";
//        InputStreamResource file = new InputStreamResource(fileService.load());
//
//        return ResponseEntity.ok()
//                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + filename)
//                .contentType(MediaType.parseMediaType("application/csv"))
//                .body(file);
//    }



    @PutMapping("/frais/{id}")
    public Frais updateFrais(@RequestBody Frais frais, @PathVariable("id") Long id)
    {
        return fraisService.updateFrais(frais, id);
    }



    @GetMapping("/frais/{id}")
    public Optional<Frais> findFraisById(@PathVariable("id") Long id)
    {
        return fraisService.findFraisById(id);
    }

    @DeleteMapping("/fraiss/{id}")
    public String deleteFraisById(@PathVariable("id") Long id)
    {
        fraisService.deleteFraisById(id);
        return "Deleted Successfully";
    }



}

