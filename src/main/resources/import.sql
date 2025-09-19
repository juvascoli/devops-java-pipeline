INSERT INTO galpao (localizacao, capacidade, motos_ocupadas) 
VALUES ('São Paulo - Zona Leste', 100, 45);

INSERT INTO galpao (localizacao, capacidade, motos_ocupadas) 
VALUES ('São Paulo - Zona Oeste', 80, 60);

INSERT INTO galpao (localizacao, capacidade, motos_ocupadas) 
VALUES ('Rio de Janeiro - Centro', 120, 90);

INSERT INTO galpao (localizacao, capacidade, motos_ocupadas) 
VALUES ('Belo Horizonte - Contagem', 70, 35);


INSERT INTO moto (placa, chassi, status, modelo) 
VALUES ('ABC1D23', '9BWZZZ377VT004251', 'Ativa', 'Honda CG 160');

INSERT INTO moto (placa, chassi, status, modelo) 
VALUES ('EFG4H56', '8AJZZZ123KT008652', 'Manutenção', 'Yamaha Fazer 250');

INSERT INTO moto (placa, chassi, status, modelo) 
VALUES ('IJK7L89', '7HGZZZ456PT009321', 'Ativa', 'Honda Biz 125');

INSERT INTO moto (placa, chassi, status, modelo) 
VALUES ('MNO0P12', '6DFZZZ654RT007842', 'Inativa', 'Yamaha NMAX 160');





-- username: admin e senha: admin
insert into usuario(img_perfil, nome_perfil, senha, username) values('https://i0.wp.com/media.tumblr.com/tumblr_lga4hf2NWD1qfdzua.jpg','Administrador FIAP', '$2a$12$YcxBeQKXPK.06QNckf.YMeGVm8h.EazFMyURfIDFRHc554uvM3v9K' 'admin');
