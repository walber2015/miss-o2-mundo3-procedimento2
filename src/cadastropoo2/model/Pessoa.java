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
public class Pessoa implements Serializable{
private String nome;
private  int   id;
public  Pessoa(String nome,int id){//Isto é um método construtor com parametros
this.nome=nome;
this.id=id;
}public Pessoa(){
    
}public String getNome(){
    return nome;
}public int getId(){
    return id;
}public void setNome(String nome){
    this.nome=nome;
}public void setId(int id){
    this.id=id;
}public void exibir(){
            System.out.println("Id: "+this.id+"\n Nome: "+this.nome);
}
}

