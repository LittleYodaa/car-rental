package pl.patrykkawula.carrental.price;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

public record PriceData(LocalDateTime startDate, LocalDateTime endDate, BigDecimal baseCostPerDay, List<ExtraCost> extraCosts) {

}