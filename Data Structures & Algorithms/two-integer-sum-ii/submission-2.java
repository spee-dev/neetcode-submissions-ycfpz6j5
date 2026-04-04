class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int n=numbers.length;
        int left=0;
        int right=n-1;
        while(left<right){
            int sum=numbers[left]+numbers[right];
            if(sum==target)return new int[]{left+1,right+1};
            else if(target>sum)left=left+1;
            else right=right-1;
        }
        return new int[0];
    }
}
