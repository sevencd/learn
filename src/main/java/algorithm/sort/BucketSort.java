package algorithm.sort;

import java.util.Iterator;
import java.util.LinkedList;

/*
将要排序的数据分到几个有序的桶里，每个桶里的数据再单独进行排序。
桶内排完序之后，再把每个桶里的数据按照顺序依次取出，组成的序列就是有序的了。
 */
public class BucketSort extends Sort {
    BucketSort(int size) {
        this.size = size;
        a = new int[size];
    }

    public static void main(String[] args) {
        int size=5;
        BucketSort sort = new BucketSort(size);
        sort.createData();
        System.out.print("排序前数据为");
        sort.display();
        System.out.println();
        sort.bucketSort(sort.a, 20);
        System.out.print("排序后数据为");
        sort.display();
        System.out.println();
        CountSort countSort=new CountSort(size);
        countSort.createData();
        System.out.print("排序前数据为");
        countSort.display();
        System.out.println();
        countSort.countSort();
        System.out.print("排序后数据为");
        countSort.display();
    }

    public void bucketSort(int[] arr, int bucketSize) {
        LinkedList<Integer>[] bucket = new LinkedList[bucketSize];//桶数组
        for (int i = 0; i < bucketSize; i++) {
            //使bucket[i]称为一个空链表
            bucket[i] = new LinkedList<Integer>();
        }
        //将arr[i]插入到 bucket数组 如果数组位置上已经有元素 则插入到其位置的链表的指定位置
        for (int i = 0; i < arr.length; i++) {
            int bucketLocation = arr[i] / bucketSize;
            int insertLocation = 0; //待插入位置
            while(insertLocation < bucket[bucketLocation].size() && bucket[bucketLocation].get(insertLocation) < arr[i]){
                insertLocation++;
            }
            bucket[bucketLocation].add(insertLocation, arr[i]);
        }
        for (int i = 0, j = 0; i < bucket.length; i++) {
            Iterator<Integer> iterator = bucket[i].iterator();
            while (iterator.hasNext()) {
                a[j++] = iterator.next();
            }
        }
    }
}
