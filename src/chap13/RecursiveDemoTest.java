package chap13;

import static org.junit.Assert.*; 
import org.junit.Test;

public class RecursiveDemoTest {
    @Test
    public void testBitextractor() {

        int tbyte = 0b10110111;
        int bit = RecursiveDemo.extractBit(tbyte, 0);
        assertEquals(1, bit);
        bit = RecursiveDemo.extractBit(tbyte, bit);
        assertEquals(1, bit);

    }

    @Test
    public void testBitextractor_r() {
        int tbyte = 0b10110111;
        int expected = 2;
        int actual = RecursiveDemo.bitextractor_r(tbyte, 7, 2);

        assertEquals(expected, actual);
        expected = 2;
        actual = RecursiveDemo.bitextractor_r(tbyte, 7, 2);
        assertEquals(expected, actual);
        
        tbyte = 0b11110111;
        expected = 3;
        actual = RecursiveDemo.bitextractor_r(tbyte, 7, 2);
        assertEquals(expected, actual);
    }

    @Test
    public void testExtractBit() {

    }

    @Test
    public void testFactorial() {

    }

    @Test
    public void testFactorial_it() {

    }
}
