CREATE TABLE IF NOT EXISTS planes
(
    id            SERIAL PRIMARY KEY,
    model         VARCHAR UNIQUE NOT NULL,
    serial_number VARCHAR,
    seats         INT
);

CREATE TABLE IF NOT EXISTS pilots
(
    id   SERIAL PRIMARY KEY,
    name VARCHAR UNIQUE NOT NULL,
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

INSERT INTO pilots (id, name, age)
VALUES (1, 'Comandor', 52);
INSERT INTO pilots (id, name, age)
VALUES (2, 'Drinkins ', 33);
INSERT INTO pilots (id, name, age)
VALUES (3, 'Merdok ', 35);

INSERT INTO pilots_professionalism (id, pilot_id, plane_id)
VALUES (1, 1, 1);
INSERT INTO pilots_professionalism (id, pilot_id, plane_id)
VALUES (2, 1, 2);
INSERT INTO pilots_professionalism (id, pilot_id, plane_id)
VALUES (3, 2, 1);
INSERT INTO pilots_professionalism (id, pilot_id, plane_id)
VALUES (4, 3, 2);

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
from planes