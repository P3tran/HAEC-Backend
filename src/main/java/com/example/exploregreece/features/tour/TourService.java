package com.example.exploregreece.features.tour;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

//(3) All services must be annotated with below
@Service
public class TourService {

    private TourRepository repository;

    //Spring boot can inject the repository because it extends CrudRepository and has @Repository annotation
    public TourService(TourRepository repository) {
        this.repository = repository;
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
