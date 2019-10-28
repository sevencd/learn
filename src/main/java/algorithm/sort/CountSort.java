package algorithm.sort;


public class CountSort extends Sort {
    CountSort(int size) {
        this.size = size;
        a = new int[size];
    }

    public static void main(String[] args) {
        CountSort sort = new CountSort(5);
        sort.createData();
        System.out.print("排序前数据为");
        sort.display();
        System.out.println();
        sort.countSort();
        System.out.print("排序后数据为");
        sort.display();
    }

    public void countSort() {
        if (size <= 1) return;
        // 查找数组中数据的范围
        int max = a[0];
        for (int i = 1; i < size; ++i) {
            if (max < a[i]) {
                max = a[i];
            }
        }
        int[] c = new int[max + 1]; // 申请一个计数数组 c，下标大小 [0,max]
        for (int i = 0; i <= max; ++i) {
            c[i] = 0;
        }
        // 计算每个元素的个数，放入 c 中
        for (int i = 0; i < size; ++i) {
            c[a[i]]++;
        }
        // 依次累加
        for (int i = 1; i <= max; ++i) {
            c[i] = c[i - 1] + c[i];
        }
        // 临时数组 r，存储排序之后的结果
        int[] r = new int[size];
        // 计算排序的关键步骤，有点难理解
        for (int i = size - 1; i >= 0; --i) {
            int index = c[a[i]] - 1;
            r[index] = a[i];
            c[a[i]]--;
        }
        // 将结果拷贝给 a 数组
        for (int i = 0; i < size; ++i) {
            a[i] = r[i];
        }
    }
}

