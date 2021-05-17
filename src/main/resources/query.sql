CREATE TABLE IF NOT EXISTS planes
(
    id            SERIAL PRIMARY KEY,
    model         VARCHAR NOT NULL,
    serial_number VARCHAR,
    seats         INT
);

CREATE TABLE IF NOT EXISTS pilots
(
    id   SERIAL PRIMARY KEY,
    name VARCHAR NOT NULL,
    age  INT
);

CREATE TABLE IF NOT EXISTS pilots_professionalism
(
    id       SERIAL PRIMARY KEY,
    pilot_id INT REFERENCES pilots (id),
    plane_id INT REFERENCES planes (id)
);

INSERT INTO planes (id, model, serial_number, seats)
VALUES (1, 'Boeing', '747', 467);
INSERT INTO planes (id, model, serial_number, seats)
VALUES (2, 'Airbus', 'A320', 186);
INSERT INTO planes (id, model, serial_number, seats)
VALUES (3, 'Boeing', '747', 467);
INSERT INTO planes (id, model, serial_number, seats)
VALUES (4, 'Airbus', 'A320', 186);
INSERT INTO planes (id, model, serial_number, seats)
VALUES (5, 'Airbus', 'A320', 186);
INSERT INTO planes (id, model, serial_number, seats)
VALUES (6, 'Airbus', 'A320', 186);
INSERT INTO planes (id, model, serial_number, seats)
VALUES (7, 'Airbus', 'A320', 186);

INSERT INTO pilots (id, name, age)
VALUES (1, 'Comandor', 52);
INSERT INTO pilots (id, name, age)
VALUES (2, 'Drinkins', 33);
INSERT INTO pilots (id, name, age)
VALUES (3, 'Merdok', 35);
INSERT INTO pilots (id, name, age)
VALUES (4, 'Maverick', 25);
INSERT INTO pilots (id, name, age)
VALUES (5, 'Gaechka', 5);
INSERT INTO pilots (id, name, age)
VALUES (6, 'Gagarin ', 57);
INSERT INTO pilots (id, name, age)
VALUES (7, 'Anakin Skywalker', 8);
INSERT INTO pilots (id, name, age)
VALUES (8, 'Han Solo ', 37);

INSERT INTO pilots_professionalism (id, pilot_id, plane_id)
VALUES (1, 1, 1);
INSERT INTO pilots_professionalism (id, pilot_id, plane_id)
VALUES (2, 1, 2);
INSERT INTO pilots_professionalism (id, pilot_id, plane_id)
VALUES (3, 2, 1);
INSERT INTO pilots_professionalism (id, pilot_id, plane_id)
VALUES (4, 3, 2);
INSERT INTO pilots_professionalism (id, pilot_id, plane_id)
VALUES (5, 4, 1);
INSERT INTO pilots_professionalism (id, pilot_id, plane_id)
VALUES (6, 4, 2);
INSERT INTO pilots_professionalism (id, pilot_id, plane_id)
VALUES (7, 5, 2);
INSERT INTO pilots_professionalism (id, pilot_id, plane_id)
VALUES (8, 6, 2);
INSERT INTO pilots_professionalism (id, pilot_id, plane_id)
VALUES (9, 7, 2);
INSERT INTO pilots_professionalism (id, pilot_id, plane_id)
VALUES (10, 8, 2);

SELECT pilots.id, pilots.name, pilots.age, planes.id, planes.model, planes.serial_number
FROM pilots
         INNER JOIN pilots_professionalism pp ON pilots.id = pp.pilot_id
         INNER JOIN planes ON pp.plane_id = planes.id
ORDER BY pilots.age;

SELECT plane_id
FROM pilots_professionalism
WHERE pilot_id = ?;

SELECT *
FROM planes
WHERE id = ?;

SELECT sum("seats")
from planes;

SELECT *
FROM planes
ORDER BY seats DESC;

SELECT planes.id, planes.model, planes.serial_number, planes.seats, sum("pilot_id")
FROM pilots_professionalism as pp
         INNER JOIN planes on planes.id = pp.pilot_id
GROUP BY planes.id;

DROP TABLE IF EXISTS pilots CASCADE;
DROP TABLE IF EXISTS planes CASCADE;
DROP TABLE IF EXISTS pilots_professionalism CASCADE;




