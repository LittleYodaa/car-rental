package pl.patrykkawula.carrental.price;

import java.math.BigDecimal;

public interface PriceService {

  BigDecimal calculateCost(PriceData priceData);

}
