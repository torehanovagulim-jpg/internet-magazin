public class BasketProduct {
    private Item item;
    private int count;

    public BasketProduct(Item item, int count) {
        this.item = item;
        this.count = count;
    }

    public Item getItem() { return item; }

    public void increaseCount(int count) {
        this.count += count;
    }

    public int calculatePrice() {
        return item.getPrice() * count;
    }

    public String toString() {
        return item.getTitle() + " | Саны: " + count + " | Құны: " + calculatePrice() + " тг";
    }
}
