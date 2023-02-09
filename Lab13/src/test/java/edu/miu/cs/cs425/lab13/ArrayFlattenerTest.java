package edu.miu.cs.cs425.lab13;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ArrayFlattenerTest {
    private ArrayFlattener flattener;

    @BeforeEach
    void setUp() {
       flattener = new ArrayFlattener();
    }

    @AfterEach
    void tearDown() {
        flattener=null;
    }

    @Test
    public void testFlattenArrayWithLegitInput() {
        int[][] a_in = {{1, 3}, {0}, {4, 5, 9}};
        int[] expected = {1, 3, 0, 4, 5, 9};
        int[] actual = flattener.flattenArray(a_in);
        assertArrayEquals(expected, actual);
    }

    @Test
    public void testFlattenArrayWithLegitInputByNull() {
        int[][] a_in = {{1, 3}, {0}, {4, 5, 9}};
        int[] expected = {1, 3, 0, 4, 5, 9};
        int[] actual = flattener.flattenArray(a_in);
        assertArrayEquals(expected, actual);
    }



}