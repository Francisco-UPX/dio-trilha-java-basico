package behavioral.strategy;

import java.util.List;

public class BookSearch {
    private SearchStrategy strategy;

    public BookSearch(SearchStrategy strategy) {
        this.strategy = strategy;
    }

    public void setStrategy(SearchStrategy strategy) {
        this.strategy = strategy;
    }

    public boolean search(String term, List<String> books) {
        return strategy.contains(term, books);
    }
}