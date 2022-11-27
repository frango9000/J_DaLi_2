package org.example.support;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

public class Generators {
    public static Integer[] getRandomArray(int size) {
        Random rand = new Random(); //instance of random class
        List<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < size; i++) list.add(rand.nextInt(size * 5));
        Collections.shuffle(list);
        return list.toArray(new Integer[0]);
    }

    public static Integer[] getUniqueRandom(int size) {
        Set<Integer> set = new HashSet<Integer>();
        while (set.size() < size) set.add(new Random().nextInt(size * 5));
        return set.toArray(new Integer[0]);
    }
}
