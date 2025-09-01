package structural.decorator;

public class NewReleaseDecorator extends BookDecorator {
    public NewReleaseDecorator(BorrowableItem decoratedBook) {
        super(decoratedBook);
    }

    @Override
    public void borrow() {
        super.borrow();
        System.out.println("Este é um lançamento! Prazo de devolução: 7 dias.");
    }

    @Override
    public String getDescription() {
        return super.getDescription() + " (Lançamento)";
    }
}