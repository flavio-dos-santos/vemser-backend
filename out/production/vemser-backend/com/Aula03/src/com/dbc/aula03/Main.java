package com.dbc.aula03;

public class Main {

    public static void main(String[] args) {
        Pessoa p1 = new Pessoa("joao","Marinho",50,"whats");






        System.out.println(p1.retornarNomeCompleto());
        p1.setNome("maria");
        System.out.println(p1.retornarNomeCompleto());
//        flavio.mandarWhatsApp(gustavo, "uashuahusahuash");
//        flavio.conversar(gustavo);
//        flavio.ehMaiorDeIdade();
    }
}
