Algoritmo "Happy Traveller"
//cliente - nome, sobrenome, cpf, endere�o, cidade, uf
//viagem- origem, destino,data de ida,data de volta

// -- inicio menu de op��es
procedimento menu()
inicio
   escreval("********   MENU   ********   ")
   escreval("C�DIGO      Op��o:           ")
   escreval("  1     cadastrar cliente")
   escreval("  2     cadastrar viagem")
   escreval("  3     consultar")
   escreval("  4     encerrar")
   leia (opcao)
   escolha opcao
   caso 1
      cadastro()
   caso 2
      ida()
   caso 3
      buscar()
   caso 4
fimalgoritmo
outrocaso
   enquanto (opcao>4) faca
      limpatela
      escreval("                   ---  Happy Treveller  --- ")
      escreval("")
      escreval("")
      escreval (" **op��o invalida** ")
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

   para l de 0 ate 10 faca
      l<- posicao
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
      escreva("Endere�o: ")
      leia (cliente [l,4])
      escreva("Cidade: ")
      leia (cliente [l,5])
      escreva("UF: ")
      leia (cliente [l,6])
      escreva("telefone: ")
      leia (cliente [l,7])
      posicao<- l+1

      limpatela
      menu()
      escreval("")
   fimpara
fimprocedimento
// -- fim cadastro de clientes

// -- inicio cadastro de viagem
procedimento Ida()
inicio
   limpatela
   para  i de 0 ate 10 faca
      i<- con
      escreval("                   ---  Happy Treveller  --- ")
      escreval("")
      escreval("")
      escreval ("  --- Dados da viagem ---   ")
      escreva("Origem: ")
      leia (viagem [i,1])
      escreva("Destino: ")
      leia (viagem [i,2])
      escreva("(dd/mm/aaaa) sa�da: ")
      leia (viagem [i,3])
      escreva("(dd/mm/aaaa) Retorno: ")
      leia (viagem [i,4])
      con<- i+1
      escreval("")
      escreval("")
      menu()
      escreval("")
   fimpara
fimprocedimento
// -- fim cadastro

// --inicio buscador
procedimento buscar()
inicio
   limpatela
   escreval("para encontrar os dados desejados insira")
   escreva("Nome: ")
   leia (b1)
   escreva("Sobrenome:")
   leia (b2)
   achou<-0
   para c de 0 ate 10 faca
         se (b1=cliente[c,1])e(b2=cliente[c,2]) entao
         achou<- 1
         limpatela
         escreval("                   ---  Happy Treveller  --- ")
         escreval("")
         escreval("")
         escreval ("  --- Dados do Cliente ---   ")
         escreval("")
         escreval("")
         escreval("Cliente: " + cliente[c,2] + "," +cliente[c,1] )
         escreval("CPF: "+ cliente[c,3])
         escreval("Endere�o: " + cliente[c,4] + " , " + cliente[c,5]+ " - " + cliente[c,6] )
         escreval("Telefone: " + cliente[c,7] )
         escreval("")
         escreval("")
         escreval ("  --- Dados da viagem ---   ")
         escreval("")
         escreval("")
         escreval("Origem: " + viagem[c,1] + "    Destino:" + viagem[c,2] )
         escreval("Sa�da: " + viagem[c,3] + "       Retorno: " + viagem[c,4] )
      fimse

   fimpara
   
   se  (achou=0) entao
      escreval("cliente n�o encontrado")
   fimse
   escreval("")
   escreval("")
   menu()
   escreval("")


fimprocedimento


Var
   cliente:vetor[0..10,1..7] de caracter
   viagem: vetor[0..10,1..4] de caracter
   l,i, v, c, achou: inteiro
   opcao:inteiro
   posicao,con,bb:inteiro
   b1,b2: caracter


Inicio
   //entrada de dados
   escreval("                   ---  Happy Treveller  --- ")
   escreval("")
   escreval("")
   menu()

Fimalgoritmo
