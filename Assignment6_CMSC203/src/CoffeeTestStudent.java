import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CoffeeTestStudent {

    @Test
    void testCoffeeConstructor() {
        Coffee coffee = new Coffee("Latte", Size.MEDIUM, true, false);
        assertNotNull(coffee);
        assertEquals("Latte", coffee.getBevName());
        assertEquals(Size.MEDIUM, coffee.getSize());
        assertTrue(coffee.getExtraShot());
        assertFalse(coffee.getExtraSyrup());
    }

    @Test
    void testGetBevName() {
        Coffee coffee = new Coffee("Espresso", Size.SMALL, false, true);
        assertEquals("Espresso", coffee.getBevName());
    }

    @Test
    void testGetSize() {
        Coffee coffee = new Coffee("Cappuccino", Size.LARGE, false, false);
        assertEquals(Size.LARGE, coffee.getSize());
    }
}
