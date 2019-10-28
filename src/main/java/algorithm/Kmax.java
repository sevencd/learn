package algorithm;


import algorithm.sort.QuickSort;

/*
查找第k大的元素
 */
public class Kmax extends QuickSort {
    private int value;

    private Kmax(int size) {
        super(size);
        this.size = size;
    }

    public static void main(String[] args) {
        int k = 2;
        Kmax kmax = new Kmax(6);
        kmax.createData();
        System.out.print("原始数据为");
        kmax.display();
        System.out.println();
        kmax.findK(0, kmax.a.length - 1, k);
        System.out.print("第" + k + "大数据为" + kmax.value);
    }

    public void findK(int p, int r, int k) {
        int q = partition(p, r); // 获取分区点
        if (k < q + 1) {
            findK(p, q - 1, k);
        }
        if (k == (q + 1)) {
            value = a[q];
        }
        if (k > q + 1) {
            findK(q + 1, r, k);
        }
    }
}
