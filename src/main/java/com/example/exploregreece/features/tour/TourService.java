package com.example.exploregreece.features.tour;

import com.example.exploregreece.features.tourpackage.TourPackage;
import com.example.exploregreece.features.tourpackage.TourPackageNotFoundException;
import com.example.exploregreece.features.tourpackage.TourPackageRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

//(3) All services must be annotated with below
@Service
public class TourService {

    private TourRepository repository;
    private TourPackageRepository tourPackageRepository;

    //Spring boot can inject the repository because it extends CrudRepository and has @Repository annotation
    public TourService(TourRepository repository, TourPackageRepository tourPackageRepository) {
        this.repository = repository;
        this.tourPackageRepository = tourPackageRepository;
    }

    //public method that the controller uses to retrieve all tours
    //repository is retuning an Iterable of tours and we create a list out of it with all retrieved tours
    public List<TourResponse> getAllTours() {
        List<TourResponse> toursToReturn = new ArrayList<>();
        Iterable<Tour> retrievedTours = repository.findAll();
        for (Tour tour : retrievedTours) {
            toursToReturn.add(mapToResponse(tour));
        }
        return toursToReturn;
    }

    public List<TourResponse> getToursByPrice(double price) {
        List<TourResponse> toursToReturn = new ArrayList<>();
        Iterable<Tour> retrievedTours = repository.findAll();
        for (Tour tour : retrievedTours) {
            if (tour.getPrice() <= price)
                toursToReturn.add(mapToResponse(tour));
        }
        return toursToReturn;
    }

    public TourResponse createTour(TourInput input)
            throws TourPackageNotFoundException {
        Tour mappedTour = mapInputToEntity(input);

        Optional<TourPackage> optional = tourPackageRepository.findById(input.getTourPackageId());
        if(optional.isEmpty())
            throw new TourPackageNotFoundException();
        mappedTour.setTourPackage(optional.get());

        Tour savedTour = repository.save(mappedTour);
        return mapToResponse(savedTour);
    }


    private Tour mapInputToEntity(TourInput input) {
        return new Tour(
                input.getTitle(),
                input.getShortDescription(),
                input.getHoursDuration(),
                input.getPrice(),
                null
        );
    }

    private TourResponse mapToResponse(Tour tour) {
        return new TourResponse(
                tour.getId(),
                tour.getTitle(),
                tour.getShortDescription(),
                tour.getHoursDuration(),
                tour.getPrice(),
                tour.getTourPackage(),
                mapPricePerHour(tour),
                mapDurationType(tour)
        );
    }

    private double mapPricePerHour(Tour tour) {
        return tour.getPrice() / tour.getHoursDuration();
    }

    private DurationType mapDurationType(Tour tour) {
        DurationType durType;
        if(tour.getHoursDuration() <=4)
            durType = DurationType.HALF_DAY;
        else if(tour.getHoursDuration() <= 8)
            durType = DurationType.FULL_DAY;
        else
            durType = DurationType.EXTENDED;
        return durType;
    }

/*    private TourResponse mapToResponse(Tour tour) {
        TourResponse response = new TourResponse();
        response.setId(tour.getId());
        response.setPrice(tour.getPrice());
        response.setTitle(tour.getTitle());
        response.setShortDescription(tour.getShortDescription());
        response.setHoursDuration(tour.getHoursDuration());
        response.setTourPackage(tour.getTourPackage());
        response.setPricePerHour(tour.getPrice() / tour.getHoursDuration());
        if(tour.getHoursDuration() <=4)
            response.setDurationType(DurationType.HALF_DAY);
        else if(tour.getHoursDuration() <= 8)
            response.setDurationType(DurationType.FULL_DAY);
        else
            response.setDurationType(DurationType.EXTENDED);
        return response;
    }*/
}
