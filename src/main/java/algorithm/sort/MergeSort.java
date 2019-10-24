package algorithm.sort;

public class MergeSort extends Sort {
    public static void main(String[] args) {
        MergeSort sort = new MergeSort();
        int[] a = {1, 3, 5, 2, 4, 6};
        sort.mergeSort(a, 0, a.length - 1);
        sort.display(a, a.length);
    }

    private void mergeSort(int[] a, int p, int r) {
        // 递归终止条件

        if (p >= r) return;
        int q = (p + r) / 2;
        mergeSort(a, p, q);
        mergeSort(a, q + 1, r);
        merge(a, p, q, r);
    }

    private void merge(int[] a, int p, int q, int r) {
        int[] tmp = new int[a.length];
        int k = 0;
        int i = p;
        int j = q + 1;
        while (i <=q && j <=r) {
            if (a[i] <= a[j]) {
                tmp[k++] = a[i++];
            } else {
                tmp[k++] = a[j++];
            }
        }
        // 判断哪个子数组中有剩余的数据

        int start=i;
        int end=q;

        if (j <= r) {
            start = j;
            end = r;
        }


        // 将剩余的数据拷贝到临时数组 tmp

        while (start <= end) {

            tmp[k++] = a[start++];

        }


        // 将 tmp 中的数组拷贝回 A[p...r]
        for (int ii = 0; ii < r-p; ii++) {
            a[p+ii] = tmp[ii];
        }
    }
}
