package structural.decorator;

public class BasicBook implements BorrowableItem {
    private String title;
    private String author;
    private double price;

    public BasicBook(String title, String author, double price) {
        this.title = title;
        this.author = author;
        this.price = price;
    }

    @Override
    public void borrow() {
        System.out.println("Emprestando: " + title);
    }

    @Override
    public void returnItem() {
        System.out.println("Devolvendo: " + title);
    }

    @Override
    public String getDescription() {
        return "Livro: " + title + " por " + author;
    }

    @Override
    public double getPrice() {
        return price;
    }
}