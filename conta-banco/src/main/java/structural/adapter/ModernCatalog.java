package structural.adapter;

import java.util.List;

public interface ModernCatalog {
    List<String> getAllTitles();
    boolean isBookAvailable(String identifier);
}