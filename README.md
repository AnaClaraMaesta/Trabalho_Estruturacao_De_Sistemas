# Trabalho_Estruturacao_De_Sistemas

Tabelas exercicio 1:
Cliente
Aluguel
HorarioQuadra

regras exercio 1:
Cliente: É proibido cadastrar clientes com o nome vazio ou em branco. O cadastro de clientes deve conter, no mínimo, nome e telefone.
Horário: Não é permitido cadastrar horários com valores negativos. Não é possível reservar um horário que já esteja ocupado.
Aluguel: Cada registro de aluguel deve conter obrigatoriamente o cliente, o horário e o valor cobrado.

tabelas exercicio 2:
Aluno
Livro
Emprestimo
Multa

regras de negocio exercicio 2:
Livro: Não pode ser cadastrado vazio ou apenas com espaços.
Quantidade: Não pode ser um número negativo.
O livro precisa ter, no mínimo, título, autor e quantidade.
Estoque Crítico: Só é permitido realizar o empréstimo se a quantidade disponível for maior que zero.
Controle de Saída: Ao realizar um empréstimo, o sistema deve subtrair 1 da quantidade disponível do livro.
Vínculo: Cada empréstimo deve obrigatoriamente ligar um Aluno a um Livro.

tabelas exercicio 3:
Cliente
Produto
Pedido

regras de negocio exercicio 3:
Nome do Produto: É proibido cadastrar produtos com o nome vazio ou em branco.
Preço: Não é permitido cadastrar produtos com valor negativo.
Dados Obrigatórios: O cadastro deve conter, no mínimo, nome, descrição e preço.
Composição Mínima: Um pedido só pode ser finalizado se tiver pelo menos um produto adicionado. (Isso evita pedidos vazios no sistema).
Multiplicidade: O sistema deve permitir que um único pedido contenha vários produtos diferentes.
