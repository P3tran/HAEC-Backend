package com.example.exploregreece.features.tour;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

//(2)
@Repository
public interface TourRepository extends CrudRepository<Tour, Long> {
}
