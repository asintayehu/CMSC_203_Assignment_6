import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CustomerTestStudent {

    @Test
    void testCustomerConstructor() {
        Customer customer = new Customer("Alice", 30);
        assertNotNull(customer);
        assertEquals("Alice", customer.getName());
        assertEquals(30, customer.getAge());
    }

    @Test
    void testGetName() {
        Customer customer = new Customer("Bob", 25);
        assertEquals("Bob", customer.getName());
    }

    @Test
    void testGetAge() {
        Customer customer = new Customer("Charlie", 40);
        assertEquals(40, customer.getAge());
    }
}
