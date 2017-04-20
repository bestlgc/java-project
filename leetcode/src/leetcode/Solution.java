package leetcode;

public class Solution {
	public int[] sum(int nums[],int target){
		int result[] = new int[2];
		result[0]=-1;
		
		result[1]=-1;
		
		for(int i = 0;i<nums.length;i++){
			for(int j=i+1;j<nums.length;j++){
				if(nums[i]+nums[j]==target){
					result[0]=i;
					result[1]=j;
					break;
				}
			}
		}
		return result;
	}
}
