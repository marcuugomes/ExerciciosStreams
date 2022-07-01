package ex2;

import java.io.IOException;
import java.util.Scanner;

public class main2 {
    public static void main(String[] args) throws IOException {

        Turma turma = new Turma();

        /*
        System.out.println("Antes de escrever p/ ficheiro");
        turma.listaTodosAlunos();
        // Escreve p/ ficheiro
        turma.escreverAlunoFicheiro(1);
        System.out.println("Depois de escrever p/ o ficheiro");
        turma.listaTodosAlunos();

        // Lê de um ficheiro
        System.out.println("Le de um ficheiro");
        turma.lerAlunoFicheiro("Aluno2");
        turma.listaTodosAlunos();
        */

        // Pedir ao utilizador os valores

        /*
        System.out.println("Introduza o número mecanográfico: ");
         /*
        Scanner leitor = new Scanner(System.in);
        int nMec = leitor.nextInt();
        System.out.println("Introduza o nome do aluno: ");
        String nome = leitor.next();
        turma.inscreveAluno(nMec,nome);
        turma.listaTodosAlunos();
        */

        turma.backupTurma();



    }
}