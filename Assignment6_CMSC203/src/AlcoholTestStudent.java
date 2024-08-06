import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class AlcoholTestStudent {

    @Test
    void testAlcoholConstructor() {
        Alcohol alcohol = new Alcohol("Beer", Size.SMALL, true);
        assertNotNull(alcohol);
        assertEquals("Beer", alcohol.getBevName());
        assertEquals(Size.SMALL, alcohol.getSize());
        assertTrue(alcohol.isWeekend());
    }

    @Test
    void testCalcPrice() {
        Alcohol alcohol = new Alcohol("Wine", Size.MEDIUM, false);
        assertEquals(2.5, alcohol.calcPrice(), 0.01);
    }

    @Test
    void testIsWeekend() {
        Alcohol alcohol = new Alcohol("Vodka", Size.LARGE, true);
        assertTrue(alcohol.isWeekend());
    }
}
