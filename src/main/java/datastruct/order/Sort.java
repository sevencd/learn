/**
 * 
 */
/**
 * @author lenovo
 *
 */
package datastruct.order;

import java.util.Random;

public class Sort {
	private int[] data;

	public Sort(int size) {
		data = new int[size];
	}

	void createData() {
		for (int i = 0; i < data.length; i++) {
			data[i] = new Random().nextInt(20);
		}
	}
	/*
	 * 冒泡排序
	 */
	void bubbleSort() {
		int tmp;
		for (int i = 0; i < data.length-1; i++) {
			for (int j = 0; j < data.length-i-1; j++) {
				if(data[j]>data[j+1]){
					//移动位置
					tmp=data[j+1];
					data[j+1]=data[j];
					data[j]=tmp;
				}
			}
		}
	}
	/*
	 * 选择排序
	 */
	void selectSort() {
		int tmp;
		int min;
		for (int i = 0; i < data.length-1; i++) {
			min=i;
			for (int j = i+1; j < data.length; j++) {
				if(data[j]<data[min]){
					min=j;
				}
			}
			//交换位置
			tmp=data[min];
			data[min]=data[i];
			data[i]=tmp;
		}
	}
	/*
	 * 插入排序
	 */
	void insertSort() {
		for (int i = 1; i < data.length; i++) {
			//插入点
			int j=0;
			for (j = i; j >0&&data[j-1]>data[j]; j--) {
				//如果当前值小于前面的值,前面的值后移
					data[j]=data[j-1];
			}
			data[j]=data[i];
		}
	}

	void display() {
		for (int i = 0; i < data.length; i++) {
			System.out.print(data[i] + ",");
		}
	}
	void selectSortWarpper(Sort obj){
		obj.createData();
		System.out.print("选择排序前数据为");
		obj.display();
		obj.selectSort();
		System.out.print("排序后数据为");
		obj.display();
	}
	void bubbleSortWarpper(Sort obj){
		obj.createData();
		System.out.print("冒泡排序前数据为");
		obj.display();
		obj.bubbleSort();
		System.out.print("排序后数据为");
		obj.display();
	}
	void insertSortWarpper(Sort obj){
		obj.createData();
		System.out.print("插入排序前数据为");
		obj.display();
		obj.insertSort();
		System.out.print("排序后数据为");
		obj.display();
	}
	public static void main(String[] args) {
		Sort obj = new Sort(10);
		obj.selectSortWarpper(obj);
		System.out.println();
		obj.bubbleSortWarpper(obj);
		System.out.println();
		obj.insertSortWarpper(obj);


	}
}