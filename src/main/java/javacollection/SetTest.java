package javacollection;

import com.csz.domain.Student;

import java.util.*;

public class SetTest {
    public static void main(String[] args) {
        testHashSet();
    }

    private static void testHashSet() {
        Set<Character> set = new HashSet<>();
        set.add('b');set.add('c');set.add('a');
        System.out.println(set.toString());

    }


}
