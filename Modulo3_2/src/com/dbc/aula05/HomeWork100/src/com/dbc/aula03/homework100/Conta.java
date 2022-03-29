package com.dbc.aula03.homework100;

public abstract class Conta implements Movimentacao {
    private Cliente cliente;
    private String numeroConta;
    private String agencia;
    private double saldo;


    public Conta(Cliente cliente, String numeroConta, String agencia, double saldo) {
        this.cliente = cliente;
        this.numeroConta = numeroConta;
        this.agencia = agencia;
        this.saldo = saldo;
    }
    public Conta(){

    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public String getNumeroConta() {
        return numeroConta;
    }

    public void setNumeroConta(String numeroConta) {
        this.numeroConta = numeroConta;
    }

    public String getAgencia() {
        return agencia;
    }

    public void setAgencia(String agencia) {
        this.agencia = agencia;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    @Override
    public boolean sacar(double valor) {
        if (valor > 0 && valor < saldo) {
            this.saldo -= valor;
            System.out.println(" você sacou : R$" + valor + "\nseu saldo atual é de: "+ this.saldo);
           return true;
        } else{
            System.out.println(" Saldo insuficiente!");
            return false;
        }

        }




    @Override
    public boolean depositar(double valor) {
        if (valor <= 0.0) {
            System.err.println("impossível depositar valor negativo ou zero");
            return false;
        } else {
            this.saldo += valor;
            System.out.println("seu saldo é de: " + this.saldo);
            return true;
        }
    }

    @Override
    public boolean transferir(Conta conta, double valor) {
        if (this.saldo > valor) {
            this.sacar(valor);
            conta.depositar(valor);
            System.out.println("transferência concluída\n" + "saldo da conta poupança: R$" + this.saldo);
            return true;
        } else {
            System.out.println("saldo insuficiente");
            return false;
        }

    }
}
