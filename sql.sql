create database veterinaria;
USE veterinaria;
CREATE TABLE clientes (
   id INT AUTO_INCREMENT PRIMARY KEY,
   nombre VARCHAR(100) NOT NULL,
   email VARCHAR(100) UNIQUE NOT NULL,
   telefono VARCHAR(20),
   direccion VARCHAR(255),
   estado INT NULL DEFAULT 1
);
CREATE TABLE mascotas (
   id INT AUTO_INCREMENT PRIMARY KEY,
   nombre VARCHAR(100) NOT NULL,
   especie VARCHAR(50) NOT NULL,
   raza VARCHAR(50),
   edad INT,
   cliente_id INT NOT NULL,
   FOREIGN KEY (cliente_id) REFERENCES clientes(id) ON DELETE CASCADE
);
CREATE TABLE veterinarios (
   id INT AUTO_INCREMENT PRIMARY KEY,
   nombre VARCHAR(100) NOT NULL,
   especialidad VARCHAR(100) NOT NULL,
   telefono VARCHAR(20),
   email VARCHAR(100) UNIQUE NOT NULL,
    estado INT NULL DEFAULT 1

);
CREATE TABLE citas (
   id INT AUTO_INCREMENT PRIMARY KEY,
   mascota_id INT NOT NULL,
   veterinario_id INT,
   fecha DATETIME NOT NULL,
   motivo VARCHAR(255),
   FOREIGN KEY (mascota_id) REFERENCES mascotas(id) ON DELETE CASCADE,
   FOREIGN KEY (veterinario_id) REFERENCES veterinarios(id) ON DELETE SET NULL
);
CREATE TABLE servicios (
   id INT AUTO_INCREMENT PRIMARY KEY,
   nombre VARCHAR(100) NOT NULL,
   precio DECIMAL(10,2) NOT NULL
);
CREATE TABLE citas_servicios (
   id INT AUTO_INCREMENT PRIMARY KEY,
   cita_id INT NOT NULL,
   servicio_id INT NOT NULL,
   cantidad INT NOT NULL DEFAULT 1,
   FOREIGN KEY (cita_id) REFERENCES citas(id) ON DELETE CASCADE,
   FOREIGN KEY (servicio_id) REFERENCES servicios(id) ON DELETE CASCADE
);
use veterinaria;
INSERT INTO veterinarios (nombre, especialidad, telefono, email) VALUES
('Dr. Luis Martínez', 'Cirugía Veterinaria', '3201234567', 'luis.martinez@email.com'),
('Dra. Paula Herrera', 'Dermatología Veterinaria', '3212345678', 'paula.herrera@email.com'),
('Dr. Javier Ocampo', 'Medicina Interna', '3223456789', 'javier.ocampo@email.com'),
('Dra. Carolina Ríos', 'Cardiología Veterinaria', '3234567890', 'carolina.rios@email.com'),
('Dr. Eduardo Peña', 'Odontología Veterinaria', '3245678901', 'eduardo.pena@email.com'),
('Dra. Verónica Salas', 'Neurología Veterinaria', '3256789012', 'veronica.salas@email.com'),
('Dr. Miguel Arango', 'Ortopedia Veterinaria', '3267890123', 'miguel.arango@email.com'),
('Dra. Natalia Suárez', 'Oncología Veterinaria', '3278901234', 'natalia.suarez@email.com'),
('Dr. Fernando Londoño', 'Gastroenterología Veterinaria', '3289012345', 'fernando.londono@email.com'),
('Dra. Andrea Velásquez', 'Oftalmología Veterinaria', '3290123456', 'andrea.velasquez@email.com');

use veterinaria;
INSERT INTO clientes (nombre, email, telefono, direccion) VALUES
('Juan Pérez', 'juan.perez@email.com', '3001234567', 'Calle 10 #15-30, Bogotá'),
('María Gómez', 'maria.gomez@email.com', '3019876543', 'Carrera 8 #22-10, Medellín'),
('Carlos Ramírez', 'carlos.ramirez@email.com', '3104567890', 'Avenida 5 #45-20, Cali'),
('Ana Torres', 'ana.torres@email.com', '3126781234', 'Diagonal 12 #8-15, Barranquilla'),
('Pedro Sánchez', 'pedro.sanchez@email.com', '3145678901', 'Calle 20 #10-5, Cartagena'),
('Luisa Fernández', 'luisa.fernandez@email.com', '3156789012', 'Transversal 7 #30-12, Bucaramanga'),
('Andrés Castro', 'andres.castro@email.com', '3167890123', 'Carrera 15 #5-18, Manizales'),
('Sofía López', 'sofia.lopez@email.com', '3178901234', 'Avenida 9 #40-22, Pereira'),
('Ricardo Mendoza', 'ricardo.mendoza@email.com', '3189012345', 'Calle 50 #12-30, Ibagué'),
('Elena Vargas', 'elena.vargas@email.com', '3190123456', 'Carrera 3 #14-5, Pasto');