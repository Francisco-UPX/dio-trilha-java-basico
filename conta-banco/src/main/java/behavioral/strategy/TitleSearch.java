package behavioral.strategy;

import java.util.List;

public class TitleSearch implements SearchStrategy {
    @Override
    public boolean contains(String bookTitle, List<String> bookList) {
        for (String title : bookList) {
            if (title.equalsIgnoreCase(bookTitle)) {
                return true;
            }
        }
        return false;
    }
}