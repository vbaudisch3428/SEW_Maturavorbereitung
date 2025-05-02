import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CalcTest {

    SimpleCalculator calculator;

    @BeforeEach
    public void setup() {
         calculator = new SimpleCalculator();
    }

    @Test
    public void testAdd() {
        assertEquals(5, calculator.add(2, 3));
        assertNotEquals(5, calculator.add(2, 4));
        assertTrue(calculator.add(2,5) == 7);
    }
}
