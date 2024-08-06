import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class SmoothieTestStudent {

    @Test
    void testSmoothieConstructor() {
        Smoothie smoothie = new Smoothie("Berry Blast", Size.MEDIUM, 4, true);
        assertNotNull(smoothie);
        assertEquals("Berry Blast", smoothie.getBevName());
        assertEquals(Size.MEDIUM, smoothie.getSize());
        assertEquals(4, smoothie.getNumOfFruits());
        assertTrue(smoothie.getAddProtein());
    }

    @Test
    void testCalcPrice() {
        Smoothie smoothie = new Smoothie("Tropical", Size.LARGE, 2, false);
        assertEquals(4.0, smoothie.calcPrice(), 0.01);
    }

    @Test
    void testGetNumOfFruits() {
        Smoothie smoothie = new Smoothie("Green", Size.SMALL, 3, true);
        assertEquals(3, smoothie.getNumOfFruits());
    }

    @Test
    void testHasProtein() {
        Smoothie smoothie = new Smoothie("Protein Power", Size.LARGE, 1, true);
        assertTrue(smoothie.getAddProtein());
    }
}

