package ex2;

import java.io.IOException;

public class main2 {
    public static void main(String[] args) throws IOException {

        Turma turma = new Turma();
        // Escreve p/ ficheiro e apaga do array
        System.out.println("Antes de escrever p/ ficheiro");
        turma.listaTodosAlunos();
        turma.escreverAluno(1);
        System.out.println("Depois de escrever p/ o ficheiro");
        turma.listaTodosAlunos();
        System.out.println("Le de um ficheiro");
        turma.lerAluno("Aluno2");
        turma.listaTodosAlunos();
    }
}