/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cadastropoo2.model;

import java.util.ArrayList;
import cadastropoo2.model.PessoaJuridica;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 *
 * @author Walber
 */
public class PessoaJuridicaRepo {

    private ArrayList<PessoaJuridica> empresas;
    
    public PessoaJuridicaRepo() {

        empresas = new ArrayList();
    }

    public void inserir(PessoaJuridica empresa) {
        empresas.add(empresa);

    }

    public void alterar(PessoaJuridica empresa) {
        for (int i = 0; i < empresas.size(); i++) {
            if (empresas.get(i).getId() == empresa.getId()) {
                empresas.set(i, empresa);
            }
        }

    }

    public void excluir(int id) {
        for (int i = 0; i < empresas.size(); i++) {
            if (empresas.get(i).getId() == id) {
                empresas.remove(i);
            }
        }
    }

    public PessoaJuridica obter(int id) {
        for (int i = 0; i < empresas.size(); i++) {
            if (empresas.get(i).getId() == id) {
                return empresas.get(i);
            }

        }
        return null;
    }

    public ArrayList<PessoaJuridica> obterTodos() {
        return empresas;
    }
    public void persistir(String nomeArquivo) throws FileNotFoundException, IOException{
        FileOutputStream arquivo = new FileOutputStream(nomeArquivo);
        try(ObjectOutputStream out=new ObjectOutputStream(arquivo)) {
            out.writeObject(empresas);
            
        }
    }
    public void recuperar(String nomeArquivo) throws FileNotFoundException, IOException, ClassNotFoundException{
        FileInputStream arquivo = new FileInputStream(nomeArquivo);
        try(ObjectInputStream in=new ObjectInputStream(arquivo)){
            
        empresas=(ArrayList<PessoaJuridica>) in.readObject();
        }
    }
}
