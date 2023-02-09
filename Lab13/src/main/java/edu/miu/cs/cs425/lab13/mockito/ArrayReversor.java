package edu.miu.cs.cs425.lab13.mockito;

import edu.miu.cs.cs425.lab13.mockito.ArrayFlattenerService;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ArrayReversor {

    public int[] reverseArray(int[][] a_in) {
        if (a_in == null) {
            return null;
        }

        int[] flattenedArray = new ArrayFlattenerService().flattenArray(a_in);
        List<Integer> list = new ArrayList<>();
        for (int i : flattenedArray) {
            list.add(i);
        }
        Collections.reverse(list);
        int[] reversedArray = list.stream().mapToInt(i -> i).toArray();
        return reversedArray;
    }

    public static class ArrayFlattenerService {

        public int[] flattenArray(int[][] a_in) {
            List<Integer> list = new ArrayList<>();
            for (int[] innerArray : a_in) {
                for (int i : innerArray) {
                    list.add(i);
                }
            }
            int[] flattenedArray = list.stream().mapToInt(i -> i).toArray();
            return flattenedArray;
        }
    }
}
