package creational.factorymethod;

public class LibraryItemFactory {
    public static LibraryItem createItem(String type, String title, String additionalInfo) {
        if ("book".equalsIgnoreCase(type)) {
            return new Book(title, additionalInfo);
        } else if ("magazine".equalsIgnoreCase(type)) {
            return new Magazine(title, additionalInfo);
        }
        throw new IllegalArgumentException("Tipo de item desconhecido: " + type);
    }
}