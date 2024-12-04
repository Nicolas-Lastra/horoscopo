CREATE DATABASE horoscopodb;
USE horoscopodb;

CREATE TABLE `horoscopo` (
  `id` integer PRIMARY KEY AUTO_INCREMENT,
  `animal` varchar(255),
  `fecha_inicio` datetime,
  `fecha_fin` datetime
);

CREATE TABLE `usuarios` (
  `id` integer PRIMARY KEY AUTO_INCREMENT,
  `nombre` varchar(255),
  `username` varchar(255),
  `email` varchar(255),
  `fecha_nacimiento` timestamp,
  `password` varchar(255),
  `animal` integer
);

ALTER TABLE `usuarios` ADD FOREIGN KEY (`animal`) REFERENCES `horoscopo` (`id`);

INSERT INTO horoscopo (animal, fecha_inicio, fecha_fin) VALUES
('Rata', '1924-02-05 00:00:00', '1925-01-24 23:59:59'),
('Buey', '1925-01-25 00:00:00', '1926-02-12 23:59:59'),
('Tigre', '1926-02-13 00:00:00', '1927-02-01 23:59:59'),
('Conejo', '1927-02-02 00:00:00', '1928-01-22 23:59:59'),
('Dragón', '1928-01-23 00:00:00', '1929-02-09 23:59:59'),
('Serpiente', '1929-02-10 00:00:00', '1930-01-29 23:59:59'),
('Caballo', '1930-01-30 00:00:00', '1931-02-16 23:59:59'),
('Cabra', '1931-02-17 00:00:00', '1932-02-05 23:59:59'),
('Mono', '1932-02-06 00:00:00', '1933-01-25 23:59:59'),
('Gallo', '1933-01-26 00:00:00', '1934-02-13 23:59:59'),
('Perro', '1934-02-14 00:00:00', '1935-02-03 23:59:59'),
('Cerdo', '1935-02-04 00:00:00', '1936-01-23 23:59:59');

INSERT INTO usuarios (nombre, username, email, fecha_nacimiento, password, animal) VALUES
('Juan Pérez', 'juanito', 'juan.perez@example.com', '1990-04-05 00:00:00', 'securePass123', 1),
('María López', 'maria89', 'maria.lopez@example.com', '1995-05-15 00:00:00', 'password123', 2),
('Carlos Ruiz', 'carlos_rz', 'carlos.ruiz@example.com', '1988-06-11 00:00:00', 'qwerty123', 3),
('Ana Gómez', 'anita_g', 'ana.gomez@example.com', '1992-07-09 00:00:00', '123abc', 4),
('Luis Martínez', 'luism', 'luis.martinez@example.com', '1985-08-19 00:00:00', 'luisPass1984', 5),
('Sofía Vargas', 'sofia_v', 'sofia.vargas@example.com', '1997-09-18 00:00:00', 'sofiapass123', 6),
('Pablo Torres', 'pablot', 'pablo.torres@example.com', '2001-10-10 00:00:00', 'pablopass', 7),
('Elena Navarro', 'elenan', 'elena.navarro@example.com', '1993-11-15 00:00:00', 'elenapass', 8),
('Ricardo Díaz', 'ricardod', 'ricardo.diaz@example.com', '1980-12-10 00:00:00', 'ricardopass', 9),
('Marta Jiménez', 'martaj', 'marta.jimenez@example.com', '1984-01-10 00:00:00', 'martapass', 10),
('Daniel Vega', 'danielv', 'daniel.vega@example.com', '1999-02-05 00:00:00', 'danielpass', 11),
('Lucía Romero', 'luciar', 'lucia.romero@example.com', '1998-03-15 00:00:00', 'luciapass', 12);

SELECT * FROM horoscopo;
SELECT * FROM usuarios;

SELECT 
    usuarios.nombre AS nombre_usuario,
    usuarios.username AS nombre_usuario,
    horoscopo.animal AS signo_horoscopo
FROM 
    usuarios
JOIN 
    horoscopo
ON 
    usuarios.animal = horoscopo.id;
    
DROP DATABASE horoscopodb; -- borrar base de datos, último recurso