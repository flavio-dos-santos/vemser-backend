package com.dbc.aula03.exercicios3;

public class Endereco {
    public int tipo;
    public String logradouro;
    public int numero;
    public String complemento;
    public String cep;
    public String cidade;
    public String estado;
    public String pais;




    public void imprimirEndereco() {
        if (this.tipo == 1) {
            System.out.println("endereço residencial: " + logradouro + " " + numero + "\n complemento: " + complemento + "\n cep: " + cep + "\n cidade: " + cidade + "\n estado: " + estado + "\n pais:  " + pais);
        } else if(this.tipo == 2) {
            System.out.println("endereço comercial: " + logradouro + " " + numero + "\n complemento: " + complemento + "\n cep: " + cep + "\n cidade: " + cidade + "\n estado: " + estado + "\n pais: " + pais);
        }else{
            System.out.println("invalido!");
        }
    }
}
