Algoritmo "Happy Traveller"
//cliente - nome, sobrenome, cpf, endereço, cidade, uf
//viagem ida- origem, destino,data de ida
//viagem volta - origem, destino, data de volta
//cadastro de clientes
procedimento cadastro()
inicio
limpatela
   para  l de 1 ate 5 faca
      escreval ("Insira: Nome, Sobrenome, CPF, Endereço, Cidade, UF, telefone")
      para  c de 1 ate 7 faca

         leia (cliente [l,c])
      fimpara
      limpatela
      menu()
      escreval("")
   fimpara
fimprocedimento
//cadastro viagem de ida
procedimento Ida()
inicio
limpatela
   para  l de 1 ate 5 faca
      escreval ("Insira: Origem, Destino, DATA(dd/mm/aaaa)")
      para  c de 1 ate 3 faca

         leia (viagemIda [l,c])
      fimpara
      limpatela
      menu()
      escreval("")
   fimpara
fimprocedimento
//cadastro viagem de volta
procedimento volta()
inicio
limpatela
   para  l de 1 ate 5 faca
      escreval ("Insira: Origem, Destino, DATA(dd/mm/aaaa)")
      para  c de 1 ate 3 faca

         leia (viagemVolta [l,c])
      fimpara
      limpatela
      menu()
      escreval("")
   fimpara
fimprocedimento
//menu de opções
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
fimprocedimento

Var
   cliente:vetor[1..5,1..7] de caracter
   viagemIda: vetor[1..5,1..3] de caracter
   viagemVolta: vetor[1..5,1..3] de caracter
   l,c: inteiro
   opcao:inteiro



Inicio
   //entrada de dados

   menu()
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
   limpatela
   escreval ("opção invalida")
   menu()
fimescolha





Fimalgoritmo
