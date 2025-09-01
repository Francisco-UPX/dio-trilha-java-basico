package structural.decorator;

public class RareBookDecorator extends BookDecorator {
    public RareBookDecorator(BorrowableItem decoratedBook) {
        super(decoratedBook);
    }

    @Override
    public void borrow() {
        super.borrow();
        System.out.println("Atenção: Este é um livro raro! Cuidado especial necessário.");
    }

    @Override
    public String getDescription() {
        return super.getDescription() + " (Livro Raro)";
    }

    @Override
    public double getPrice() {
        return super.getPrice() * 2;
    }
}