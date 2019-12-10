package com.example.exploregreece;

import com.example.exploregreece.features.customer.Customer;
import com.example.exploregreece.features.customer.CustomerRepository;
import com.example.exploregreece.features.customer.CustomerStatus;
import com.example.exploregreece.features.tour.Tour;
import com.example.exploregreece.features.tour.TourRepository;
import com.example.exploregreece.features.tourpackage.Destination;
import com.example.exploregreece.features.tourpackage.TourPackage;
import com.example.exploregreece.features.tourpackage.TourPackageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//(2) We need to implement this interface in order to run our code in application start up
@SpringBootApplication
public class ExploregreeceApplication implements CommandLineRunner {

	//(4)dependency injection, Spring boot will create an object of the type below, by it self
	@Autowired
	TourRepository tourRepository;

	@Autowired
	CustomerRepository customerRepository;

	@Autowired
	TourPackageRepository tourPackageRepository;

	public static void main(String[] args) {
		SpringApplication.run(ExploregreeceApplication.class, args);
	}

	//(3) The code below is running on the application start up
	@Override
	public void run(String... args) throws Exception {

		TourPackage aegeanPackage =  new TourPackage("Endless blue", "Enjoy the Aegean beauty", 1100, 4, Destination.AEGEAN);
		tourPackageRepository.save(aegeanPackage);

		Tour mykonosTour = new Tour("Katamaran in Mykonos", "Enjoy best katamaran", 12, 400, aegeanPackage);
		Tour santoriniTour = new Tour("Santorini Sunset", "Enjoy the best sunset in the world", 4, 300, aegeanPackage);
		Tour chillInNaxos = new Tour("Portara view", "Best view", 4, 200, aegeanPackage);
		Tour amrogosTour = new Tour("Enjoy the best beaches in amorgos", "Chill while drinking psimeni", 12, 200, aegeanPackage);

		//(5) use the repositories to save mock data in the database
		tourRepository.save(mykonosTour);
		tourRepository.save(santoriniTour);
		tourRepository.save(chillInNaxos);
		tourRepository.save(amrogosTour);

		Customer babis = new Customer("Babis", "Babinos", "babinos@gmailcom", "69888888", 10, CustomerStatus.LOYAL);
		Customer labis = new Customer("Labis", "Labinos", "labinos@gmailcom", "69887788", 5, CustomerStatus.NEW);

		customerRepository.save(babis);
		customerRepository.save(labis);
	}
}
