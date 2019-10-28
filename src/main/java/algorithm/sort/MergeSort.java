package algorithm.sort;

public class MergeSort extends Sort {
    MergeSort(int size) {
        this.size=size;
        a = new int[size];
    }
    public static void main(String[] args) {
        MergeSort sort = new MergeSort(5);
        sort.createData();
        System.out.print("排序前数据为");
        sort.display();
        System.out.println();
        sort.mergeSort(0, sort.size - 1);
        System.out.print("排序后数据为");
        sort.display();

    }

    private void mergeSort(int p, int r) {
        // 递归终止条件
        if (p >= r) return;
        int q = (p + r) / 2;
        mergeSort(p, q);
        mergeSort(q + 1, r);
        merge(p, q, r);
    }

    private void merge(int p, int q, int r) {
        int[] tmp = new int[size];
        int k = 0;
        int i = p;
        int j = q + 1;
        while (i <= q && j <= r) {
            if (a[i] <= a[j]) {
                tmp[k++] = a[i++];
            } else {
                tmp[k++] = a[j++];
            }
        }
        // 判断哪个子数组中有剩余的数据
        int start = i;
        int end = q;
        if (j <= r) {
            start = j;
            end = r;
        }
        // 将剩余的数据拷贝到临时数组 tmp
        while (start <= end) {
            tmp[k++] = a[start++];
        }
        // 将 tmp 中的数组拷贝回 A[p...r]
        for (int ii = 0; ii <= r - p; ii++) {
            a[p + ii] = tmp[ii];
        }
    }
}
