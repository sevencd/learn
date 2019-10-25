package algorithm.sort;
/*
选择排序算法的实现思路有点类似插入排序，也分已排序区间和未排序区间。
但是选择排序每次会从未排序区间中找到最小的元素，将其放到已排序区间的末尾。
 */
public class SelectionSort extends Sort {
    SelectionSort(int size) {
        a = new int[size];
    }
    public static void main(String[] args) {
        int size=5;
        SelectionSort sort = new SelectionSort(5);
        sort.createData();
        System.out.print("排序前数据为");
        sort.display(sort.a, sort.a.length);
        System.out.println();
        sort.selectionSort(sort.a, size - 1);
        System.out.print("排序后数据为");
        sort.display(sort.a, size);
    }
    // 选择排序，a 表示数组，n 表示数组大小
    private void selectionSort(int[] a, int n) {
        int tmp;
        int min;//最小值
        for (int i = 0; i < a.length - 1; i++) {
            min = i;
            for (int j = i + 1; j < a.length; j++) {
                if (a[j] < a[min]) {
                    min = j;
                }
            }
            //交换位置
            tmp = a[min];
            a[min] = a[i];
            a[i] = tmp;
        }
    }
}
