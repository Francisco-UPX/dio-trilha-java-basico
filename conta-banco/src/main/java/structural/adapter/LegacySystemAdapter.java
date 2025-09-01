package structural.adapter;

import java.util.Arrays;
import java.util.List;

public class LegacySystemAdapter implements ModernCatalog {
    private LegacyCatalogSystem legacySystem;

    public LegacySystemAdapter(LegacyCatalogSystem legacySystem) {
        this.legacySystem = legacySystem;
    }

    @Override
    public List<String> getAllTitles() {
        return Arrays.asList(legacySystem.getBookTitles());
    }

    @Override
    public boolean isBookAvailable(String identifier) {
        if (identifier.matches("\\d+")) {
            return legacySystem.checkBookAvailability(identifier);
        } else {
            String[] titles = legacySystem.getBookTitles();
            for (String title : titles) {
                if (title.equalsIgnoreCase(identifier)) {
                    return true;
                }
            }
            return false;
        }
    }
}