Algoritmo "Happy Traveller"
// Disciplina   : [Linguagem e Lógica de Programação]
// Professor   : Antonio Carlos Nicolodi
//cliente - nome, sobrenome, cpf, endereço, cidade, uf
//viagem ida- origem, destino,data de ida
//viagem volta - origem, destino, data de volta
// -- inicio menu de opções
procedimento menu()
inicio
   escreval("********   MENU   ********   ")
   escreval("CÓDIGO      Opção:           ")
   escreval("  1     cadastrar cliente")
   escreval("  2     cadastrar viagem de ida")
   escreval("  3     cadastrar viagem de volta")
   escreval("  4     consultar")
   escreval("  5     encerrar")
   leia (opcao)
   escolha opcao
   caso 1
      cadastro()
   caso 2
      ida()
   caso 3
      volta()
   caso 4
      consultar()
   caso 5
      fimalgoritmo
   outrocaso
   enquanto (opcao>5) faca
      limpatela
      escreval("                   ---  Happy Treveller  --- ")
      escreval("")
      escreval("")
      escreval (" **opção invalida** ")
      escreval("")
      escreval("")
      menu()
   fimenquanto
fimprocedimento
// -- fim menu

//-- inicio cadastro de clientes
procedimento cadastro()
inicio
   limpatela
   para  l de 1 ate 5 faca
      escreval("                   ---  Happy Treveller  --- ")
      escreval("")
      escreval("")
      escreval ("  --- Dados do Cliente ---   ")
      escreva("Nome: ")
      leia (cliente [l,1])
      escreva("Sobrenome: ")
      leia (cliente [l,2])
      escreva("CPF: ")
      leia (cliente [l,3])
      escreva("Endereço: ")
      leia (cliente [l,4])
      escreva("Cidade: ")
      leia (cliente [l,5])
      escreva("UF: ")
      leia (cliente [l,6])
      escreva("telefone: ")
      leia (cliente [l,7])
      limpatela
      menu()
      escreval("")
   fimpara
fimprocedimento
// -- fim cadastro de clientes

// -- cadastro de viagem de ida
procedimento Ida()
inicio
   limpatela
   para  l de 1 ate 5 faca
      escreval("                   ---  Happy Treveller  --- ")
      escreval("")
      escreval("")
      escreval ("  --- Dados da viagem ---   ")
      escreva("Origem: ")
      leia (vIda [l,1])
      escreva("Destino: ")
      leia (vIda [l,2])
      escreva("(dd/mm/aaaa): ")
      leia (vIda [l,3])

   menu()
   escreval("")
fimpara
fimprocedimento
// -- fim cadastro

// --inicio cadastro viagem de volta
procedimento volta()
inicio
   limpatela
   para  l de 1 ate 5 faca
      escreval ("DATA(dd/mm/aaaa)")
      leia (vVolta [l])
   fimpara
   limpatela
   menu()
   escreval("")
fimpara
fimprocedimento


Var
   cliente:vetor[1..5,1..7] de caracter
   vIda: vetor[1..5,1..3] de caracter
   vVolta: vetor[1..5] de caracter
   l,c: inteiro
   opcao:inteiro



Inicio
   //entrada de dados
   escreval("                   ---  Happy Treveller  --- ")
   escreval("")
   escreval("")
   menu()
fimescolha
Fimalgoritmo
