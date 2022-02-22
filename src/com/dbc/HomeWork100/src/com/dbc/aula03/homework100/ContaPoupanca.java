package com.dbc.aula03.homework100;

public class ContaPoupanca extends Conta implements Impressao {

    private final double JUROS_MENSAL = 1.01;

    public ContaPoupanca(Cliente cliente, String numeroConta, String agencia, double saldo) {
        super(cliente, numeroConta, agencia, saldo);
         }


        @Override
        public void imprimir() {
            System.out.println("seu saldo é: " + (getSaldo() * JUROS_MENSAL) + " com juros de 1.01% ao mês!");
        }

}
