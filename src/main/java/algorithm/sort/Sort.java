package algorithm.sort;

import java.util.Random;

abstract class Sort {
    int[] a;



    void createData() {
        for (int i = 0; i < a.length; i++) {
            a[i] = new Random().nextInt(20);
        }
    }

    void display(int[] a, int n) {
        for (int i = 0; i < n; i++) {
            System.out.print(a[i] + ",");

        }
    }
}
