CREATE TABLE ROL(
	id_rol INT NOT NULL,
    nombre VARCHAR(100) NOT NULL,
    PRIMARY KEY (id_rol)
);

CREATE TABLE USUARIO(
	id_usuario INT NOT NULL AUTO_INCREMENT,
    id_rol INT NOT NULL,
    nombre VARCHAR(200) NOT NULL,
    activo VARCHAR(1) NOT NULL,
    PRIMARY KEY (id_usuario),
    FOREIGN KEY (id_rol) REFERENCES ROL(id_rol)
);