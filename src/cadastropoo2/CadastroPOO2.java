/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package cadastropoo2;

import cadastropoo2.model.PessoaFisica;
import cadastropoo2.model.PessoaFisicaRepo;
import cadastropoo2.model.PessoaJuridica;
import cadastropoo2.model.PessoaJuridicaRepo;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Walber
 */
public class CadastroPOO2 {

    /**
     * @param args the command line arguments
     */
    static PessoaFisicaRepo repoPf = new PessoaFisicaRepo();
    static PessoaJuridicaRepo repoPJ = new PessoaJuridicaRepo();

    public static void main(String[] args) throws IOException, FileNotFoundException, ClassNotFoundException {
        menu();
    }

    public static void menu() throws IOException, FileNotFoundException, ClassNotFoundException {
        System.out.println("=================\n 1-Incluir Pessoa\n 2-Alterar Pessoa \n 3-Excluir Pessoa \n 4-Buscar pelo Id \n 5-Exibir Todos \n 6-Persistir Dados \n 7-Recuperar Dados \n 0-Finalizar Programa\n ==================");
        Scanner leitor = new Scanner(System.in);
        int opcaoDoUsuario = leitor.nextInt();
        if (opcaoDoUsuario >= 1 && opcaoDoUsuario <= 7) {

            System.out.println(" F-Pessoa Fisica \n J-Pessoa Juridica");
            String opcaoDoUsuario2 = leitor.next();
            if (opcaoDoUsuario == 1 && opcaoDoUsuario2.equals("F")) {
                incluirPessoaFisica();
                menu();
            } else if (opcaoDoUsuario == 1 && opcaoDoUsuario2.equals("J")) {
                incluirPessoaJuridica();
                menu();
            } else if (opcaoDoUsuario == 2 && opcaoDoUsuario2.equals("F")) {
                alterarPessoaFisica();
                menu();
            } else if (opcaoDoUsuario == 2 && opcaoDoUsuario2.equals("J")) {
                alterarPessoaJuridica();
                menu();
            } else if (opcaoDoUsuario == 3 && opcaoDoUsuario2.equals("F")) {
                excluirPessoaFisica();
                menu();
            } else if (opcaoDoUsuario == 3 && opcaoDoUsuario2.equals("J")) {
                excluirPessoaJuridica();
                menu();
            } else if (opcaoDoUsuario == 4 && opcaoDoUsuario2.equals("F")) {
                obterPeloIdPessoaFisica();
                menu();
            } else if (opcaoDoUsuario == 4 && opcaoDoUsuario2.equals("J")) {
                obterPeloIdPessoaJuridica();
                menu();
            } else if (opcaoDoUsuario == 5 && opcaoDoUsuario2.equals("F")) {
                obterTodosPessoaFisica();
                menu();
            } else if (opcaoDoUsuario == 5 && opcaoDoUsuario2.equals("J")) {
                obterTodosPessoaJuridica();
                menu();
            } else if (opcaoDoUsuario == 6 && opcaoDoUsuario2.equals("F")) {
                persistirDadosPessoaFisica();
                menu();
            } else if (opcaoDoUsuario == 6 && opcaoDoUsuario2.equals("J")) {
                persistirDadosPessoaJuridica();
                menu();
            } else if (opcaoDoUsuario == 7 && opcaoDoUsuario2.equals("F")) {
                recuperarDadosPessoaFisica();
                menu();
            } else if (opcaoDoUsuario == 7 && opcaoDoUsuario2.equals("J")) {
                recuperarDadosPessoaJuridica();
                menu();
            }
        } else if (opcaoDoUsuario == 0) {
            System.out.println("Finalizando o programa");
        }
    }

    public static void incluirPessoaFisica() {
        System.out.println("id:");
        Scanner leitor = new Scanner(System.in);
        int numeroId = leitor.nextInt();
        System.out.println("nome:");
        String nomeProprio = leitor.next();
        System.out.println("CPF:");
        String numeroUnico = leitor.next();
        System.out.println("Idade:");
        int numeroAnos = leitor.nextInt();
        PessoaFisica pessoa = new PessoaFisica(numeroUnico, numeroAnos, nomeProprio, numeroId);
        repoPf.inserir(pessoa);
        System.out.println("Pessoa Fisica incluida");
    }

    public static void incluirPessoaJuridica() {
        System.out.println("id:");
        Scanner leitor = new Scanner(System.in);
        int numeroId = leitor.nextInt();
        System.out.println("nome:");
        String nomeEmpresa = leitor.next();
        System.out.println("Cnpj:");
        String numeroUnico = leitor.next();
        PessoaJuridica pessoa = new PessoaJuridica(numeroUnico, nomeEmpresa, numeroId);
        repoPJ.inserir(pessoa);
        System.out.println("Pessoa Juridica incluida");
    }

    public static void alterarPessoaFisica() {
        System.out.println("id:");
        Scanner leitor = new Scanner(System.in);
        int numeroId = leitor.nextInt();
        PessoaFisica pessoa = repoPf.obter(numeroId);
        pessoa.exibir();
        System.out.println("insira os dados para alteração");
        System.out.println("nome:");
        String nomeProprio = leitor.next();
        System.out.println("CPF:");
        String numeroUnico = leitor.next();
        System.out.println("Idade:");
        int numeroAnos = leitor.nextInt();
        PessoaFisica pessoaAlterada = new PessoaFisica(numeroUnico, numeroAnos, nomeProprio, numeroId);
        repoPf.alterar(pessoaAlterada);
        System.out.println(" A pessoa foi alterada");

    }

    public static void alterarPessoaJuridica() {
        System.out.println("id:");
        Scanner leitor = new Scanner(System.in);
        int numeroId = leitor.nextInt();
        PessoaJuridica pessoa = repoPJ.obter(numeroId);
        pessoa.exibir();
        System.out.println("insira os dados para alteração");
        System.out.println("nome:");
        String nomeProprio = leitor.next();
        System.out.println("Cnpj:");
        String numeroUnico = leitor.next();
        PessoaJuridica pessoaAlterada = new PessoaJuridica(numeroUnico, nomeProprio, numeroId);
        repoPJ.alterar(pessoaAlterada);
        System.out.println(" A pessoa foi alterada");
    }

    public static void excluirPessoaFisica() {
        System.out.println("id:");
        Scanner leitor = new Scanner(System.in);
        int numeroId = leitor.nextInt();
        repoPf.excluir(numeroId);
        System.out.println(" A pessoa foi excluida");
    }

    public static void excluirPessoaJuridica() {
        System.out.println("id:");
        Scanner leitor = new Scanner(System.in);
        int numeroId = leitor.nextInt();
        repoPJ.excluir(numeroId);
        System.out.println(" A pessoa foi excluida");
    }

    public static void obterPeloIdPessoaFisica() {
        System.out.println("id:");
        Scanner leitor = new Scanner(System.in);
        int numeroId = leitor.nextInt();
        PessoaFisica pessoa = repoPf.obter(numeroId);
        pessoa.exibir();

    }

    public static void obterPeloIdPessoaJuridica() {
        System.out.println("id:");
        Scanner leitor = new Scanner(System.in);
        int numeroId = leitor.nextInt();
        PessoaJuridica pessoa = repoPJ.obter(numeroId);
        pessoa.exibir();
    }

    public static void obterTodosPessoaFisica() {
        ArrayList<PessoaFisica> pessoas = repoPf.obterTodos();
        for (int i = 0; i < pessoas.size(); i++) {
            pessoas.get(i).exibir();

        }

    }

    public static void obterTodosPessoaJuridica() {
        ArrayList<PessoaJuridica> pessoas = repoPJ.obterTodos();
        for (int i = 0; i < pessoas.size(); i++) {
            pessoas.get(i).exibir();
        }
    }

    public static void persistirDadosPessoaFisica() throws IOException {
        Scanner leitor = new Scanner(System.in);
        System.out.println("Qual é o prefixo do arquivo?");
        String prefixo = leitor.next();
        repoPf.persistir(prefixo + ".fisica.bin");
        System.out.println("Salvando os dados no arquivo");
    }

    public static void persistirDadosPessoaJuridica() throws IOException {
        Scanner leitor = new Scanner(System.in);
        System.out.println("Qual é o prefixo do arquivo?");
        String prefixo = leitor.next();
        repoPJ.persistir(prefixo + ".juridica.bin");
        System.out.println("Salvando os dados no arquivo");
    }

    public static void recuperarDadosPessoaFisica() throws IOException, FileNotFoundException, ClassNotFoundException {
        Scanner leitor = new Scanner(System.in);
        System.out.println("Qual é o prefixo do arquivo?");
        String prefixo = leitor.next();
        repoPf.recuperar(prefixo + ".fisica.bin");
        System.out.println("Recuperando os dados no arquivo");
    }

    public static void recuperarDadosPessoaJuridica() throws IOException, FileNotFoundException, ClassNotFoundException {
        Scanner leitor = new Scanner(System.in);
        System.out.println("Qual é o prefixo do arquivo?");
        String prefixo = leitor.next();
        repoPJ.recuperar(prefixo + ".juridica.bin");
        System.out.println("Recuperando os dados no arquivo");
    }

}
