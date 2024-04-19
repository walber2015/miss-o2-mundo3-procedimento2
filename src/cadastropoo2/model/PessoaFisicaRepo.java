package cadastropoo2.model;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author Walber
 */
public class PessoaFisicaRepo {

    private ArrayList<PessoaFisica> pessoas;

    public PessoaFisicaRepo() {

        pessoas = new ArrayList();
    }

    public void inserir(PessoaFisica pessoa) {
        pessoas.add(pessoa);

    }

    public void alterar(PessoaFisica pessoa) {
        for (int i = 0; i < pessoas.size(); i++) {
            if (pessoas.get(i).getId() == pessoa.getId()) {
                pessoas.set(i, pessoa);
            }
        }

    }

    public void excluir(int id) {
        for (int i = 0; i < pessoas.size(); i++) {
            if (pessoas.get(i).getId() == id) {
                pessoas.remove(i);
            }
        }
    }

    public PessoaFisica obter(int id) {
        for (int i = 0; i < pessoas.size(); i++) {
            if (pessoas.get(i).getId() == id) {
                return pessoas.get(i);
            }

        }
        return null;
    }

    public ArrayList<PessoaFisica> obterTodos() {
        return pessoas;
    }

    public void persistir(String nomeArquivo) throws FileNotFoundException, IOException {
        FileOutputStream arquivo = new FileOutputStream(nomeArquivo);
        try (ObjectOutputStream out = new ObjectOutputStream(arquivo)) {
            out.writeObject(pessoas);

        }
    }

    public void recuperar(String nomeArquivo) throws FileNotFoundException, IOException, ClassNotFoundException {
        FileInputStream arquivo = new FileInputStream(nomeArquivo);
        try (ObjectInputStream in = new ObjectInputStream(arquivo)) {

            pessoas = (ArrayList<PessoaFisica>) in.readObject();
        }
    }
}
