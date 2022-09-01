-- Geração de Modelo físico
-- Sql ANSI 2003 - brModelo.



CREATE TABLE DESTINO (
id_local INTEGER PRIMARY KEY,
nome_local VARCHAR(30),
localizacao VARCHAR(30),
pontos turisticos VARCHAR(200)
)

CREATE TABLE CLIENTE (
CPF_cli VARCHAR(12) PRIMARY KEY,
nome_cli VARCHAR(50),
endereco_cli VARCHAR(50),
dn_cli SMALLDATETIME,
telefone_cli VARCHAR(50),
email_cli VARCHAR(30),
num_passaporte VARCHAR(30),
comorbidades_cli VARCHAR(200)
)

CREATE TABLE HOSPEDAGEM (
id_hos INTEGER PRIMARY KEY,
categoria_hos VARCHAR(20),
nome_hos VARCHAR(50),
endereco_hos VARCHAR(50),
local_hos VARCHAR(50),
email_hos VARCHAR(30),
telefone_hos VARCHAR(50),
acessibilidade_hos CHAR(2)
)

CREATE TABLE RESERVA (
inicio_res SMALLDATETIME,
final_res SMALLDATETIME,
num_embarque VARCHAR(10),
preco_res DECIMAL(10),
cod_res INTEGER PRIMARY KEY,
CPF_cli VARCHAR(12),
id_hos INTEGER,
id_local INTEGER,
id INTEGER,
FOREIGN KEY(CPF_cli) REFERENCES CLIENTE (CPF_cli),
FOREIGN KEY(id_hos) REFERENCES HOSPEDAGEM (id_hos),
FOREIGN KEY(id_local) REFERENCES DESTINO (id_local)
)

CREATE TABLE TRANSPORTE (
id INTEGER PRIMARY KEY,
nome_comp VARCHAR(50),
aeroporto_rodoviaria VARCHAR(50),
destino VARCHAR(50),
valor DECIMAL(10)
)

CREATE TABLE acomodacao_hos (
acomodacao_hos_PK INTEGER PRIMARY KEY,
tipo VARCHAR(10),
valor DECIMAL(10),
quantidade INTEGER,
itens VARCHAR(15),
id_hos_FK INTEGER,
FOREIGN KEY(id_hos_FK) REFERENCES HOSPEDAGEM (id_hos)
)

ALTER TABLE RESERVA ADD FOREIGN KEY(id) REFERENCES TRANSPORTE (id)
