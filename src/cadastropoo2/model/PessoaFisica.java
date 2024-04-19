/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cadastropoo2.model;

import java.io.Serializable;

/**
 *
 * @author Walber
 */
public class PessoaFisica extends Pessoa implements Serializable{

    private String cpf;
    private int idade;

    public String getCpf() {
        return cpf;
    }

    public int getIdade() {
        return idade;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    @Override
    public void exibir() {
        super.exibir();
        System.out.println("cpf: " + this.cpf + "\n idade: " + this.idade);
    }

    public PessoaFisica(String cpf, int idade, String nome, int id) {
        super(nome, id);
        this.cpf = cpf;
        this.idade = idade;
    }
    
}
