import java.time.LocalDateTime;
import java.util.ArrayList;

public class Purchase {
    private Buyer buyer;
    private ArrayList<BasketProduct> products;
    private LocalDateTime date;

    public Purchase(Buyer buyer, ArrayList<BasketProduct> products) {
        this.buyer = buyer;
        this.products = new ArrayList<>(products);
        this.date = LocalDateTime.now();
    }

    public int getFinalSum() {
        int sum = 0;
        for (BasketProduct product : products) {
            sum += product.calculatePrice();
        }
        return sum;
    }

    public void printCheck() {
        System.out.println("\n========= ТАПСЫРЫС АҚПАРАТЫ =========");
        System.out.println("Сатып алушы: " + buyer.getName());
        System.out.println("Телефон: " + buyer.getPhone());
        System.out.println("Қала: " + buyer.getCity());
        System.out.println("Мекенжай: " + buyer.getAddress());
        System.out.println("Күні: " + date);
        System.out.println("------------------------------------");

        for (BasketProduct product : products) {
            System.out.println(product);
        }

        System.out.println("------------------------------------");
        System.out.println("Төленетін жалпы сома: " + getFinalSum() + " тг");
        System.out.println("Тапсырыс сәтті рәсімделді!");
        System.out.println("====================================\n");
    }
}
