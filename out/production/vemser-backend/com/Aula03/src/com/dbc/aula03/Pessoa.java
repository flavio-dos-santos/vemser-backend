package com.dbc.aula03;

public class Pessoa {
    String nome;
    String sobrenome;
    int idade;
    String whatsapp;

    public Pessoa(){

 }

 public Pessoa(String nome, String sobrenome, int idade, String whatsapp){
    this.nome = nome;
    this.sobrenome = sobrenome;
    this.idade = idade;
    this.whatsapp = whatsapp;
 }

    public void setNome(String nome){
        this.nome = nome ;

    }
    public String getNome(){
        return nome;
    }
    public void setSobrenome(String sobrenome){
        this.sobrenome = sobrenome;

    }
    public String getSobrenome(){
        return sobrenome;
    }
    public void setIdade(int idade){
        this.idade = idade;
    }
    public int getIdade(){
        return idade;
    }
    public void setWhatsapp(String whatsapp){
        this.whatsapp = whatsapp;
    }
    public String getWhatsapp(){
        return whatsapp;
    }







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
