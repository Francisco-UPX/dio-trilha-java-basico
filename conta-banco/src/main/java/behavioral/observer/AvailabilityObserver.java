package behavioral.observer;

public interface AvailabilityObserver {
    void update(String bookTitle, boolean available);
}