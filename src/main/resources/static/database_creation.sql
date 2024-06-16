CREATE DATABASE KATIO
COLLATE = `uca1400_spanish_ai_ci`;
// Tabla users
CREATE TABLE Usuarios
(
    Id INT NOT NULL AUTO_INCREMENT,
    Nombre NVARCHAR(255) NOT NULL,
    Apellido NVARCHAR(255) NOT NULL,
    Email NVARCHAR(255) NOT NULL,
    Telefono NVARCHAR(20) NOT NULL,
    Identificacion NVARCHAR(20) NOT NULL,
    Password NVARCHAR(255) NOT NULL, 
    PRIMARY KEY(ID),
    INDEX email_idx(Email)
);


