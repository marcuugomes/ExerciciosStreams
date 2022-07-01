package ex2;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Fábio Marques e Hélder Gomes
 */
public class Turma implements Serializable{
    private ArrayList<Aluno> alunos;

    public Turma()  {
        alunos = new ArrayList<Aluno>();
        Aluno a = new Aluno( 1001, "Aluno1");
        alunos.add(a);
        a = new Aluno( 1002, "Aluno2");
        alunos.add(a);
        a = new Aluno( 1003, "Aluno3");
        alunos.add(a);
    }

    public void inscreveAluno (int nMec, String nome) {

        Aluno a = new Aluno(nMec, nome);
        alunos.add(a);

    }

    public void removeAluno (int index) {
        alunos.remove(index);
    }

    public Aluno getAlunoPeloIndice(int index) {
        return alunos.get(index);
    }

    public void listaTodosAlunos(){
        System.out.println("Listagem de todos os alunos da turma:");

        for( int i = 0; i<alunos.size(); i++ ){
            System.out.println( "Índice: " + i + "\t" + alunos.get(i).toString() );
        }
    }

    public void escreverAlunoFicheiro (int index){

        Aluno aux=this.alunos.get(index);

        try(FileWriter writer = new FileWriter("src/ex2/"+aux.getNome()+".txt")){

            writer.write(String.valueOf(aux.getNMec()));
            writer.write(",");
            writer.write(aux.getNome());

        }catch (IOException e){
            e.getStackTrace();
        }
        System.out.println("Sucesso!");
        this.alunos.remove(index);
    }

    public void lerAlunoFicheiro (String nome) {

        Charset charset = Charset.forName("US-ASCII");
        Path path = Paths.get("src/ex2/"+nome+".txt");

        try(BufferedReader reader = Files.newBufferedReader(path,charset)){
            String aux = reader.readLine();
            String[] split = aux.split(",", 2);
            alunos.add(new Aluno(Integer.parseInt(split[0]),split[1]));

        }catch (FileNotFoundException e){
            e.getStackTrace();

        }catch (IOException e){
            e.getStackTrace();
        }


    }

    public void backupTurma (){

        try(FileWriter writer = new FileWriter("src/ex2/turmaBackup.txt")){

            for (Aluno a:alunos){
                writer.write(String.valueOf(a.getNMec()));
                writer.write("\n");
                writer.write(a.getNome());
                writer.write("\n");
            }

        }catch ( IOException e){
            e.getStackTrace();
        }

        System.out.println("BackUp terminado com sucesso!");
    }

    public void resetTurma (){
        this.alunos=new ArrayList<>();
    }

    public void lerTurmaFicheiro (String ficheiro){

        try (Scanner in = new Scanner(new FileReader("src/ex2/"+ficheiro+".txt"))){

            while(in.hasNextLine()){
                this.alunos.add(new Aluno(Integer.parseInt(in.nextLine()),in.nextLine()));
            }

        }catch (FileNotFoundException e) {
            e.getStackTrace();
        }
    }


    public void serializarTurma ()  {

        File dest = new File("Turma.txt");

        try {
            ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream(dest));
            os.writeObject(this.alunos);
            os.close();
        }catch (FileNotFoundException e){
            e.getStackTrace();
        } catch (IOException e) {
            e.getStackTrace();
        }
        System.out.println("Turma serializada com sucesso");
    }

    public void lerTurma () throws IOException, ClassNotFoundException {

        ObjectInputStream in = new ObjectInputStream(new FileInputStream("Turma.txt"));
        this.alunos = (ArrayList<Aluno>) in.readObject();


    }
}

