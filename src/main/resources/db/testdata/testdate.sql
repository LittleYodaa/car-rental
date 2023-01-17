INSERT INTO car
(brand, model, power, displacement, engine_type, gearbox, base_price, vin, production_year, car_type, car_segment,
 seats)
VALUES ('Alfa Romeo', 'Giulia', 280, 2000, 'petrol', 'automatic', 400, 'ZARPAH7HN84753', 2017, 'limousine', 'd', 5),
       ('BMW', 'series 3', 197, 3000, 'diesel', 'manual', 150, 'XDKJFHSH7HN84753', 2008, 'station wagon', 'd', 5),
       ('Opel', 'Adam S', 150, 1500, 'petrol', 'manual', 170, 'ZARJKD78HN84753', 2016, 'hatchback', 'a', 4);

INSERT INTO address
    (country, city, zip_code, street, building_number)
VALUES ('Poland', 'Wrocław', '34-827', 'Wiejska', '7'),
       ('Poland', 'Kraków', '64-297', 'Leśna', '4'),
       ('Poland', 'Gdynia', '81-457', 'Władysława 4', '40/3');

INSERT INTO client
(first_name, last_name, email, phone_number, bank_account, date_of_birth, driving_license_number, address_id)
VALUES ('Ania', 'Calik', 'anna.calik@wp.pl', '506784567', '4120943700009637', DATE '1995-05-28', 'DHE84392', 1),
        ('Wojtek', 'Kozłowski', 'wojtek.kozlowski@o2.pl', '746895123', '4120000045879632', '2001-04-02', 'ZHS56432', 2),
        ('Marta', 'Lidzka', 'marta.lidzka@gmail.pl', '465782169', '1245978600002156', '1987-02-06', 'HYT65732', 2);


