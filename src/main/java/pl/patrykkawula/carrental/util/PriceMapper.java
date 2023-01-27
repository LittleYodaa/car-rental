package pl.patrykkawula.carrental.util;

import pl.patrykkawula.carrental.price.PriceData;
import pl.patrykkawula.carrental.rent.dto.RentRequest;

import java.math.BigDecimal;

public final class PriceMapper {

  private PriceMapper() {
    throw new IllegalStateException("Can't be initialized");
  }

  public static PriceData map(final RentRequest rentRequest, BigDecimal baseCostPerDay) {
    return new PriceData(rentRequest.getPickupDateTime(), rentRequest.getReturnDateTime(), baseCostPerDay, rentRequest.getAdditionalServices());
  }
}
