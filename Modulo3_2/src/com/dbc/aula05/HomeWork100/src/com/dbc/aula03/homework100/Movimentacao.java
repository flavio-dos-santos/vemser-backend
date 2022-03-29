package com.dbc.aula03.homework100;

public interface Movimentacao {

    public boolean sacar(double valor);
    public boolean depositar(double valor);
    public boolean transferir(Conta conta,double valor);
}
