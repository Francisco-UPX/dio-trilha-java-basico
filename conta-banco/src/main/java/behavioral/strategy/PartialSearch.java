package behavioral.strategy;

import java.util.List;

public class PartialSearch implements SearchStrategy {
    @Override
    public boolean contains(String searchTerm, List<String> bookList) {
        for (String title : bookList) {
            if (title.toLowerCase().contains(searchTerm.toLowerCase())) {
                return true;
            }
        }
        return false;
    }
}