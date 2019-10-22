package algorithm.sort;
/*
选择排序算法的实现思路有点类似插入排序，也分已排序区间和未排序区间。
但是选择排序每次会从未排序区间中找到最小的元素，将其放到已排序区间的末尾。
 */
public class SelectionSort extends Sort {

    public static void main(String[] args) {
        SelectionSort sort = new SelectionSort();
        int[] a = {1, 3, 5, 2, 4, 6};
        sort.selectionSort(a, a.length);
        sort.display(a, a.length);
    }
    // 选择排序，a 表示数组，n 表示数组大小
    public void selectionSort(int[] a, int n) {
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
