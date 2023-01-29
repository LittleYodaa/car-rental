package pl.patrykkawula.carrental.rent.dto;

import pl.patrykkawula.carrental.price.ExtraCost;

import java.time.LocalDateTime;
import java.util.List;

public class RentRequest {
    private long clientId;
    private long carId;
    private LocalDateTime pickupDateTime;
    private LocalDateTime returnDateTime;
    private String placeOfRent;
    private String placeOfReturn;
    private List<ExtraCost> additionalServices;

  public long getClientId() {
    return clientId;
  }

  public long getCarId() {
    return carId;
  }

  public LocalDateTime getPickupDateTime() {
    return pickupDateTime;
  }

  public LocalDateTime getReturnDateTime() {
    return returnDateTime;
  }

  public String getPlaceOfRent() {
    return placeOfRent;
  }

  public String getPlaceOfReturn() {
    return placeOfReturn;
  }

  public List<ExtraCost> getAdditionalServices() {
    return additionalServices;
  }
}
