package algorithm.sort;

import java.util.Random;

abstract class Sort {
    protected int[] a;
    protected int size;


    protected void createData() {
        for (int i = 0; i < size; i++) {
            a[i] = new Random().nextInt(20);
        }
    }

    protected void display() {
        for (int i = 0; i < size; i++) {
            System.out.print(a[i] + ",");
        }
    }
}
