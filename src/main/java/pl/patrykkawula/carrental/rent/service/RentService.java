package pl.patrykkawula.carrental.rent.service;

import pl.patrykkawula.carrental.rent.dto.RentRequest;
import pl.patrykkawula.carrental.rent.dto.RentResponse;

public interface RentService {
  RentResponse rentCar(RentRequest rentRequest);

}
