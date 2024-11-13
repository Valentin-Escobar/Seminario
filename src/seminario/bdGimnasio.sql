CREATE DATABASE bdGimnasio;
USE bdGimnasio;

CREATE TABLE Turnos (
Dia INT PRIMARY KEY,
Mes INT,
Hora INT
);


CREATE TABLE Clientes (
DNI INT PRIMARY KEY,
NombreApellido VARCHAR (50),
Telefono INT
);

INSERT INTO Clientes 
(DNI, NombreApellido, Telefono) VALUES 
(1, "Ernesto García", 364758493),
(2, "Francisco Dominguez", 567473845), 
(3, "Dante Gómez", 45766483);

INSERT INTO Turnos (Dia, Mes, Hora) VALUES 
(22, 05, 18), 
(15, 07, 16), 
(3, 08, 10);

SELECT * FROM Clientes;
SELECT * FROM Turnos;

DELETE FROM Clientes;
DELETE FROM Turnos;
