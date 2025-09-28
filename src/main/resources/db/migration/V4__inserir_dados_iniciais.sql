INSERT INTO usuario(nome_perfil, username, senha) 
VALUES ('Admin', 'admin', '$2a$12$YcxBeQKXPK.06QNckf.YMeGVm8h.EazFMyURfIDFRHc554uvM3v9K');


INSERT INTO usuario(nome_perfil, username, senha) 
VALUES ('julia', 'julia', '$2a$12$YcxBeQKXPK.06QNckf.YMeGVm8h.EazFMyURfIDFRHc554uvM3v9K');


INSERT INTO galpao (nome, localizacao, capacidade, motos_ocupadas) 
VALUES ('Galpão A', 'São Paulo - Zona Leste', 100, 45);

INSERT INTO galpao (nome, localizacao, capacidade, motos_ocupadas) 
VALUES ('Galpão B','São Paulo - Zona Oeste', 80, 60);

INSERT INTO galpao (nome, localizacao, capacidade, motos_ocupadas) 
VALUES ('Galpão C','Rio de Janeiro - Centro', 120, 90);

INSERT INTO galpao (nome, localizacao, capacidade, motos_ocupadas) 
VALUES ('Galpão D','Belo Horizonte - Contagem', 70, 35);

INSERT INTO galpao (nome, localizacao, capacidade, motos_ocupadas) 
VALUES ('Galpão E','Belo Horizonte - Contagem', 70, 35);

INSERT INTO galpao (nome, localizacao, capacidade, motos_ocupadas) 
VALUES ('Galpão F','Belo Horizonte - Contagem', 70, 35);

INSERT INTO galpao (nome, localizacao, capacidade, motos_ocupadas) 
VALUES ('Galpão G','Belo Horizonte - Contagem', 70, 35);

INSERT INTO galpao (nome, localizacao, capacidade, motos_ocupadas) 
VALUES ('Galpão I','Belo Horizonte - Contagem', 70, 35);

INSERT INTO galpao (nome, localizacao, capacidade, motos_ocupadas) 
VALUES ('Galpão H','Belo Horizonte - Contagem', 70, 35);


INSERT INTO moto (placa, chassi, status, modelo) 
VALUES ('ABC1D23', '9BWZZZ377VT004251', 'ATIVA', 'MOTTUE');

INSERT INTO moto (placa, chassi, status, modelo) 
VALUES ('EFG4H56', '8AJZZZ123KT008652', 'MANUTENCAO', 'MOTTUE');

INSERT INTO moto (placa, chassi, status, modelo) 
VALUES ('IJK7L89', '7HGZZZ456PT009321', 'ATIVA', 'MOTTUE');

INSERT INTO moto (placa, chassi, status, modelo) 
VALUES ('MNO0P12', '6DFZZZ654RT007842', 'INATIVA', 'MOTTUE');


-- Moto no Galpão A (id = 1)
INSERT INTO moto (placa, chassi, status, modelo, id_galpao) 
VALUES ('ABC1D23', '9BWZZZ377VT004251', 'ATIVA', 'MOTTUE', 1);

-- Moto no Galpão B (id = 2)
INSERT INTO moto (placa, chassi, status, modelo, id_galpao) 
VALUES ('EFG4H56', '8AJZZZ123KT008652', 'MANUTENCAO', 'MOTTUE', 2);

-- Moto no Galpão C (id = 3)
INSERT INTO moto (placa, chassi, status, modelo, id_galpao) 
VALUES ('IJK7L89', '7HGZZZ456PT009321', 'ATIVA', 'MOTTUE', 3);

-- Moto no Galpão D (id = 4)
INSERT INTO moto (placa, chassi, status, modelo, id_galpao) 
VALUES ('MNO0P12', '6DFZZZ654RT007842', 'INATIVA', 'MOTTUE', 4);

-- Moto no Galpão E (id = 5)
INSERT INTO moto (placa, chassi, status, modelo, id_galpao) 
VALUES ('MNO0P12', '6DFZZZ654RT007842', 'INATIVA', 'MOTTUE', 5);


-- Moto no Galpão F (id = 6)
INSERT INTO moto (placa, chassi, status, modelo, id_galpao) 
VALUES ('MNO0P12', '6DFZZZ654RT007842', 'INATIVA', 'MOTTUE', 6);


