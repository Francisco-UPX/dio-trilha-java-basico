package behavioral.strategy;

import java.util.List;

public interface SearchStrategy {
    boolean contains(String bookTitle, List<String> bookList);
}