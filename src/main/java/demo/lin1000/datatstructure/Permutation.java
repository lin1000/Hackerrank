package demo.lin1000.datatstructure;

import java.util.*;

public class Permutation{

    /*/
    Time Complexity : Arrays.sort is O(n long n) in worst case. 
        O(n long n  + n ) - > O(n logn n)
    Space Complexity : O(N)
    //*/       
    public boolean isPermutation(String a, String b){
        
        if(a.length() != b.length())
            return false;

        char[] array = a.toCharArray();
        char[] brray = b.toCharArray();

        Arrays.sort(array);
        Arrays.sort(brray);

        System.out.println("array="+ Arrays.toString(array));
        System.out.println("brray="+ Arrays.toString(brray));
        return Arrays.equals(array,brray);
        
    }

    public static void main(String[] args){

        String testa = "abcasfasdfd";
        String testb = "bcdsafsadfa";

        boolean ans = new Permutation().isPermutation(testa,testb);
        System.out.println("ans="+ ans);

    }

}