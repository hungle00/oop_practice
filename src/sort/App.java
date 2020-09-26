package sort;
import java.util.Arrays;

public class App {

    public static int[] getRandomArrayInteger(int length, int min, int max) {
        int[] nums = new int[length];
        for(int i = 0; i < length; i++) {
            nums[i] = (int) ((Math.random() * (max - min)) + min);
        }
        return nums;
    }

    public static void main(String[] args) {
        int[] nums = getRandomArrayInteger(1000, 1, 5000);
        Sort[] items = {new BubbleSort(), new SelectionSort(), new InsertionSort(), new MergeSort(), new QuickSort()};
        for(int i = 0; i < items.length; i++) {
            long start = System.currentTimeMillis();
            items[i].sort(nums);
            long end = System.currentTimeMillis();
            System.out.println((end - start) + " ms");
        }
        System.out.println(Arrays.toString(nums));
    }
}
