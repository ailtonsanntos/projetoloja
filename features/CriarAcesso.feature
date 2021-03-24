#language: pt
#encoding: iso-8859-1

Funcionalidade: Realizar Cadastro
	Como um usu�rio da loja at
	eu quero acesso minha conta
	para que eu possa realizar compras

Esquema do Cen�rio: Cadastrar usu�rio com sucesso
	Dado Acessar a p�gina de cadastro de usu�rio
	E Informar o <email> 
	E Informar a <senha> 
	Quando Solicitar o registro do usu�rio
	Ent�o o sistema informa a mensagem 
	
Exemplos: 

|       email        |   senha    |
| "Poyki@teste.com"  | "4-Qyr)&W" |
| "Lublin@teste.com"  | "%gnti0k:" |
| "Unra@teste.com"  | "4-Qyr)&W" |


Cen�rio: Valida��o dos campos obrigat�rios
	Dado Acessar a p�gina de cadastro de usu�rio
	E Informar o email 
	E Informar a senha 
	Quando Solicitar o registro do usu�rio
	Ent�o o sistema informa a mensagem uma mensagem