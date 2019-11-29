package algorithm.search;

import algorithm.sort.InsertSort;
/*
二分查找
 */
public class DichotomizeSearch extends Search {
    public DichotomizeSearch(int size) {
        this.size = size;
        a = new int[size];
    }

    public static void main(String[] args) {
        int size=6,value=3;
        DichotomizeSearch search = new DichotomizeSearch(size);
        //search.createData();
        search.a = new int[]{1, 6, 3, 10, 3,4};
        System.out.println("排序前");
        search.display();
        InsertSort sort = new InsertSort();
        int[] result = sort.insertSort(search.a, search.size);
        System.out.println("排序后");
        search.display(result,size);
        int location1 = search.bSearchFirst(result, size,value);
        int location2 = search.bSearchLast(result, size,value);
        System.out.println("第一个等于"+value+"的元素"+location1);
        System.out.print("最后一个等于"+value+"的元素"+location2);
    }

    private int bSearch(int[] a, int value) {
        int low = 0, high = size - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (a[mid] == value) {
                return mid;
            } else if (a[mid] < value) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }

    private int bSearch(int[] a, int value, int low, int high) {
        if (low > high) return -1;
        int mid = low + ((high - low) >> 1);
        if (a[mid] == value) {
            return mid;
        } else if (a[mid] < value) {
            return bSearch(a, value, mid + 1, high);
        } else {
            return bSearch(a, value, low, mid - 1);
        }
    }
    //查找第一个等于value的元素
    public int bSearchFirst(int[] a, int n, int value) {
        int low = 0;
        int high = n - 1;
        while (low <= high) {
            int mid =  low + ((high - low) >> 1);
            if (a[mid] > value) {
                high = mid - 1;
            } else if (a[mid] < value) {
                low = mid + 1;
            } else {
                if ((mid == 0) || (a[mid - 1] != value)) return mid;
                else high = mid - 1;
            }
        }
        return -1;
    }
    //查找最后一个值等于value的元素
    public int bSearchLast(int[] a, int n, int value) {
        int low = 0;
        int high = n - 1;
        while (low <= high) {
            int mid =  low + ((high - low) >> 1);
            if (a[mid] > value) {
                high = mid - 1;
            } else if (a[mid] < value) {
                low = mid + 1;
            } else {
                if ((mid == n - 1) || (a[mid + 1] != value)) return mid;
                else low = mid + 1;
            }
        }
        return -1;
    }
    private int ordinarySearch(int value) {
        int location = 0;
        while (location < size) {
            if (value == a[location]) {
                return location;
            }
            location++;
        }
        if (location == size) {
            location = -1;
        }
        return location;
    }
}
