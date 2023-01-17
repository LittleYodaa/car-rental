CREATE TABLE address
(
    id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    country VARCHAR(50),
    city VARCHAR(50),
    zip_code VARCHAR(50),
    street VARCHAR(50),
    building_number VARCHAR(50)
);