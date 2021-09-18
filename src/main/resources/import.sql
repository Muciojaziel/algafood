insert into cozinha (id, nome) values (1, 'Tailandesa')
insert into cozinha (id, nome) values (2, 'CozTech')
insert into cozinha (id, nome) values (3, 'Chinesa')

insert into restaurante (nome, taxa_frete, cozinha_id) values ('MariRestaurante', 13, 1)
insert into restaurante (nome, taxa_frete, cozinha_id) values ('RestDev', 10, 2)
insert into restaurante (nome, taxa_frete, cozinha_id) values ('RestCHin', 13, 3)

insert into forma_pagamento (descricao) values ('A vista')
insert into forma_pagamento (descricao) values ('Cartao')
insert into forma_pagamento (descricao) values ('Boleto')

insert into permissao (nome, descricao) values ('Admin','Administrador')
insert into permissao (nome, descricao) values ('Colab','Colaborador')
insert into permissao (nome, descricao) values ('Teste','Teste inserindo perfil')

insert into estado (nome) values ('PE')
insert into estado (nome) values ('AL')
insert into estado (nome) values ('RN')

insert into cidade (nome) values ('Quipapa')
insert into cidade (nome) values ('Garanhuns')
insert into cidade (nome) values ('Recife')
