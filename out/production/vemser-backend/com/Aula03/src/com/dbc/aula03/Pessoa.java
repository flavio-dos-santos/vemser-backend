package com.dbc.aula03;

public class Pessoa {
    String nome;
    String sobrenome;
    int idade;
    String whatsapp;

    public void conversar(Pessoa pessoaConversa){
        System.out.println(this.nome + " conversou com " + pessoaConversa.nome );
    }

    public String retornarNomeCompleto(){
        return this.nome + " " + this.sobrenome;
    }
//     retornar boolean, verdadeiro ou falso
    public boolean ehMaiorDeIdade(){


        if(idade>=18){
            return true;
        }
        return false;
    }

    public void mandarWhatsApp(Pessoa pessoaAleatoria, String mensagemWhats){
        System.out.println(this.nome + " enviou: " + mensagemWhats + " para " + pessoaAleatoria.nome );
    }

}
