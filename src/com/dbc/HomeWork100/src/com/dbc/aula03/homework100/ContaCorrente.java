package com.dbc.aula03.homework100;

public class ContaCorrente {
    Cliente cliente;
    String numeroConta;
    int agencia;
    double saldo;
    double chequeEspecial;


    public void criarContaCorrente(Cliente cliente, String numeroConta, int saldo, int chequeEspecial) {
        this.cliente = cliente;
        this.numeroConta = numeroConta;
        this.saldo = saldo;
        this.chequeEspecial = chequeEspecial;
    }


    public void imprimirContaCorrente() {
        System.out.println("numero da conta corrente é: " + this.numeroConta);
        this.retornarSaldoComChequeEspecial();
    }

    public boolean sacar(double valor) {
        if (valor > 0) {
            if (valor <= (saldo + chequeEspecial)) {
                if (valor < saldo) {
                    saldo -= valor;
                    System.out.println("Saque realizado");
                    return true;
                } else {
                    double valorMenosSaldo = valor - saldo;
                    chequeEspecial -= valorMenosSaldo;
                    saldo = 0;
                    System.out.println(" Seu saldo total é :" + this.retornarSaldoComChequeEspecial());
                    return true;
                }

            }
        }
        System.out.println("o valor de saque não pode ser negativo ou nulo!");
        return false;

    }

    public boolean depositar(double valor) {
        if (valor > 0) {
            saldo += valor;
            System.out.println("deposito realizado!");
            return true;
        }
        System.out.println("Valor menor que o permitido!");
        return false;
    }

    public double retornarSaldoComChequeEspecial() {
        System.out.println(saldo + chequeEspecial);
        return (saldo + chequeEspecial);
    }

    public boolean transferir(ContaCorrente contaCorrente, double valor) {
        if (this.saldo > valor) {
            this.sacar(valor);
            contaCorrente.depositar(valor);
            System.out.println("transferência concluída");
            return true;
        } else {
            System.out.println("saldo insuficiente");
            return false;
        }
    }
}

