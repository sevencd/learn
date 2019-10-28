package algorithm.sort;

/*
插入算法的核心思想是取未排序区间中的元素，在已排序区间中找到合适的插入位置将其插入，
并保证已排序区间数据一直有序。重复这个过程，直到未排序区间中元素为空，算法结束。
 */
public class InsertSort extends Sort {
    public InsertSort() {
    }

    InsertSort(int size) {
        this.size = size;

        a = new int[size];
    }

    public static void main(String[] args) {
        int size = 5;
        InsertSort sort = new InsertSort(size);
        sort.createData();
        System.out.print("排序前数据为");
        sort.display();
        System.out.println();
        sort.insertSort();
        System.out.print("排序后数据为");
        sort.display();
    }

    // 插入排序，a 表示数组，n 表示数组大小
    public int[] insertSort(int[] a,int n) {
        int[] result=new int[a.length];
        for (int i = 1; i < n; i++) {
            int value = a[i];
            //插入点
            int j;
            for (j = i; j > 0 && a[j - 1] > value; j--) {
                //如果当前值小于前面的值,前面的值后移
                a[j] = a[j - 1];
            }
            a[j] = value;
        }
        for (int i = 0; i < n; i++) {
            result[i]=a[i];
        }
        return result;
    }
    public void insertSort() {
        for (int i = 1; i < size; i++) {
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
