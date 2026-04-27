import java.util.ArrayList;
import java.util.Scanner;

public class InternetDuken {
    static Scanner scanner = new Scanner(System.in);
    static ArrayList<Item> items = new ArrayList<>();
    static ArrayList<BasketProduct> basket = new ArrayList<>();

    public static void main(String[] args) {
        loadItems();

        while (true) {
            printMenu();
            int choice = readNumber("Мәзірден таңдаңыз: ");

            if (choice == 1) {
                showItems();
            } else if (choice == 2) {
                addProductToBasket();
            } else if (choice == 3) {
                showBasket();
            } else if (choice == 4) {
                deleteFromBasket();
            } else if (choice == 5) {
                makePurchase();
            } else if (choice == 6) {
                basket.clear();
                System.out.println("Себет толық тазаланды.");
            } else if (choice == 0) {
                System.out.println("Интернет дүкен жабылды. Сау болыңыз!");
                break;
            } else {
                System.out.println("Қате таңдау! Қайта енгізіңіз.");
            }
        }
    }

    static void loadItems() {
        items.add(new Item(101, "Ерлерге арналған футболка", "Киім", 6500));
        items.add(new Item(102, "Әйелдерге арналған сөмке", "Аксессуар", 12000));
        items.add(new Item(103, "Кроссовка", "Аяқ киім", 28000));
        items.add(new Item(104, "Қысқы күртеше", "Киім", 45000));
        items.add(new Item(105, "Спорттық костюм", "Киім", 22000));
        items.add(new Item(106, "Сағат", "Аксессуар", 15000));
        items.add(new Item(107, "Рюкзак", "Сөмке", 9000));
        items.add(new Item(108, "Классикалық шалбар", "Киім", 14000));
        items.add(new Item(109, "Кепка", "Аксессуар", 4000));
        items.add(new Item(110, "Көйлек", "Киім", 18000));
    }

    static void printMenu() {
        System.out.println("\n========== ИНТЕРНЕТ ДҮКЕН ==========");
        System.out.println("1. Барлық тауарларды көру");
        System.out.println("2. Тауарды себетке қосу");
        System.out.println("3. Себетті көру");
        System.out.println("4. Себеттен тауар алып тастау");
        System.out.println("5. Тапсырыс рәсімдеу");
        System.out.println("6. Себетті тазалау");
        System.out.println("0. Шығу");
        System.out.println("===================================");
    }

    static void showItems() {
        System.out.println("\n========== ТАУАРЛАР ТІЗІМІ ==========");
        for (Item item : items) {
            System.out.println(item);
        }
    }

    static void addProductToBasket() {
        showItems();

        int code = readNumber("Тауар кодын енгізіңіз: ");
        Item selectedItem = findItem(code);

        if (selectedItem == null) {
            System.out.println("Мұндай кодтағы тауар табылмады.");
            return;
        }

        int count = readNumber("Тауар санын енгізіңіз: ");

        if (count <= 0) {
            System.out.println("Тауар саны 0-ден үлкен болуы керек.");
            return;
        }

        for (BasketProduct product : basket) {
            if (product.getItem().getCode() == code) {
                product.increaseCount(count);
                System.out.println("Себеттегі тауар саны жаңартылды.");
                return;
            }
        }

        basket.add(new BasketProduct(selectedItem, count));
        System.out.println("Тауар себетке қосылды.");
    }

    static void showBasket() {
        if (basket.isEmpty()) {
            System.out.println("\nСебет бос.");
            return;
        }

        System.out.println("\n========== СЕБЕТ ==========");
        int total = 0;

        for (int i = 0; i < basket.size(); i++) {
            System.out.println((i + 1) + ". " + basket.get(i));
            total += basket.get(i).calculatePrice();
        }

        System.out.println("--------------------------");
        System.out.println("Жалпы құны: " + total + " тг");
    }

    static void deleteFromBasket() {
        showBasket();

        if (basket.isEmpty()) {
            return;
        }

        int number = readNumber("Өшірілетін тауар нөмірін енгізіңіз: ");

        if (number < 1 || number > basket.size()) {
            System.out.println("Қате нөмір енгізілді.");
            return;
        }

        basket.remove(number - 1);
        System.out.println("Тауар себеттен өшірілді.");
    }

    static void makePurchase() {
        if (basket.isEmpty()) {
            System.out.println("Алдымен себетке тауар қосыңыз.");
            return;
        }

        scanner.nextLine();

        System.out.print("Аты-жөніңізді енгізіңіз: ");
        String name = scanner.nextLine();

        System.out.print("Телефон нөміріңізді енгізіңіз: ");
        String phone = scanner.nextLine();

        System.out.print("Қалаңызды енгізіңіз: ");
        String city = scanner.nextLine();

        System.out.print("Мекенжайыңызды енгізіңіз: ");
        String address = scanner.nextLine();

        Buyer buyer = new Buyer(name, phone, city, address);
        Purchase purchase = new Purchase(buyer, basket);
        purchase.printCheck();

        basket.clear();
    }

    static Item findItem(int code) {
        for (Item item : items) {
            if (item.getCode() == code) {
                return item;
            }
        }
        return null;
    }

    static int readNumber(String text) {
        while (true) {
            try {
                System.out.print(text);
                return Integer.parseInt(scanner.nextLine());
            } catch (Exception e) {
                System.out.println("Тек сан енгізіңіз.");
            }
        }
    }
}
