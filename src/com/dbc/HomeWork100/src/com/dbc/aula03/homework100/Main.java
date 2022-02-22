package com.dbc.aula03.homework100;

public class Main {

    public static void main(String[] args) {
//                    teste de impressão para Endereço
            Endereco teste = new Endereco(1, "qnj 30 conj L", 35, "casa fundos","78856321","guara","DF","Brasil");
//        System.out.println(teste.toString());
            Endereco teste1 = new Endereco(2,"cdm 30 conj t", 66,"loja","65412325","Brasilia","DF","Brasil");


//            teste  de  impressão para Contato
            Contato testeContato = new Contato("whats","95598745",1);

//            teste impressão de Cliente
        Cliente juh = new Cliente("Juliana", "78954132150");
        Cliente lua = new Cliente("Luana","45678945612");
//        System.out.println(juh.toString());

//        Teste de ContaCorrente:
        ContaCorrente cliente1 = new ContaCorrente(juh,"456","123",500,300);

//        cliente1.retornarSaldoComChequeEspecial();

//        Teste conta poupança
        ContaPoupanca clienteTeste = new ContaPoupanca(lua,"789","321",1000);
        clienteTeste.imprimir();


//            System.out.println(testeContato.toString());
//                juh.imprimirEnderecos();
//                juh.imprimirContatos();
//                  juh.imprimirCliente();
//                  juh.toString();






    }
}
