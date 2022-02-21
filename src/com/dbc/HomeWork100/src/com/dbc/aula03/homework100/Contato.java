package com.dbc.aula03.homework100;

public class Contato {

    public String descricao = "";
    public String telefone = "";
    public int tipo;



    public void imprimiContato() {
        if (this.tipo == 1) {
            System.out.println("telefone residencial: " + this.telefone);
        } else if (this.tipo == 2) {
            System.out.println("telefone comercial: " + this.telefone);
        } else {
            System.out.println("invalido!");
        }
    }
}
