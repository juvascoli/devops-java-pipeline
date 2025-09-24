ALTER TABLE moto ADD id_galpao BIGINT;

ALTER TABLE moto 
ADD CONSTRAINT fk_moto_galpao
FOREIGN KEY (id_galpao) REFERENCES galpao(id_galpao);
