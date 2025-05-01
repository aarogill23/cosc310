package chap14.tests;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.Test;

import chap14.Sorter;

public class SorterTest {

    
    

    @Test
    public void testBubbleSort() {

    int[] nums = new int[]  {5, 10, 15,-5, 25, 42, 9, 11};
    int[] sorted = new int[] {-5, 5, 9, 10, 11, 15, 25, 42};

        Sorter.bubbleSort(nums);

    assertArrayEquals(sorted, nums);
    }

    @Test
    public void testMergeSort() {
        ArrayList<Integer> nums = new ArrayList<Integer>(10);
        nums.add(38);
        nums.add(27);
        nums.add(43);
        nums.add(3);
        nums.add(9);
        nums.add(10);
        nums.add(82);
       
       int[] sorted = new int[] {3, 9, 10, 27, 38, 43, 82};

        nums = Sorter.mergeSort(nums);

        for(int i = 0; i<nums.size(); i++){
            assertEquals(sorted[i], (int)nums.get(i));
        }


        assertEquals(sorted.length, nums.size());
    }

    @Test
    public void testSelectionSort() {
        int[] nums = new int[] {5, 10, 15, -5, 25, 42, 9, 11};
        int[] sorted = new int[] {-5, 5, 9, 10, 11, 15, 25, 42};

        Sorter.selectionSort(nums);

        assertArrayEquals(sorted, nums);
    }
}