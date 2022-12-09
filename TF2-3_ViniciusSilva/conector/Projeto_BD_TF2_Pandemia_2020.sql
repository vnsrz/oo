CREATE DATABASE
 IF NOT EXISTS pandemia;

USE pandemia;

CREATE TABLE pessoa (
    idPessoa INT                   NOT NULL AUTO_INCREMENT,
    nome     VARCHAR(90)           NOT NULL,
    saude    ENUM('T','F','C','S') NOT NULL,
	gestante ENUM('S','N','T')     DEFAULT NULL,
    idade    INT                   DEFAULT NULL,
 CONSTRAINT PESSOA_PK PRIMARY KEY (idPessoa)
)ENGINE InnoDB AUTO_INCREMENT = 101;
