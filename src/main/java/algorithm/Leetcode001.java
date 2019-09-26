package algorithm;

public class Leetcode001 {
    private int[] twoSum(int[] nums, int target) {
        for(int a=0;a<nums.length-1;a++){
            for(int b=a+1;b<nums.length;b++){
                if(nums[a]+nums[b]==target){
                    return new int[]{a,b};
                }
            }
        }
        return null;
    }
    public static void main(String[] args){
        int[] nums=new int[]{2,7,11,15};
        Leetcode001 s=new Leetcode001();

        int[] res=s.twoSum(nums,9);
        if(res!=null){
            for(int i:res){
                System.out.println(i);
            }
        }
    }
}
