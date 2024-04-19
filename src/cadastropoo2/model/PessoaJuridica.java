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
public class PessoaJuridica extends Pessoa implements Serializable{

    private String cnpj;

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    @Override
    public void exibir() {
        super.exibir(); 
        System.out.println("cnpj: "+this.cnpj);
    }

    public PessoaJuridica(String cnpj, String nome, int id) {
        super(nome, id);
        this.cnpj = cnpj;
    }
    
   
}
