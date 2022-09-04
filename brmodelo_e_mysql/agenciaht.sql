create database Agenciaht;
use agenciaht;
CREATE TABLE HOSPEDAGEM (
id_hos INTEGER PRIMARY KEY auto_increment,
nome_hos VARCHAR(50),
endereco_hos VARCHAR(50),
telefone_hos VARCHAR(50),
valor_hos double
);

CREATE TABLE CLIENTE (
CPF_cli VARCHAR(12) PRIMARY KEY,
nome_cli VARCHAR(50),
endereco_cli VARCHAR(50),
telefone_cli VARCHAR(50),
email_cli VARCHAR(30)
);

CREATE TABLE RESERVA (
cod_res INTEGER PRIMARY KEY,
inicio_res date,
final_res date,
preco_res DECIMAL(10),
CPF_cli VARCHAR(12),
id_hos INTEGER,
id_local INTEGER,
id INTEGER,
FOREIGN KEY(CPF_cli) REFERENCES CLIENTE (CPF_cli),
FOREIGN KEY(id_hos) REFERENCES HOSPEDAGEM (id_hos)
);

CREATE TABLE DESTINO (
id_local INTEGER PRIMARY KEY auto_increment,
nome_local VARCHAR(30),
localizacao VARCHAR(30),
valor_passeios double
);

CREATE TABLE TRANSPORTE (
id INTEGER PRIMARY KEY auto_increment,
nome_comp VARCHAR(50),
aeroporto_rodoviaria VARCHAR(50),
num_embarque VARCHAR(50),
valor double
);

ALTER TABLE RESERVA ADD FOREIGN KEY(id_local) REFERENCES DESTINO (id_local);
ALTER TABLE RESERVA ADD FOREIGN KEY(id) REFERENCES TRANSPORTE (id);
