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

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}
}
