CREATE TABLE client
(
    id BIGINT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    first_name VARCHAR(50),
    last_name VARCHAR(50),
    email VARCHAR(50),
    phone_number VARCHAR(50),
    bank_account VARCHAR(50),
    date_of_birth DATE,
    driving_license_number VARCHAR(50),
    address_id BIGINT NOT NULL
);