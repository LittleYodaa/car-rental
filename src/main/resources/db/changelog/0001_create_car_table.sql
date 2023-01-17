CREATE TABLE car
(
    id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    brand VARCHAR(50),
    model VARCHAR(50),
    power INT,
    displacement DOUBLE,
    gearbox VARCHAR(50),
    basePrice DOUBLE,
    vin VARCHAR(50),
    `year` INTEGER,
    carType VARCHAR(50),
    carSegment VARCHAR(50),
    seats INT
);