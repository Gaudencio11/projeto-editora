# projeto-editora
Plataforma para Editora gerir seus pedidos e para livrarias fazerem seus pedidos para essa editora.

#Tecnologias do Projeto: Java Spring Boot e Bootstrap

#Bd: PostgreSQL


Conficurações Iniciais:
-> Esperar serem Instaladas todas as dependências 
-> Criar Uma database no Postgres chamado "editora"
-> Editar suas credenciais do Postgres em resources/application.properties


=>Como o Site Funciona:

Temos a página principal, que é a página da editora. Lá ela pode ver os pedidos que foram realizados e seus STATUS.
Os pedidos são pedidos de remessas de livros feitos pelas Livrarias

>>Apenas Livrarias cadastradas podem fazer pedidos. 
>>Apenas a editora, através da sua página principal, pode adicionar novas Livrarias Parceiras.

Temos também a página dedicada das livrarias. Lá elas podem criar os pedidos, inserindo nome do livro, quantidade de livros e Livraria

=>Sobre o Status
É a forma de organizar os pedidos.
>Pedidos com o status de FEITO só indica que foi um pedido criado
>Pedidos com o Statur de Aprovado é um pedido que foi aprovado pela editora e seu valor já foi atribuido 
>Pedidos com o Status PAGO são aqueles em que o pagamento foi efetuado e ENVIADO para aqueles pedidos qeu já foram enviados as livrarias


=>Vale resaltar:
O site foi concebido para ter um sistema de login. Na falta deste, os botões seletores <Área da Editora> e <Área da Livraria> funcionam como transição entre as duas interfaces 


Ações do crud: criar, editar, deletar e ler pedidos. Criar e ler editoras 

=>Utilização do site:
Sempre se lembre que somente Livrarias cadastradas podem fazer pedidos. Então a primeira coisa a se fazer é adicionar uma Livraria 
