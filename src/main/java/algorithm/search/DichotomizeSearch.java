package algorithm.search;

import algorithm.sort.InsertSort;

public class DichotomizeSearch extends Search {
    public DichotomizeSearch(int size) {
        this.size = size;
        a = new int[size];
    }

    public static void main(String[] args) {
        int size = 5;
        DichotomizeSearch search = new DichotomizeSearch(size);
        //search.createData();
        search.a = new int[]{1, 6, 2, 10, 3};
        search.size = 5;
        search.display();
        InsertSort sort = new InsertSort();
        int[] result = sort.insertSort(search.a, search.size);
        //int location=search.ordinarySearch(3);
        //int location=search.bSearch(result,3);
        int location = search.bSearch(result, 3, 0, size - 1);
        System.out.print(location);
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
