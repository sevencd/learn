package algorithm.search;

import algorithm.sort.InsertSort;

public class DichotomizeSearch extends Search{
    public DichotomizeSearch(int size) {
        this.size=size;
        a=new int[size];
    }

    public static void main(String[] args) {
        int size=5;
        DichotomizeSearch search=new DichotomizeSearch(size);
        search.createData();
        search.display();
        InsertSort sort=new InsertSort();
        sort.insertSort(search.a,search.size);
        int location=search.ordinarySearch(3);
        System.out.print(location);
    }

    private int bSearch(int value) {
        return -1;
    }
    private int ordinarySearch(int value) {
        int location=0;
        while (location<size){
            if(value==a[location]){
                return location;
            }
            location++;
        }
        if(location==size){
            location=-1;
        }
        return location;
    }
}
