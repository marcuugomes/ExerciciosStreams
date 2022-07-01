package ex1;

import java.io.FileWriter;
import java.io.IOException;

/**
 * Representa um livro numa biblioteca.
 * Tem autor, título, referência, número de páginas e número de empréstimos.
 */
public class Livro {
    private String autor;
    private String titulo;
    private int paginas;
    private String referencia;
    private int numEmprestimos;

    /**
     * Constrói um livro com autor, título e número de páginas. A referência é iniciada como string vazia e o número de emprésticos é colocado a zero.
     * @param autor o autor do livro
     * @param titulo o título do livro
     * @param paginas o número de páginas do livro
     */
    public Livro(String autor, String titulo, int paginas) {
        this.autor = autor;
        this.titulo = titulo;
        this.paginas = paginas;
        this.referencia = "";
        this.numEmprestimos = 0;
    }

    public String getAutor() {
        return autor;
    }
    public String getTitulo() {
        return titulo;
    }
    public int getPaginas() {
        return paginas;
    }
    public String getReferencia() {
        return referencia;
    }
    public int getNumEmprestimos() {
        return numEmprestimos;
    }
    public void setAutor(String autor) {
        this.autor = autor;
    }
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    /**
     * Atribui a <code>referencia</code> ao livro. O tamanho da referência tem de ser pelo menos 3.
     * @param referencia a referência a atribuir ao livro
     */
    public void setReferencia(String referencia) {
        if (referencia.length() >= 3)
            this.referencia = referencia;
        else
            System.out.println("ERRO: referência inválida!");
    }

    public void printAutor() {
        System.out.println("Autor: "+autor);
    }
    public void printTitulo() {
        System.out.println("Título: "+titulo);
    }

    /**
     * Imprime na consola os detalhes sobre o livro.
     * No caso de a referência não ter sido definida, imprime "ZZZ" como referência.
     */
    public void imprimeDetalhes() {
        String ref = "ZZZ";
        if (!referencia.equals(""))
            ref = referencia;
        System.out.println("Título: "+titulo+", Autor: "+autor+", Páginas: "
                +paginas+", Referência: "+ref);
    }

    public void novoEmprestimo() {
        numEmprestimos++;
    }

    public void toFile (String ficheiro) {
        try(FileWriter writer = new FileWriter(ficheiro)){

            writer.write(this.referencia);
            writer.write(",");
            writer.write(this.titulo);
            writer.write(",");
            writer.write(this.autor);
            writer.write(",");
            writer.write(String.valueOf(this.paginas));
            writer.write(",");
            writer.write(String.valueOf(this.numEmprestimos));

        }catch(IOException e){
            e.getStackTrace();
        }
    }
}
