package com.dbc.aula03.homework100;

public class ContaCorrente extends Conta implements Impressao{
    private double chequeEspecial;


    public ContaCorrente(Cliente cliente, String numeroConta, String agencia, double saldo,double chequeEspecial) {
        super(cliente, numeroConta, agencia, saldo);
        this.chequeEspecial = chequeEspecial;

    }


    public double retornarSaldoComChequeEspecial(){
        System.out.println("o seu saldo total é de: R$"+ (getSaldo() + this.chequeEspecial));
        return getSaldo() + chequeEspecial;
    }

    public void setChequeEspecial(double valor){
        valor = 300;
    }

    @Override
    public void imprimir() {
        System.out.println(getCliente() + "\nnumero da conta corrente: " + getNumeroConta() + "\nagencia: " + getAgencia() + "\nsaldo: " + getSaldo() + "\ncheque especial: " + chequeEspecial);
    }
}
