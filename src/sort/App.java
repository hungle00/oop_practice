package sort;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;

public class App {

    public static void exportToFile(String str) throws IOException {
        FileOutputStream fout = new FileOutputStream("new.txt");
        byte b[] = str.getBytes();
        fout.write(b); 
        fout.close();
    }

    public static void setRandomArrayInteger(int[] nums, int min, int max) {
        for(int i = 0; i < nums.length; i++) {
            nums[i] = (int) ((Math.random() * (max - min)) + min);
        }
    }

    public static void measureTime(int size) {
        Sort[] items = {new BubbleSort(), new SelectionSort(), new InsertionSort(), new MergeSort(), new QuickSort()};
        for(int i = 0; i < items.length; i++) {
            int[] array = new int[size];
            setRandomArrayInteger(array, 1, size);
            System.out.println(items[i].getClass().getName());
            long start = System.currentTimeMillis();
            long total = 0;
            items[i].sort(array);
            long end = System.currentTimeMillis();
            System.out.println((end - start) + " ms");
        }
    }

    public static void main(String[] args) {
        for (int num : new int[] {1000, 2000, 4000, 8000}) {
            System.out.println("Sort with array length: " + num);
            measureTime(num);
        }
    }
}
