package sort;

public class InsertionSort implements Sort{

    @Override
    public void sort(int[] nums) {
        // TODO Auto-generated method stub
        for(int i = 1; i < nums.length; i++) {
            int key = nums[i];
            int j = i - 1;
            while(j >= 0 && nums[j] > key) {
                nums[j + 1] = nums[j];
                j = j - 1;
            } 
            nums[j + 1] = key;
        } 
    }
    
}
