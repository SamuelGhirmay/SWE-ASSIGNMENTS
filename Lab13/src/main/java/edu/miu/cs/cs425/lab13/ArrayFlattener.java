package edu.miu.cs.cs425.lab13;

import java.util.ArrayList;
import java.util.List;

public class ArrayFlattener {

    public int[] flattenArray(int[][] a_in) {
        if (a_in == null) {
            return null;
        }

        List<Integer> result = new ArrayList<>();
        for (int[] array : a_in) {
            for (int element : array) {
                result.add(element);
            }
        }

        return result.stream().mapToInt(i -> i).toArray();


    }
}
