package sort;

public class QuickSort implements Sort {

    @Override
    public void sort(int[] nums) {
        // TODO Auto-generated method stub
        System.out.println("Quick Sort");
        quickSort(nums, 0, nums.length);
    }

    public static void quickSort(int[] nums, int low, int high){
        if(high > low) {    
            int key = partition(nums, low, high);
            quickSort(nums, low, key);
            quickSort(nums, key + 1, high);
        }
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i]; 
        nums[i] = nums[j]; 
        nums[j] = temp;
    }

    private static int partition(int[] nums, int low, int high) {
        int key = nums[low];
        int i = low + 1;
        for(int j = i; j < high; j++) {
            if(nums[j] < key) {
                swap(nums, i, j);
                i++;
            }
        }
        swap(nums, low, i - 1);
        return i - 1;
    }
}
