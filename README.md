CRUDARqSoft

[BIBLIOTECAS ADICIONAIS]
o Sistema faz uso de uma biblioteca em formato jar chamada Simple-JSON
ele é usado pra gerenciar a entrada e saída de arquivo no sistema, o formato
json foi utilizado por sua facilidade no processo de parsing e agilidade no processo
de atribuição de valores aos objetos JSON.

O projeto JSON - Simple, pode ser baixado pelo site:
https://code.google.com/archive/p/json-simple/

na ala downloads.


A biblioteca Exige a adição do diretório do .jar à variável de ambiente CLASSPATH
(essencial para compilar o projeto)

O sistema ainda não foi testado em unix. Ver tutoriais disponíveis no site do
JSON-Simple.


[COMPILANDO O SISTEMA]
o sistema foi feito utilizando ecplipse 2020-03. Recomenda-se possuir a IDE para
compilação em ambiente de desenvolvimento ideal. Pode ser rodado em modo de compatibilidade
com netBeans IDE.

[FUNCIONAMENTO DO SISTEMA]
O sistema funciona da seguinte forma:

O painel inicial apresenta uma tabela, onde podem ser feitas consultas sobre os clientes.
Para visualizar um cliente de forma detalhada, realize um dplo-clique em sua linha da tabela
ou selecione a linha desejada e pressione a tecla 'enter'.

Para remover ou editar as entradas da tabela é necessário escolher uma respactiva linha.

O botão acessar novo cliente abre uma janela com o formulário necessário para adicionar um novo cliente
dependentes podem ser adicionados ou removidos aos clientes (total de 10).

Todos os clientes e seus dependentes passam por validações:

de cpf, se necessário
de idade

O sistema ainda não conta com a funcionalidade de visualizar os dependentes de forma detalhada, porém,
pode ser adicionado em versões futuras.