package com.example.exploregreece.features.tourpackage;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TourPackageService {

    private TourPackageRepository repository;

    public TourPackageService(TourPackageRepository repository) {
        this.repository = repository;
    }

    public List<TourPackageResponse> getAllTourPackages() {
        Iterable<TourPackage> retrievedTourPackages = repository.findAll();
        List<TourPackageResponse> tourPackagesToReturn = new ArrayList<>();

        for (TourPackage tourPackage : retrievedTourPackages) {
            tourPackagesToReturn.add(mapTourPackageResponse(tourPackage));
        }

        return tourPackagesToReturn;
    }

    public TourPackageResponse createTourPackage(TourPackageInput input) {
        TourPackage tourPackageToSave = mapInputToEntity(input);
        TourPackage savedTourPackage = repository.save(tourPackageToSave);
        return mapTourPackageResponse(savedTourPackage);
    }

    private TourPackage mapInputToEntity(TourPackageInput input) {
        return new TourPackage(
                input.getTitle(),
                input.getDescription(),
                input.getPrice(),
                input.getDuration(),
                input.getDest()
        );
    }

    private TourPackageResponse mapTourPackageResponse(TourPackage tourPackage) {
        return new TourPackageResponse(
                tourPackage.getId(),
                tourPackage.getTitle(),
                tourPackage.getDescription(),
                tourPackage.getPrice(),
                tourPackage.getDuration(),
                tourPackage.getDest(),
                mapPricePerDay(tourPackage)
        );
    }

    private double mapPricePerDay(TourPackage tourPackage) {
        return tourPackage.getPrice() / tourPackage.getDuration();
    }
}
