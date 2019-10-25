package algorithm.sort;

import java.util.Random;

abstract class Sort {
    protected int[] a;



    protected void createData() {
        for (int i = 0; i < a.length; i++) {
            a[i] = new Random().nextInt(20);
        }
    }

    protected void display(int[] a, int n) {
        for (int i = 0; i < n; i++) {
            System.out.print(a[i] + ",");

        }
    }
}
