package sort;

public class SelectionSort implements Sort {
    @Override
    public void sort(int[] nums) {
        // TODO Auto-generated method stub
        System.out.println("Selection Sort");
        for(int i = 0; i < nums.length - 1; i++) {
            //visual(nums);
            int min = i;
            for(int j = i + 1; j < nums.length; j++) {
                if(nums[min] > nums[j]) {
                    min = j;
                }
            }
            swap(nums, min, i);
        }  
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i]; 
        nums[i] = nums[j]; 
        nums[j] = temp;
    }
} 
