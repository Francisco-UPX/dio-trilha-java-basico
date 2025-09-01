package creational.factorymethod;

public class Book implements LibraryItem {
    private String title;
    private String author;

    public Book(String title, String author) {
        this.title = title;
        this.author = author;
    }

    @Override
    public void borrow() {
        System.out.println("Livro emprestado: " + title + " por " + author);
    }

    @Override
    public void returnItem() {
        System.out.println("Livro devolvido: " + title + " por " + author);
    }

    @Override
    public String getDescription() {
        return "Livro: " + title + " - Autor: " + author;
    }
}