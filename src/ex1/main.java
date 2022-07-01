package ex1;

public class main {
    public static void main(String[] args) {

        Livro livro = new Livro("Marco", "chicolina", 123);
        livro.setReferencia("123456789");
        livro.toFile("livro.txt");
    }
}
