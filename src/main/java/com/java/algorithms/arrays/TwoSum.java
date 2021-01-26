package com.java.algorithms.arrays;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    public static int[] twoSum(int[] nums, int target) {
        int[] resArray = new int[2];
        Map<Integer, Integer> map= new HashMap<Integer, Integer>();
        for(int i=0; i<nums.length; i++){
            map.put(nums[i], i);
        }
        
        for(int i=0; i<nums.length; i++){
            int remainder = target-nums[i];
            if(map.containsKey(remainder) && map.get(remainder)!=i){
                resArray[0]=i;
                resArray[1]=map.get(remainder);
                break;
            }
        }
        return resArray;
    }
    
    public static void main(String[] args) {
    	int[] inputArray = {1,3,4,2,1,3};
    	for(int i: twoSum(inputArray, 7))
    	System.out.println(i);
    }
}
