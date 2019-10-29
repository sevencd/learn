package algorithm.search;

import java.util.Random;

public class Search {
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
    protected void display(int[] a,int size) {
        for (int i = 0; i < size; i++) {
            System.out.print(a[i] + ",");
        }
    }
}
