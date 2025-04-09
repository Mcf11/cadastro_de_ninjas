-- V2: Migrations para adicionar a coluna de rank na tabela de cadastro
ALTER TABLE TB_CADASTRO_NINJA
ADD COLUMN rank VARCHAR(255);