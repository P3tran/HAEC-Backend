package com.example.exploregreece.features.tourpackage;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TourPackageController {

    private TourPackageService service;

    public TourPackageController(TourPackageService service) {
        this.service = service;
    }

    @GetMapping(path = "all-tourPackages")
    public List<TourPackageResponse> getAllTourPackages() {
        return service.getAllTourPackages();
    }

    @PostMapping(path = "create-tourPackage")
    public ResponseEntity createTourPackage(@RequestBody TourPackageInput input) {
        return new ResponseEntity(service.createTourPackage(input), HttpStatus.CREATED);
    }
}
