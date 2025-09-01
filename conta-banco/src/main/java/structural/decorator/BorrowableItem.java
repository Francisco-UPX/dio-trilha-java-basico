package structural.decorator;

public interface BorrowableItem {
    void borrow();
    void returnItem();
    String getDescription();
    double getPrice();
}