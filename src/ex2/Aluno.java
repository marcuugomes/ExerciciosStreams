package ex2;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.Serializable;

/**
 *
 * @author Fábio Marques e Hélder Gomes
 */
public class Aluno  implements Serializable {
    private int nMec;
    private String nome;

    public Aluno(int nMec, String nome){

        this.nMec = nMec;
        this.nome = nome;

    }

    public int getNMec() {
        return nMec;
    }

    public void setNMec(int nMec) {
        this.nMec = nMec;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String toString(){
        return( "NMec: " + nMec + "\tNome: " + nome );
    }
}

