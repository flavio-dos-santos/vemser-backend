package com.dbc.aula03;

public class Main {

    public static void main(String[] args) {
        Pessoa flavio = new Pessoa();
        flavio.idade = 30;
        flavio.nome = "flavio";
        flavio.sobrenome = "sobrinho";
        flavio.whatsapp = "whats";

        Pessoa gustavo = new Pessoa();
        gustavo.idade = 26;
        gustavo.nome = "gustavo";
        gustavo.sobrenome = "barbosa";
        gustavo.whatsapp = "whats";


        System.out.println(flavio.retornarNomeCompleto());
        flavio.mandarWhatsApp(gustavo, "uashuahusahuash");
        flavio.conversar(gustavo);
        flavio.ehMaiorDeIdade();
    }
}
