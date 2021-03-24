#language: pt
#encoding: iso-8859-1

Funcionalidade: Realizar Cadastro
	Como um usuário da loja at
	eu quero acesso minha conta
	para que eu possa realizar compras

Esquema do Cenário: Cadastrar usuário com sucesso
	Dado Acessar a página de cadastro de usuário
	E Informar o <email> 
	E Informar a <senha> 
	Quando Solicitar o registro do usuário
	Então o sistema informa a mensagem 
	
Exemplos: 

|       email         |   senha    |
| "Suzan@teste.com"   | "4-Qyr)&W" |
| "Tiopuho@teste.com" | "%gnti0k:" |
| "Esbir@teste.com"   | "4-Qyr)&W" |


Cenário: Validação dos campos obrigatórios
	Dado Acessar a página de cadastro de usuário
	E Informar o email 
	E Informar a senha 
	Quando Solicitar o registro do usuário
	Então o sistema informa a mensagem uma mensagem