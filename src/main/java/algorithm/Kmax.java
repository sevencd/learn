package algorithm;


import java.util.Random;

/*
查找第k大的元素
 */
public class Kmax{
    private int valuek;
    int a[];
    Kmax(int size) {
        a = new int[size];
    }
    public static void main(String[] args) {
        int k=2;
        Kmax kmax = new Kmax(5);
        kmax.createData();
        System.out.print("原始数据为");
        kmax.display(kmax.a, kmax.a.length);
        System.out.println();
        kmax.findK(kmax.a, 0, kmax.a.length - 1,k);
        System.out.print("第"+k+"大数据为"+kmax.valuek);
    }
    public void findK(int[] a, int p, int r,int k) {
        int q = partition(a, p, r,k); // 获取分区点

        if(k<q+1){
            findK(a, p, q - 1,k);
        }
        if(k==(q+1)){
            valuek=a[q];
        }
        if(k>q+1){
            findK(a, q + 1, r,k);
        }
    }

    public int partition(int[] a, int p, int r,int k) {
        int pivot = a[r];//用来确定分区点的值
        int i = p;//确定分区点
        for (int j = p; j < r;j++ ) {
             if (a[j] < pivot) {
                int tmp = a[i];
                a[i] = a[j];
                a[j] = tmp;
                i++;
            }
        }
        int tmp = a[i];
        a[i] = a[r];
        a[r] = tmp;
        return i;
    }
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
