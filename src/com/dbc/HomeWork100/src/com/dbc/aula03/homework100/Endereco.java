package com.dbc.aula03.homework100;

public class Endereco {
    public int tipo;
    public String logradouro;
    public int numero;
    public String complemento;
    public String cep;
    public String cidade;
    public String estado;
    public String pais;



        public void imprimirEndereco () {
            if (this.tipo == 1) {
                System.out.println("endereço residencial: " + this.logradouro + " " + this.numero + "\n complemento: " + this.complemento + "\n cep: " + this.cep + "\n cidade: " + this.cidade + "\n estado: " + this.estado + "\n pais:  " + this.pais);
            } else if (this.tipo == 2) {
                System.out.println("endereço comercial: " + this.logradouro + " " + this.numero + "\n complemento: " + this.complemento + "\n cep: " + this.cep + "\n cidade: " + this.cidade + "\n estado: " + this.estado + "\n pais: " + this.pais);
            } else {
                System.out.println("invalido!");
            }
        }
    }

