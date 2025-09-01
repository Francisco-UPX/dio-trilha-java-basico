package behavioral.observer;

public class User implements AvailabilityObserver {
    private String name;

    public User(String name) {
        this.name = name;
    }

    @Override
    public void update(String bookTitle, boolean available) {
        if (available) {
            System.out.println("Notificação para " + name + ": O livro '" + bookTitle + "' está disponível para empréstimo!");
        } else {
            System.out.println("Notificação para " + name + ": O livro '" + bookTitle + "' foi emprestado.");
        }
    }
}