ALTER TABLE moto ADD galpao_id BIGINT;

ALTER TABLE moto 
ADD CONSTRAINT fk_moto_galpao
FOREIGN KEY (galpao_id) REFERENCES galpao(id_galpao);
