package com.dbc.aula03.homework100;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
//arrumar a transferencia da conta...
//

            Contato teste3 = new Contato("whats","78965412",1);

//                    teste de impressão para Endereço
            Endereco teste = new Endereco(1, "qnj 30 conj L", 35, "casa fundos","78856321","guara","DF","Brasil");
        System.out.println(teste.toString());
            Endereco teste1 = new Endereco(2,"cdm 30 conj t", 66,"loja","65412325","Brasilia","DF","Brasil");


//            teste  de  impressão para Contato
            Contato testeContato = new Contato("whats","95598745",2);

//            teste impressão de Cliente
        Cliente paulo = new Cliente("Paulo","12354687453",testeContato,teste);
        Cliente lua = new Cliente("Luana", "45678912320",teste3,teste1);
//        System.out.println(paulo.toString());

        lua.imprimirCliente();

        System.out.println("\n##############################################################################\n");
//        Teste de ContaCorrente:
        ContaCorrente clienteCorrente = new ContaCorrente(paulo,"456","123",1000,300);
       clienteCorrente.sacar(1400);


        System.out.println("\n##############################################################################\n");

//        cliente1.retornarSaldoComChequeEspecial();
        ContaPagamento clientePagamento = new ContaPagamento(paulo,"654","123",1000);
//        cliente.sacar(200);
        clientePagamento.depositar(200);
        System.out.println(clientePagamento.getSaldo());
        System.out.println("\n##############################################################################\n");
//        Teste conta poupança
        ContaPoupanca clientePoupanca = new ContaPoupanca(lua,"789","321",1000);
//        clienteTeste.imprimir();
//        clienteTeste.creditarTaxa();

        clienteCorrente.transferir(clientePoupanca,300);

        System.out.println("\n##############################################################################\n");
        clientePagamento.sacar(200);
//            System.out.println(testeContato.toString());
//                paulo.imprimirEnderecos();
//                paulo.imprimirContatos();
//                  paulo.imprimirCliente();
//                 paulo.toString();






    }
}
