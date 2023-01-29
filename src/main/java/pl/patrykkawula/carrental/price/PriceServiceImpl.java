package pl.patrykkawula.carrental.price;

import org.springframework.stereotype.Service;
import pl.patrykkawula.carrental.util.DiscountCalculatorUtil;

import java.math.BigDecimal;
import java.time.Period;

@Service
public class PriceServiceImpl implements PriceService {

  @Override
  public BigDecimal calculateCost(final PriceData priceData) {
    // TODO obliczyć liczbe dni i pomnozyc razy koszt, ewentualnie dodac jakies dodatkowe koszta
    // coś w tym stylu, ale nawet nie wiem czy zadziała xd do tego fajne testy mozna napisac akurat
    final int days = Period.between(priceData.startDate().toLocalDate(), priceData.endDate().toLocalDate()).getDays();
    final BigDecimal additionalCosts = priceData.extraCosts().stream()
        .map(ExtraCost::price)
        .reduce(BigDecimal.ZERO, BigDecimal::add);
    return priceData.baseCostPerDay()
        .multiply(BigDecimal.valueOf(days))
        .multiply(BigDecimal.valueOf(DiscountCalculatorUtil.getDiscountMultiplier(days)))
        .add(additionalCosts);
  }
}
