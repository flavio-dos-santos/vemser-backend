package com.dbc.aula03.exercicios3;

public class Contato {
    public String descricao;
    public String telefone;
    public int tipo;



        public void imprimiContato() {
            if (this.tipo == 1) {
                System.out.println("telefone residencial: " + telefone);
            } else if (this.tipo == 2) {
                System.out.println("telefone comercial: " + telefone);
            } else {
                System.out.println("invalido!");
            }
        }
}


