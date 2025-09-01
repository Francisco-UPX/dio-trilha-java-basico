package creational.singleton;

import java.util.ArrayList;
import java.util.List;

public class CatalogManager {
    private static CatalogManager instance;
    private List<String> books;

    private CatalogManager() {
        books = new ArrayList<>();
        books.add("Design Patterns: Elements of Reusable Object-Oriented Software");
        books.add("Clean Code: A Handbook of Agile Software Craftsmanship");
        books.add("The Pragmatic Programmer: Your Journey to Mastery");
    }

    public static synchronized CatalogManager getInstance() {
        if (instance == null) {
            instance = new CatalogManager();
        }
        return instance;
    }

    public void addBook(String bookTitle) {
        books.add(bookTitle);
        System.out.println("Livro adicionado: " + bookTitle);
    }

    public void listBooks() {
        System.out.println("Catálogo de Livros:");
        for (int i = 0; i < books.size(); i++) {
            System.out.println((i + 1) + ". " + books.get(i));
        }
    }

    public List<String> getBooks() {
        return new ArrayList<>(books);
    }

    public boolean checkAvailability(String bookTitle) {
        return books.contains(bookTitle);
    }
}