package org.kemetkoder.astevens;

public class Main {

    public static void main(String[] args) {
        int orchard[] = {6, 1, 4, 6, 3, 2, 7, 4};   // sample array for testing
        int K = 3;
        int L = 2;

        System.out.println("Maximum apples picked is " + MaxApples(orchard, K, L));
    }

    private static int MaxApples(int[] orchard, int aliceTrees, int bobTrees) {
        int sum = 0;
        int picked = 0; //number of apples picked
        int aliceMax = 0;
        int bobMax = 0;

        if((aliceTrees + bobTrees) > orchard.length){
            sum = -1;
        }
        if((aliceTrees + bobTrees) == orchard.length){
            // take the sum of the elements in the array
            for(int i = 0; i < orchard.length; i++)
                sum += orchard[i];
        }
        if((aliceTrees + bobTrees) < orchard.length){
            // TODO: Get the max apples picked by Alice
            for(int i = 0; i < orchard.length; i++){
                for(int j = i + 1; j < aliceTrees; j++){
                    picked += orchard[j];
                    if(picked > aliceMax)
                        aliceMax = picked;
                }
            }

            // TODO: Get the max apples picked by Bob
            for(int i = 0; i < orchard.length; i++){
                for(int j = i + 1; j < bobTrees; j++){
                    picked += orchard[j];
                    if(picked > bobMax)
                        bobMax = picked;
                }
            }

            // TODO: return the max_alice + max_bob
            sum = aliceMax + bobMax;
        }

        return sum;
    }
}
