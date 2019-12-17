package com.example.exploregreece.features.tour;

import com.example.exploregreece.features.CustomError;
import com.example.exploregreece.features.tourpackage.TourPackageNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//(4)
//Every controller class must have the annotation bellow
//Controllers are the classes that handle HTTP requests and create HTTP Responses
@RestController
public class TourController {

    private TourService service;

    //Spring boot can inject a TourService because this class is annotated with @Service
    public TourController(TourService service) {
        this.service = service;
    }

    //With this annotation we make an endpoint out of the method
    @GetMapping(path = "all-tours")
    public ResponseEntity getAllTours() {
        List<TourResponse> tours = service.getAllTours();
        return new ResponseEntity(tours, HttpStatus.OK);
    }

    //With /{price} and @PathVariable we can make the endpoint accepting path variables
    @GetMapping(path = "tours-by-price/{price}")
    public ResponseEntity getToursByPrice(@PathVariable double price) {
        if (price < 10.0 || price > 100000)
            return new ResponseEntity(new CustomError(0, "Wrong price", "Our selling range is between 10 & 100.000"), HttpStatus.BAD_REQUEST);
        else
            return new ResponseEntity(service.getToursByPrice(price), HttpStatus.OK);
    }

    @PostMapping(path = "create-tour")
    public ResponseEntity createTour(@RequestBody TourInput input) {

        try {
            return new ResponseEntity(
                    service.createTour(input),
                    HttpStatus.CREATED
            );
        } catch (TourPackageNotFoundException e) {
            return new ResponseEntity(
                    new CustomError(
                            0,
                            "Wrong Input",
                            "Tour package not found"
                    ),
                    HttpStatus.BAD_REQUEST);
        }
    }


}
