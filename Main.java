package org.kemetkoder.astevens;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Assignment:
 * Find all the numbers that occur more than once in an array of integers
 */
public class Main {

    public static void main(String[] args) {
        countNumsArrayList();
        countNumsArray();
    }

    private static void countNumsArray() {
        System.out.println("======================  METHOD: countNumsArray  ======================\n");
        int[] numArray = {1, 2, 2, 3, 4, 6, 3, 5, 3};

        HashMap<Integer, Integer> nums = new HashMap<>();

        for(int num : numArray){
            if(nums.containsKey(num))
                nums.put(num, nums.get(num) + 1);
            else{
                nums.put(num, 1);
            }
        }

        //System.out.println("TEST - The map is: " + nums);

        System.out.println("The numbers in the array that repeat are:");
        for(int n : nums.keySet()){
            if(nums.get(n) > 1)
                System.out.print(n + "\t");
        }
        System.out.println();

    }

    private static void countNumsArrayList() {
        System.out.println("\n======================  METHOD: countNumsArrayList  ======================\n");
        ArrayList<Integer> numList = new ArrayList<>();
        numList.add(1);
        numList.add(2);
        numList.add(5);
        numList.add(4);
        numList.add(4);
        numList.add(2);

        // System.out.println("TEST: " + numList);

        repeatingNums(numList);

    }

    private static void repeatingNums(ArrayList<Integer> numList){
        /*
        Create a HashMap to store each number and it's count, then iterate through the
        HashMap to see which number have a count > 1
         */
        HashMap<Integer, Integer> nums = new HashMap<>();

        for(int num : numList){
            if(nums.containsKey(num))
                nums.put(num, nums.get(num) + 1);
            else{
                nums.put(num, 1);
            }
        }

        //System.out.println("TEST - The map is: " + nums);

        System.out.println("The numbers in the array that repeat are:");
        for(int n : nums.keySet()){
            if(nums.get(n) > 1)
                System.out.print(n + "\t");
        }
        System.out.println();
    }
}
