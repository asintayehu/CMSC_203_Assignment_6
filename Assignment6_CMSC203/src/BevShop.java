import java.util.ArrayList;
import java.util.Collections;

public class BevShop implements BevShopInterface {
    private ArrayList<Order> orders;
    private Order currentOrder;
    private int numOfAlcoholDrinks;

    public BevShop() {
        orders = new ArrayList<>();
        currentOrder = null;
        numOfAlcoholDrinks = 0;
    }

    @Override
    public boolean isValidTime(int time) {
        return time >= MIN_TIME && time <= MAX_TIME;
    }

    @Override
    public int getMaxNumOfFruits() {
        return MAX_FRUIT;
    }

    @Override
    public int getMinAgeForAlcohol() {
        return MIN_AGE_FOR_ALCOHOL;
    }

    @Override
    public boolean isMaxFruit(int numOfFruits) {
        return numOfFruits > MAX_FRUIT;
    }

    @Override
    public int getMaxOrderForAlcohol() {
        return MAX_ORDER_FOR_ALCOHOL;
    }

    @Override
    public boolean isEligibleForMore() {
        return numOfAlcoholDrinks < MAX_ORDER_FOR_ALCOHOL;
    }

    @Override
    public int getNumOfAlcoholDrink() {
        return numOfAlcoholDrinks;
    }

    @Override
    public boolean isValidAge(int age) {
        return age >= MIN_AGE_FOR_ALCOHOL;
    }

    @Override
    public void startNewOrder(int time, Day day, String customerName, int customerAge) {
    	Customer c = new Customer(customerName, customerAge);
        currentOrder = new Order(time, day, c);
        orders.add(currentOrder);
        numOfAlcoholDrinks = 0;
    }

    @Override
    public void processCoffeeOrder(String bevName, Size size, boolean extraShot, boolean extraSyrup) {
        if (currentOrder != null) {
            currentOrder.addNewBeverage(bevName, size, extraShot, extraSyrup);
        }
    }

    @Override
    public void processAlcoholOrder(String bevName, Size size) {
        if (currentOrder != null && isEligibleForMore()) {
            currentOrder.addNewBeverage(bevName, size);
            numOfAlcoholDrinks++;
        }
    }

    @Override
    public void processSmoothieOrder(String bevName, Size size, int numOfFruits, boolean addProtein) {
        if (currentOrder != null && !isMaxFruit(numOfFruits)) {
            currentOrder.addNewBeverage(bevName, size, numOfFruits, addProtein);
        }
    }

    @Override
    public int findOrder(int orderNo) {
        for (int i = 0; i < orders.size(); i++) {
            if (orders.get(i).getOrderNo() == orderNo) {
                return i;
            }
        }
        return -1; // not found
    }

    @Override
    public double totalOrderPrice(int orderNo) {
        int index = findOrder(orderNo);
        if (index != -1) {
            return orders.get(index).calcOrderTotal();
        }
        return 0;
    }

    @Override
    public double totalMonthlySale() {
        double total = 0;
        for (Order order : orders) {
            total += order.calcOrderTotal();
        }
        return total;
    }

    @Override
    public int totalNumOfMonthlyOrders() {
        return orders.size();
    }

    @Override
    public Order getCurrentOrder() {
        return currentOrder;
    }

    @Override
    public Order getOrderAtIndex(int index) {
        if (index >= 0 && index < orders.size()) {
            return orders.get(index);
        }
        return null;
    }

    @Override
    public void sortOrders() {
        int n = orders.size();
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (orders.get(j).compareTo(orders.get(minIndex)) < 0) {
                    minIndex = j;
                }
            }
            Collections.swap(orders, i, minIndex);
        }
    }
}

