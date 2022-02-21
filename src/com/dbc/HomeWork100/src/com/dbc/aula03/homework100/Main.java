package com.dbc.aula03.homework100;

public class Main {

    public static void main(String[] args) {
//                    teste de impressão para Endereço
            Endereco teste = new Endereco();
            teste.tipo = 1;
            teste.numero = 25;
            teste.logradouro = "qnm 20 conjunto N";
            teste.complemento = "casa 25";
            teste.cep = "72210-214";
            teste.cidade = "ceilândia";
            teste.estado = "distrito Federal";
            teste.pais = "Brasil";

//            teste da classe de Contato para impressão
            Contato teste1 = new Contato();
            teste1.descricao = "residencial";
            teste1.telefone = "33710769";
            teste1.tipo = 2;

//            criando Cliente
            Cliente lking = new Cliente();
            lking.nome = "lking";
            lking.cpf = "12345678941";
            lking.contato1("residencial", "789456123", 1);
            lking.contato2("comercial", "78945143", 2);
            lking.endereco1(2,"qnj 30 cnj n", 1, "casa","12485678", "taguatinga", "DF","Brasil");
            lking.endereco2(1,"qcoasi cnj n", 123, "apartamento","151548254", "guara", "DF","Brasil");

            Cliente joao = new Cliente();
            joao.nome = "joao";
            joao.cpf = "12345678950";
            joao.contato1("residencial", "456564879",1);
            joao.contato2("comercial", "65984124", 2);
            joao.endereco1(1,"qnj 30 conj h", 25, "casa", "12456789","gama","df","Brasil");
            joao.endereco2(2,"qnj",32, "apartamento", "457896540", "palmas","TO","Brasil");

//            criando conta corrente:
            ContaCorrente cliente2 = new ContaCorrente();
            cliente2.criarContaCorrente(lking,"123",500,300);

            ContaCorrente cliente1 = new ContaCorrente();
            cliente1.criarContaCorrente(joao, "456", 1000, 500);


//              Execução dos comandos do Cliente
        lking.imprimirEnderecos();
            System.out.println("");
        lking.imprimirContatos();
            System.out.println("");
        lking.imprimirCliente();
            System.out.println("");

//        executando os comandos da classe ContaCorrente
            System.out.println("cliente que vai receber a transferencia!");
            cliente1.imprimirContaCorrente();
            System.out.println(" ");
            System.out.println("\n imprimir a conta corrente de quem vai fazer a transferencia: ");
            cliente2.imprimirContaCorrente();
            System.out.println("\n saque:");
            cliente2.sacar(200);
            cliente2.retornarSaldoComChequeEspecial();
            System.out.println("\ndepositar:");
            cliente2.depositar(50);
            cliente2.retornarSaldoComChequeEspecial();
            System.out.println("\nretornar saldo + o cheque especial:");
            cliente2.retornarSaldoComChequeEspecial();
            System.out.println("\ntransferencia:");
            cliente2.transferir(cliente1,200);
            cliente2.retornarSaldoComChequeEspecial();
            System.out.println("saldo da conta do cliente que recebeu:");
            cliente1.retornarSaldoComChequeEspecial();



    }
}
