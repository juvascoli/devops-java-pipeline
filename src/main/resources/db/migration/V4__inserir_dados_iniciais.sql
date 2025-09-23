INSERT INTO usuario(nome_perfil, username, senha) 
VALUES ('Admin', 'admin', '$2a$12$YcxBeQKXPK.06QNckf.YMeGVm8h.EazFMyURfIDFRHc554uvM3v9K');


INSERT INTO usuario(nome_perfil, username, senha) 
VALUES ('julia', 'julia', '$2a$12$YcxBeQKXPK.06QNckf.YMeGVm8h.EazFMyURfIDFRHc554uvM3v9K');


INSERT INTO galpao (localizacao, capacidade, motos_ocupadas) 
VALUES ('São Paulo - Zona Leste', 100, 45);

INSERT INTO galpao (localizacao, capacidade, motos_ocupadas) 
VALUES ('São Paulo - Zona Oeste', 80, 60);

INSERT INTO galpao (localizacao, capacidade, motos_ocupadas) 
VALUES ('Rio de Janeiro - Centro', 120, 90);

INSERT INTO galpao (localizacao, capacidade, motos_ocupadas) 
VALUES ('Belo Horizonte - Contagem', 70, 35);


INSERT INTO moto (placa, chassi, status, modelo) 
VALUES ('ABC1D23', '9BWZZZ377VT004251', 'ATIVA', 'Honda CG 160');

INSERT INTO moto (placa, chassi, status, modelo) 
VALUES ('EFG4H56', '8AJZZZ123KT008652', 'MANUTENCAO', 'Yamaha Fazer 250');

INSERT INTO moto (placa, chassi, status, modelo) 
VALUES ('IJK7L89', '7HGZZZ456PT009321', 'ATIVA', 'Honda Biz 125');

INSERT INTO moto (placa, chassi, status, modelo) 
VALUES ('MNO0P12', '6DFZZZ654RT007842', 'INATIVA', 'Yamaha NMAX 160');

