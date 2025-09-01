package creational.factorymethod;

public class Magazine implements LibraryItem {
    private String title;
    private String issue;

    public Magazine(String title, String issue) {
        this.title = title;
        this.issue = issue;
    }

    @Override
    public void borrow() {
        System.out.println("Revista emprestada: " + title + " - Edição: " + issue);
    }

    @Override
    public void returnItem() {
        System.out.println("Revista devolvida: " + title + " - Edição: " + issue);
    }

    @Override
    public String getDescription() {
        return "Revista: " + title + " - Edição: " + issue;
    }
}