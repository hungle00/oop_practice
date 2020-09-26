package sort;

public class BubbleSort implements Sort{

    @Override
    public void sort(int[] nums) {
        System.out.println("Bubble Sort");
        // TODO Auto-generated method stub
        for (int i = 0; i < nums.length - 1; i++) { 
            boolean swapped = false;
            for (int j = 0; j < nums.length - i - 1; j++)  { 
                if (nums[j] > nums[j + 1]) {  
                    swap(nums, j, j + 1);
                    swapped = true; 
                } 
            } 
            if (swapped == false) 
                break; 
        }
    }
    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i]; 
        nums[i] = nums[j]; 
        nums[j] = temp;
    }
    
}
