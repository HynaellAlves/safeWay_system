/* Inserindo Empresas fictícias */

INSERT INTO table_enterprise(cnpj_id, name, corporation_Email, saldo, PE) VALUES (5192133367, 'VIVO Fibra', 'netfibra@vivo.com', 2500, 'M');
INSERT INTO table_enterprise(cnpj_id, name, corporation_Email, saldo, PE) VALUES (7397730267, 'Claro Fibra', 'netfibra@claro.com', 1700, 'S');
INSERT INTO table_enterprise(cnpj_id, name, corporation_Email, saldo, PE) VALUES (8797973467, 'LATAM linhas aereas', 'linhasaereas@latam.com', 5300, 'B');

/* Inserindo Usuários fictícios */

INSERT INTO table_client(CPF, id_enterprise, first_Name, last_Name, Email) VALUES (2476425891, 7397730267, 'Bianca', 'Oliveira', 'bibioliveira@gmail.com')
INSERT INTO table_client(CPF, id_enterprise, first_Name, last_Name, Email) VALUES (3648527904, 5192133367, 'Eduardo', 'Santos', 'edusantos@gmail.com')
INSERT INTO table_client(CPF, id_enterprise, first_Name, last_Name, Email) VALUES (6987425813, 8797973467, 'Leonardo', 'Da Cruz', 'leocruz@gmail.com')