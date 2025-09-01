package structural.adapter;

public class LegacyCatalogSystem {
    public String[] getBookTitles() {
        return new String[] {
                "Patterns of Enterprise Application Architecture",
                "Refactoring: Improving the Design of Existing Code",
                "Domain-Driven Design: Tackling Complexity in the Heart of Software"
        };
    }

    public boolean checkBookAvailability(String isbn) {
        return isbn.length() > 5;
    }
}