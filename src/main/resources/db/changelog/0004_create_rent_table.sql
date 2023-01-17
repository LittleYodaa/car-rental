CREATE TABLE rent
(
    id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    place_of_rent VARCHAR(50),
    place_of_return VARCHAR(50),
    price DOUBLE
);