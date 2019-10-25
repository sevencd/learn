package algorithm;


import algorithm.sort.QuickSort;

/*
查找第k大的元素
 */
public class Kmax extends QuickSort {
    private int value;
    Kmax(int size) {
        super(size);
    }
    public static void main(String[] args) {
        int k=2;
        Kmax kmax = new Kmax(6);
        kmax.createData();
        System.out.print("原始数据为");
        kmax.display(kmax.a, kmax.a.length);
        System.out.println();
        kmax.findK(kmax.a, 0, kmax.a.length - 1,k);
        System.out.print("第"+k+"大数据为"+kmax.value);
    }
    public void findK(int[] a, int p, int r,int k) {
        int q = partition(a, p, r); // 获取分区点
        if(k<q+1){
            findK(a, p, q - 1,k);
        }
        if(k==(q+1)){
            value =a[q];
        }
        if(k>q+1){
            findK(a, q + 1, r,k);
        }
    }
}
