import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class OrderTestStudent {

    @Test
    void testOrderConstructor() {
        Customer customer = new Customer("Dave", 22);
        Order order = new Order(1200, Day.FRIDAY, customer);
        assertNotNull(order);
        assertEquals(1200, order.getOrderTime());
        assertEquals(Day.FRIDAY, order.getOrderDay());
        assertEquals(customer, order.getCustomer());
    }

    @Test
    void testAddNewBeverage() {
        Customer customer = new Customer("Eve", 30);
        Order order = new Order(1300, Day.SATURDAY, customer);
        order.addNewBeverage("Smoothie", Size.LARGE, 3, true);
        assertEquals(1, order.getTotalItems());
    }

    @Test
    void testCalcOrderTotal() {
        Customer customer = new Customer("Frank", 28);
        Order order = new Order(1400, Day.SUNDAY, customer);
        order.addNewBeverage("Coffee", Size.MEDIUM, true, false);
        assertEquals(3.0, order.calcOrderTotal(), 0.01);
    }

    @Test
    void testIsWeekend() {
        Customer customer = new Customer("Grace", 35);
        Order order = new Order(1500, Day.SUNDAY, customer);
        assertTrue(order.isWeekend());
    }
}

