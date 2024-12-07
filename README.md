# Sistema de Gestión de Usuarios y Horóscopo

## Descripción
Este es un sistema de gestión de usuarios y administradores que permite registrar usuarios, autenticarlos, consultar su horóscopo basado en su fecha de nacimiento, y gestionarlos (editar/eliminar) desde una interfaz de administrador.

El proyecto tiene las siguientes características principales:
- Registro de usuarios con cálculo automático de su horóscopo basado en fechas predefinidas.
- Inicio de sesión para usuarios y administradores.
- Dashboard para administradores que incluye:
    - Consulta de la lista de horóscopos.
    - Gestión de usuarios: edición y eliminación.

## Advertencia
El sistema está diseñado para funcionar únicamente con fechas de nacimiento en el rango:
- Desde: `1924-02-05 00:00:00`
- Hasta: `2024-02-09 23:59:59`

## Base de Datos
El proyecto utiliza MySQL como motor de base de datos. A continuación, se incluyen las consultas SQL necesarias para crear las tablas y datos iniciales.

### Tablas
```sql
CREATE DATABASE horoscopodb;
USE horoscopodb;

CREATE TABLE admins (
                        id INT AUTO_INCREMENT PRIMARY KEY,
                        nombre VARCHAR(255) NOT NULL,
                        username VARCHAR(255) UNIQUE NOT NULL,
                        email VARCHAR(255) UNIQUE NOT NULL,
                        password VARCHAR(255) NOT NULL,
                        created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

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
ALTER TABLE usuarios MODIFY animal INT NULL;
```

El archivo "horoscopo query.sql" contiene todas las sentencias necesarias para la base de datos.