package algorithm.sort;

import java.util.Iterator;
import java.util.LinkedList;

/*
将要排序的数据分到几个有序的桶里，每个桶里的数据再单独进行排序。
桶内排完序之后，再把每个桶里的数据按照顺序依次取出，组成的序列就是有序的了。
 */
public class BucketSort extends Sort{
    BucketSort(int size) {
        this.size=size;
        a = new int[size];
    }
    public static void main(String[] args) {
        BucketSort sort=new BucketSort(50);
        sort.createData();
        System.out.print("排序前数据为");

        sort.display(sort.a,sort.a.length);

        int[] result=sort.bucketSort(sort.a,10);
        System.out.print("排序后数据为");

        sort.display(result,result.length);
        
    }
    public int[] bucketSort(int[] arr, int bucketSize){
        int[] result = new int[arr.length];//排序好的结果数组
        @SuppressWarnings("unchecked")
        LinkedList<Integer>[] bucket = new LinkedList[bucketSize];//桶数组
        for(int i = 0; i < bucketSize; i++){
            //使bucket[i]称为一个空链表
            bucket[i] = new LinkedList<Integer>();
        }
        //将arr[i]插入到 bucket数组 如果数组位置上已经有元素 则插入到其位置的链表的指定位置
        for(int i = 0; i < arr.length; i++){
            int bucketLocation = arr[i]/bucketSize;
            int insertLocation = 0; //待插入位置
            for(insertLocation = 0; insertLocation < bucket[bucketLocation].size() && bucket[bucketLocation].get(insertLocation) < arr[i] ; insertLocation++);
            bucket[bucketLocation].add(insertLocation, arr[i]);
        }
        for(int i = 0,j = 0; i < bucket.length; i++){
            Iterator<Integer> iterator = bucket[i].iterator();
            while(iterator.hasNext()){
                result[j++] = iterator.next();
            }
        }
        return result;
    }
    private void bucketSort(int[][] bucket,int bucketSize) {
        int[] result = new int[this.size];//排序好的结果数组
        for (int i = 0; i <size ; i++) {
            int bucketLocation = a[i]/bucketSize;
            if(a[i]<2&&a[i]>0){
                int value = a[i];
                //插入点
                int j = 0;
                for (j = i; j > 0 && a[j - 1] > value; j--) {
                    //如果当前值小于前面的值,前面的值后移
                    bucket[0][j] = bucket[0][j - 1];
                }
                a[j] = value;

            }
        }
        for(int i = 0,j = 0; i < bucketSize; i++){
            int k=0;
            while(k<bucket[i].length){
                result[j++] =bucket[i][k++];
            }
        }
    }
}
