


INSERT INTO usuario(role, username, senha) 
VALUES ('ADMIN', 'admin', '$2a$12$YcxBeQKXPK.06QNckf.YMeGVm8h.EazFMyURfIDFRHc554uvM3v9K');

INSERT INTO usuario(role, username, senha) 
VALUES ('USER', 'julia', '$2a$12$b7XewJvZ/Th7DLQoqAq9NOMgfl8K72Pg/WsnosdRyuikqRphI.Fua');


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
VALUES ('ABC2D23', '9BWZZZ877VT004251', 'ATIVA', 'MOTTUE', 1);
INSERT INTO moto (placa, chassi, status, modelo, id_galpao) 
VALUES ('ABC1323', '9BW6ZZ377VT004251', 'ATIVA', 'MOTTUE', 1);
INSERT INTO moto (placa, chassi, status, modelo, id_galpao) 
VALUES ('ABC6D23', '9BWZZZ347VT004251', 'INATIVA', 'MOTTUPOP', 1);
INSERT INTO moto (placa, chassi, status, modelo, id_galpao) 
VALUES ('ABC1523', '9BWZZZ377VT004251', 'MANUTENCAO', 'MOTTUE', 1);
INSERT INTO moto (placa, chassi, status, modelo, id_galpao) 
VALUES ('AB31D23', '9BWZZZ377VT304251', 'ATIVA', 'MOTTUPOP', 1);
INSERT INTO moto (placa, chassi, status, modelo, id_galpao) 
VALUES ('ABC6D23', '9BWZZZ377VT054251', 'ATIVA', 'MOTTUPOP', 1);
INSERT INTO moto (placa, chassi, status, modelo, id_galpao) 
VALUES ('ABC1823', '9BWZZZ577VT004251', 'MANUTENCAO', 'MOTTUE', 1);

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
VALUES ('MNO0612', '6D5ZZZ654RT007842', 'INATIVA', 'MOTTUE', 6);
INSERT INTO moto (placa, chassi, status, modelo, id_galpao) 
VALUES ('MNO0712', '6DFZ5Z654RT007842', 'MANUTENCAO', 'MOTTUE', 6);
INSERT INTO moto (placa, chassi, status, modelo, id_galpao) 
VALUES ('MNO6P12', '6DFZZZ654R6007842', 'INATIVA', 'MOTTUE', 6);
INSERT INTO moto (placa, chassi, status, modelo, id_galpao) 
VALUES ('MN80P12', '6DFZZ6654RT007842', 'MANUTENCAO', 'MOTTUSPORT', 6);
INSERT INTO moto (placa, chassi, status, modelo, id_galpao) 
VALUES ('M6O0P12', '6DFZZZ654RT007842', 'INATIVA', 'MOTTUE', 6);
INSERT INTO moto (placa, chassi, status, modelo, id_galpao) 
VALUES ('MNO0P62', '6DFZZZ654RT009842', 'INATIVA', 'MOTTUE', 6);
INSERT INTO moto (placa, chassi, status, modelo, id_galpao) 
VALUES ('MNO6P12', '6DFZZZ654RT607842', 'MANUTENCAO', 'MOTTUSPORT', 6);
INSERT INTO moto (placa, chassi, status, modelo, id_galpao) 
VALUES ('MN60P12', '6DFZZZ6545T007842', 'INATIVA', 'MOTTUE', 6);

-- Moto no Galpão G (id = 7)
INSERT INTO moto (placa, chassi, status, modelo, id_galpao) 
VALUES ('PQR1S23', '5ABZZZ123KT005432', 'ATIVA', 'MOTTUE', 7);
INSERT INTO moto (placa, chassi, status, modelo, id_galpao) 
VALUES ('PQR2S23', '5ABZZZ123KT005433', 'MANUTENCAO', 'MOTTUE', 7);
INSERT INTO moto (placa, chassi, status, modelo, id_galpao) 
VALUES ('PQR3S23', '5ABZZZ123KT005434', 'INATIVA', 'MOTTUPOP', 7);
INSERT INTO moto (placa, chassi, status, modelo, id_galpao) 
VALUES ('PQR4S23', '5ABZZZ123KT005435', 'ATIVA', 'MOTTUSPORT', 7);

-- Moto no Galpão H (id = 8)
INSERT INTO moto (placa, chassi, status, modelo, id_galpao) 
VALUES ('STU5V67', '4XYZZZ321KT008987', 'INATIVA', 'MOTTUE', 8);
INSERT INTO moto (placa, chassi, status, modelo, id_galpao) 
VALUES ('STU6V67', '4XYZZZ321KT008988', 'ATIVA', 'MOTTUPOP', 8);
INSERT INTO moto (placa, chassi, status, modelo, id_galpao) 
VALUES ('STU7V67', '4XYZZZ321KT008989', 'MANUTENCAO', 'MOTTUE', 8);
INSERT INTO moto (placa, chassi, status, modelo, id_galpao) 
VALUES ('STU8V67', '4XYZZZ321KT008990', 'INATIVA', 'MOTTUSPORT', 8);

-- Moto no Galpão I (id = 9)
INSERT INTO moto (placa, chassi, status, modelo, id_galpao) 
VALUES ('VWX9Y12', '3CDZZZ321KT009876', 'ATIVA', 'MOTTUE', 9);
INSERT INTO moto (placa, chassi, status, modelo, id_galpao) 
VALUES ('VWX10Y1', '3CDZZZ321KT009877', 'MANUTENCAO', 'MOTTUPOP', 9);
INSERT INTO moto (placa, chassi, status, modelo, id_galpao) 
VALUES ('VWX11Y1', '3CDZZZ321KT009878', 'INATIVA', 'MOTTUE', 9);
INSERT INTO moto (placa, chassi, status, modelo, id_galpao) 
VALUES ('VWX12Y1', '3CDZZZ321KT009879', 'ATIVA', 'MOTTUSPORT', 9);

