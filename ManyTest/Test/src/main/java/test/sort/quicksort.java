package test.sort;

/**
 * @Author: 韩睿
 * @Description:
 * @DateTime: 2024/9/27 14:52
 **/
public class quicksort {
    public static void main(String[] args) {
        int[] a = new int[]{6,9,4,1,2,8,9};
        sort(a,0, a.length-1);
        for(int x : a)
        System.out.print(x + " ");
    }

    public static void sort(int[] nums, int l, int r) {
        if(l >= r)return;

        int now = nums[l+r>>1];
        int i = l-1,j = r+1;
        while(i < j) {
            do i++;while(nums[i] < now);
            do j--;while(nums[j] > now);
            if(i < j) {
                int t = nums[i];
                nums[i] = nums[j];
                nums[j] = t;
            }
        }
        sort(nums,l,j);
        sort(nums,j+1,r);
    }
}
