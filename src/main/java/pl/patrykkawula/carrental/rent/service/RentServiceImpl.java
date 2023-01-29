package pl.patrykkawula.carrental.rent.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import pl.patrykkawula.carrental.car.model.Car;
import pl.patrykkawula.carrental.car.service.CarRepository;
import pl.patrykkawula.carrental.client.model.Client;
import pl.patrykkawula.carrental.client.service.ClientRepository;
import pl.patrykkawula.carrental.price.PriceService;
import pl.patrykkawula.carrental.rent.dto.RentRequest;
import pl.patrykkawula.carrental.rent.dto.RentResponse;
import pl.patrykkawula.carrental.rent.model.RentEntity;
import pl.patrykkawula.carrental.rent.repository.RentRepository;
import pl.patrykkawula.carrental.util.PriceMapper;

import java.math.BigDecimal;

@Service
public class RentServiceImpl implements RentService {

  private static final Logger log = LoggerFactory.getLogger(RentServiceImpl.class);

  private final CarRepository carRepository;
  private final ClientRepository clientRepository;
  private final RentRepository rentRepository;
  private final PriceService priceService;

  public RentServiceImpl(final CarRepository carRepository, final ClientRepository clientRepository, final RentRepository rentRepository,
      final PriceService priceService) {
    this.carRepository = carRepository;
    this.clientRepository = clientRepository;
    this.rentRepository = rentRepository;
    this.priceService = priceService;
  }

  @Override
  public RentResponse rentCar(final RentRequest rentRequest) {
    // TODO check if car is available in requested dates
    // tu będzie potrzebny jakis AvailabilityService na przyklad

    long clientId = rentRequest.getClientId();
    long carId = rentRequest.getCarId();
    Client client = clientRepository.findById(clientId).orElseThrow();
    Car carToRent = carRepository.findById(carId).orElseThrow();
    final BigDecimal price = priceService.calculateCost(PriceMapper.map(rentRequest, BigDecimal.valueOf(carToRent.getBasePrice())));

    // TODO tu da się lepiej zamiast przekazywac cale encje car i client mozna jakos same id i hibernate sobie ogarnie reszte. ale nie pamietam jak
    RentEntity rentEntity = new RentEntity(client, carToRent, rentRequest.getPickupDateTime(), rentRequest.getReturnDateTime(),
        rentRequest.getPlaceOfRent(),
        rentRequest.getPlaceOfReturn(), price);
    final RentEntity savedRentEntity = rentRepository.save(rentEntity);
    log.info("Created new rent with id: {}, for client: {} and car: {}", savedRentEntity.getId(), clientId, carId);
    return map(rentEntity);
  }

  private static RentResponse map(RentEntity rentEntity) {
    return new RentResponse(rentEntity.getId(), rentEntity.getClient().getId(), rentEntity.getCar().getId(),
        rentEntity.getPickupDateTime(), rentEntity.getReturnDateTime(), rentEntity.getPlaceOfRent(), rentEntity.getPlaceOfReturn(),
        rentEntity.getPrice());
  }
}
