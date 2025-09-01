package behavioral.observer;

import java.util.ArrayList;
import java.util.List;

public class AvailabilityNotifier {
    private List<AvailabilityObserver> observers = new ArrayList<>();
    private String bookTitle;
    private boolean available;

    public AvailabilityNotifier(String bookTitle) {
        this.bookTitle = bookTitle;
        this.available = true;
    }

    public void setAvailability(boolean available) {
        this.available = available;
        notifyObservers();
    }

    public void addObserver(AvailabilityObserver observer) {
        observers.add(observer);
    }

    public void removeObserver(AvailabilityObserver observer) {
        observers.remove(observer);
    }

    private void notifyObservers() {
        for (AvailabilityObserver observer : observers) {
            observer.update(bookTitle, available);
        }
    }
}