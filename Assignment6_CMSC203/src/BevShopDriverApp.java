import java.util.Scanner;

public class BevShopDriverApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BevShop shop = new BevShop();
        
        while (true) {
            System.out.println("Start a new order");
            
            // Prompt user for time
            System.out.print("Enter the time of the order (24 hour format, ex: 14 for 2 PM): ");
            int time = scanner.nextInt();
            if (!shop.isValidTime(time)) {
                System.out.println("Invalid time. Please enter a time between 8 and 23.");
                continue;
            }
            
            // Prompt user for day of the week
            System.out.print("Enter the day of the order (e.g., MONDAY, TUESDAY, etc.): ");
            String dayStr = scanner.next().toUpperCase();
            Day day = Day.valueOf(dayStr);
            
            // Prompt user for name and age
            System.out.print("Enter your name: ");
            scanner.next();
            String name = scanner.nextLine();
            System.out.print("Enter your age: ");
            int age = scanner.nextInt();
            
            // Start a new order
            shop.startNewOrder(time, day, name, age);
            System.out.println("Your Total Order for now is " + shop.getCurrentOrder().calcOrderTotal());

            // Check age eligibility for alcohol
            if (shop.isValidAge(age)) {
                System.out.println("You are eligible to order alcohol.");
                while (shop.isEligibleForMore()) {
                    System.out.print("Would you like to add an alcohol drink? (yes/no): ");
                    String response = scanner.next().toLowerCase();
                    if (response.equals("yes")) {
                        System.out.print("Enter the name of the alcohol beverage: ");
                        String bevName = scanner.next();
                        System.out.print("Enter the size (e.g., SMALL, MEDIUM, LARGE): ");
                        Size size = Size.valueOf(scanner.next().toUpperCase());
                        shop.processAlcoholOrder(bevName, size);
                        System.out.println("The current order of drinks is " + shop.getCurrentOrder().getTotalItems());
                        System.out.println("The Total Price on the Order is " + shop.getCurrentOrder().calcOrderTotal());
                    } else {
                        break;
                    }
                }
            } else {
                System.out.println("Your age is not appropriate for alcohol drink!!");
            }

            // Offer to add coffee or smoothie
            while (true) {
                System.out.print("Would you like to add a COFFEE or SMOOTHIE to your order? (Enter COFFEE, SMOOTHIE, or NONE to finish): ");
                String drinkType = scanner.next().toUpperCase();
                if (drinkType.equals("NONE")) {
                    break;
                } else if (drinkType.equals("COFFEE")) {
                    System.out.print("Enter the coffee name: ");
                    String bevName = scanner.nextLine();
                    scanner.nextLine();
                    System.out.print("Enter the size (e.g., SMALL, MEDIUM, LARGE): ");
                    Size size = Size.valueOf(scanner.next().toUpperCase());
                    System.out.print("Extra shot (true/false): ");
                    boolean extraShot = scanner.nextBoolean();
                    System.out.print("Extra syrup (true/false): ");
                    boolean extraSyrup = scanner.nextBoolean();
                    shop.processCoffeeOrder(bevName, size, extraShot, extraSyrup);
                } else if (drinkType.equals("SMOOTHIE")) {
                    System.out.print("Enter the smoothie name: ");
                    String bevName = scanner.nextLine();
                    System.out.print("Enter the size (e.g., SMALL, MEDIUM, LARGE): ");
                    Size size = Size.valueOf(scanner.next().toUpperCase());
                    System.out.print("Enter the number of fruits: ");
                    int numOfFruits = scanner.nextInt();
                    if (shop.isMaxFruit(numOfFruits)) {
                        System.out.println("You have reached the maximum number of fruits allowed.");
                    } else {
                        System.out.print("Add protein (true/false): ");
                        boolean addProtein = scanner.nextBoolean();
                        shop.processSmoothieOrder(bevName, size, numOfFruits, addProtein);
                    }
                } else {
                    System.out.println("Invalid choice. Please enter COFFEE, SMOOTHIE, or NONE.");
                }
                System.out.println("The Total Price on the Order is " + shop.getCurrentOrder().calcOrderTotal());
            }

            // Display order information
            Order currentOrder = shop.getCurrentOrder();
            System.out.println("Order Number: " + currentOrder.getOrderNo());
            System.out.println("Order Time: " + currentOrder.getOrderTime());
            System.out.println("Day: " + currentOrder.getOrderDay());
            System.out.println("Weekend: " + (currentOrder.isWeekend() ? "Yes" : "No"));
            System.out.println("Total Price on the Order: " + currentOrder.calcOrderTotal());
            System.out.println("Total Items on the Order: " + currentOrder.getTotalItems());

            // Check if the user wants to start a new order
            System.out.print("Would you like to start a new order? (yes/no): ");
            String startNewOrder = scanner.next().toLowerCase();
            if (!startNewOrder.equals("yes")) {
                break;
            }
        }

        // Display total sales and number of orders
        System.out.println("Total number of orders this month: " + shop.totalNumOfMonthlyOrders());
        System.out.println("Total amount for all Orders: " + shop.totalMonthlySale());

        scanner.close();
    }
}
