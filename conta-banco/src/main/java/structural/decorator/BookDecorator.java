package structural.decorator;

public abstract class BookDecorator implements BorrowableItem {
    protected BorrowableItem decoratedBook;

    public BookDecorator(BorrowableItem decoratedBook) {
        this.decoratedBook = decoratedBook;
    }

    @Override
    public void borrow() {
        decoratedBook.borrow();
    }

    @Override
    public void returnItem() {
        decoratedBook.returnItem();
    }

    @Override
    public String getDescription() {
        return decoratedBook.getDescription();
    }

    @Override
    public double getPrice() {
        return decoratedBook.getPrice();
    }
}