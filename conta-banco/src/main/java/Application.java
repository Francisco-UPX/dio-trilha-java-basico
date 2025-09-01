import creational.singleton.CatalogManager;
import creational.factorymethod.LibraryItem;
import creational.factorymethod.LibraryItemFactory;
import behavioral.observer.User;
import behavioral.observer.AvailabilityNotifier;
import behavioral.strategy.BookSearch;
import behavioral.strategy.TitleSearch;
import behavioral.strategy.PartialSearch;
import structural.adapter.LegacyCatalogSystem;
import structural.adapter.LegacySystemAdapter;
import structural.adapter.ModernCatalog;
import structural.decorator.BasicBook;
import structural.decorator.BorrowableItem;
import structural.decorator.NewReleaseDecorator;
import structural.decorator.RareBookDecorator;

import java.util.List;
import java.util.Arrays;

public class Application {
    public static void main(String[] args) {
        System.out.println("=== SISTEMA DE GERENCIAMENTO DE BIBLIOTECA ===\n");

        // Demonstração do Singleton
        System.out.println("1. Demonstração do Padrão Singleton:");
        CatalogManager catalog = CatalogManager.getInstance();
        catalog.listBooks();
        catalog.addBook("Java: Como Programar");
        System.out.println();

        // Demonstração do Factory Method
        System.out.println("2. Demonstração do Padrão Factory Method:");
        LibraryItem book = LibraryItemFactory.createItem("book", "Clean Code", "Robert C. Martin");
        LibraryItem magazine = LibraryItemFactory.createItem("magazine", "MIT Technology Review", "Março 2023");

        book.borrow();
        magazine.borrow();
        System.out.println();

        // Demonstração do Observer
        System.out.println("3. Demonstração do Padrão Observer:");
        AvailabilityNotifier notifier = new AvailabilityNotifier("Design Patterns");
        User user1 = new User("João Silva");
        User user2 = new User("Maria Santos");

        notifier.addObserver(user1);
        notifier.addObserver(user2);

        notifier.setAvailability(false);
        notifier.setAvailability(true);
        System.out.println();

        // Demonstração do Strategy
        System.out.println("4. Demonstração do Padrão Strategy:");
        BookSearch search = new BookSearch(new TitleSearch());
        List<String> books = Arrays.asList(
                "Design Patterns: Elements of Reusable Object-Oriented Software",
                "Clean Code: A Handbook of Agile Software Craftsmanship",
                "The Pragmatic Programmer: Your Journey to Mastery",
                "Java: Como Programar"
        );

        System.out.println("Busca exata por 'Clean Code': " +
                search.search("Clean Code", books));

        search.setStrategy(new PartialSearch());
        System.out.println("Busca parcial por 'Patterns': " +
                search.search("Patterns", books));
        System.out.println();

        // Demonstração do Adapter
        System.out.println("5. Demonstração do Padrão Adapter:");
        LegacyCatalogSystem legacySystem = new LegacyCatalogSystem();
        ModernCatalog modernCatalog = new LegacySystemAdapter(legacySystem);

        System.out.println("Títulos do catálogo legado:");
        modernCatalog.getAllTitles().forEach(System.out::println);

        System.out.println("Disponibilidade do livro por título: " +
                modernCatalog.isBookAvailable("Refactoring: Improving the Design of Existing Code"));
        System.out.println("Disponibilidade do livro por ISBN: " +
                modernCatalog.isBookAvailable("123456"));
        System.out.println();

        // Demonstração do Decorator
        System.out.println("6. Demonstração do Padrão Decorator:");
        BorrowableItem basicBook = new BasicBook("Domain-Driven Design", "Eric Evans", 10.0);
        System.out.println("Livro básico: " + basicBook.getDescription());
        System.out.println("Preço: R$" + basicBook.getPrice());
        basicBook.borrow();
        System.out.println();

        BorrowableItem rareBook = new RareBookDecorator(basicBook);
        System.out.println("Livro raro: " + rareBook.getDescription());
        System.out.println("Preço: R$" + rareBook.getPrice());
        rareBook.borrow();
        System.out.println();

        BorrowableItem newRelease = new NewReleaseDecorator(
                new BasicBook("Java 17 Essentials", "James Gosling", 15.0));
        System.out.println("Novo lançamento: " + newRelease.getDescription());
        newRelease.borrow();

        System.out.println("\n=== DEMONSTRAÇÃO CONCLUÍDA ===");
    }
}