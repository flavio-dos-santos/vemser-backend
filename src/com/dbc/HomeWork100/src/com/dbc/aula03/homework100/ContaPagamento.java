package com.dbc.aula03.homework100;

public class ContaPagamento extends Conta implements Impressao{

    private final double TAXA_SAQUE = 4.25;


    public ContaPagamento(Cliente cliente, String numeroConta, String agencia, double saldo) {
        super(cliente, numeroConta, agencia, saldo);

    }

    @Override
    public boolean sacar( double valor) {
        double valorMaisTaxa = valor + TAXA_SAQUE;
        if (valor > 0 && valorMaisTaxa < getSaldo()) {
            setSaldo(getSaldo() - valorMaisTaxa);
            System.out.println(" você sacou : R$" + valor + " seu saldo atual é de: R$" + getSaldo());
            return true;
        } else{
            System.out.println(" Sua conta não pode ficar negativa!");
            return false;
        }

    }

    @Override
    public void imprimir() {
        System.out.println(getCliente() + "\nnumero da conta corrente: " + getNumeroConta() + "\nagencia: " + getAgencia() + "\nsaldo: " + getSaldo());
    }
}
