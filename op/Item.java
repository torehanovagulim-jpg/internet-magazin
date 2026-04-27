public class Item {
    private int code;
    private String title;
    private String type;
    private int price;

    public Item(int code, String title, String type, int price) {
        this.code = code;
        this.title = title;
        this.type = type;
        this.price = price;
    }

    public int getCode() { return code; }
    public String getTitle() { return title; }
    public String getType() { return type; }
    public int getPrice() { return price; }

    public String toString() {
        return code + ") " + title + " | Санат: " + type + " | Бағасы: " + price + " тг";
    }
}
