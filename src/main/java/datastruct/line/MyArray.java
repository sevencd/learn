package datastruct.line;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.function.Consumer;

import org.apache.log4j.net.SyslogAppender;

import com.csz.domain.Student;

import thread.CallableThread;

public class MyArray {
	private int[] arr;
	private int maxSize;
	private int size;

	public MyArray(int maxSize) {
		this.maxSize = maxSize;
		this.size = 0;
		arr = new int[this.maxSize];
	}

	public void insert(int value) {
		arr[size++] = value;
	}

	public void delete(int value) {
		// 查找所在位置
		int i = indexOf(value);
		if (i != -1) {
			// 该位置后的数据左移
			for (int j = i; j < size - 1; j++) {
				arr[j] = arr[j + 1];
			}
			arr[--size]=0;
		}

	}

	public int size() {
		// TODO Auto-generated method stub
		return size;
	}

	public int indexOf(int value) {
		int i = 0;
		for (; i < size; i++) {
			if (arr[i] == value) {
				return i;
			}
		}
		return -1;
	}

	public void displayAll() {
		for (int i = 0; i < size; i++) {
			System.out.println(arr[i]);
		}
	}
	public void displayAllByMaxSize() {
		for (int i = 0; i < maxSize; i++) {
			System.out.println(arr[i]);
		}
	}
	public static void main(String[] args) {
		/*
		 * final int N = 1000000; Object obj = new Object();
		 * 
		 * //没用调用ensureCapacity()方法初始化ArrayList对象 ArrayList list = new
		 * ArrayList(N); long startTime = System.currentTimeMillis(); for(int
		 * i=0;i<=N;i++){ list.add(obj); } long endTime =
		 * System.currentTimeMillis();
		 * System.out.println("没有调用ensureCapacity()方法所用时间：" + (endTime -
		 * startTime) + "ms");
		 * 
		 * //调用ensureCapacity()方法初始化ArrayList对象 list = new ArrayList();
		 * startTime = System.currentTimeMillis();
		 * list.ensureCapacity(N);//预先设置list的大小 for(int i=0;i<=N;i++){
		 * list.add(obj); } endTime = System.currentTimeMillis();
		 * System.out.println("调用ensureCapacity()方法所用时间：" + (endTime -
		 * startTime) + "ms");
		 */
		List<Student> list=new ArrayList<>(12);
		for(int i=0;i<12;i++){
			list.add(new Student(i));
		}
		/*Thread t1=new Thread(new Runnable() {
			@Override
			public void run() {
				Iterator<Student> ite=list.iterator();
				while(ite.hasNext()){
					if(ite.next().getId()<3){
						ite.remove();
					}
				}				
			}
		});*/
		Callable<Integer> callable = new Callable<Integer>() {
			public Integer call() throws Exception {
				Iterator<Student> ite=list.iterator();
				while(ite.hasNext()){
					if(ite.next().getId()<3){
						ite.remove();
					}
				}	
				return new Random().nextInt(100);
			}
		};
		/*Thread t2=new Thread(new Runnable() {
			@Override
			public void run() {
				Iterator<Student> ite=list.iterator();
				while(ite.hasNext()){
					if(ite.next().getId()==2){
						ite.remove();
					}
				}				
			}
		});*/
		//t1.start();
		//t2.start();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		/*list.forEach(new Consumer<Student>() {
			@Override
			public void accept(Student t) {
				// TODO Auto-generated method stub
				System.out.println(t.getId());
			}
		});*/
		
		
		try {
			System.out.println(CallableThread.runByPool(callable));
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			e.printStackTrace();
		}
		for(Student s:list){
			System.out.println(s.getId());
		}
	}
}
