package pl.patrykkawula.carrental.rent.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class RentResponse {
    private long rentId;
    private long clientId;
    private long carId;
    private LocalDateTime pickupDateTime;
    private LocalDateTime returnDateTime;
    private String placeOfRent;
    private String placeOfReturn;
    private BigDecimal initialCost;

    public RentResponse(final long rentId, final long clientId, final long carId, final LocalDateTime pickupDateTime,
        final LocalDateTime returnDateTime, final String placeOfRent, final String placeOfReturn, final BigDecimal initialCost) {
        this.rentId = rentId;
        this.clientId = clientId;
        this.carId = carId;
        this.pickupDateTime = pickupDateTime;
        this.returnDateTime = returnDateTime;
        this.placeOfRent = placeOfRent;
        this.placeOfReturn = placeOfReturn;
        this.initialCost = initialCost;
    }
}
