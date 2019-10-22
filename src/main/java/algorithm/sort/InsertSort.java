package algorithm.sort;

public class InsertSort extends Sort {
    public static void main(String[] args) {
        InsertSort sort = new InsertSort();
        int[] a = {1, 3, 5, 2, 4, 6};
        sort.insertSort(a, a.length);
        sort.display(a, a.length);
    }
    // 插入排序，a 表示数组，n 表示数组大小
    public void insertSort(int[] a, int n) {
        for (int i = 1; i < n; i++) {
            int value = a[i];
            //插入点
            int j = 0;
            for (j = i; j > 0 && a[j - 1] > value; j--) {
                //如果当前值小于前面的值,前面的值后移
                a[j] = a[j - 1];
            }
            a[j] = value;
        }
    }
}
