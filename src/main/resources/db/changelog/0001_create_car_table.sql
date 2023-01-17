CREATE TABLE car
(
    id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    brand VARCHAR(50),
    model VARCHAR(50),
    power INT,
    displacement DOUBLE,
    engine_type VARCHAR(50),
    gearbox VARCHAR(50),
    base_price DOUBLE,
    vin VARCHAR(50),
    production_year INTEGER,
    car_type VARCHAR(50),
    car_segment VARCHAR(50),
    seats INT
);