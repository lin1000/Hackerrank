package demo.lin1000.datatstructure;

import java.util.*;

public class ReplaceSpace{

    /*/
    Time Complexity : O (2N) --> O(N)
    Space Complexity : O(N)
    //*/       
    public String replaceSpace(char[] str, int length){

        int spaceCount = 0, newLength=1;
        for(int i = 0 ; i < length; i++){
            if(str[i] == ' ') spaceCount++;
        }

        newLength = length + 2*spaceCount;
        char[] newStr = Arrays.copyOf(str, newLength);
            
        for(int i=str.length-1; i>=0 ; i--){

            if(newStr[i] == ' '){
                newStr[newLength-1] = '0';
                newStr[newLength-2] = '2';
                newStr[newLength-3] = '%';
                newLength -= 3;
                
            }else{
                newStr[newLength-1] = newStr[i];
                newLength--;
            }
        }
        return new String(newStr);
    
        
    }

    public static void main(String[] args){

        String testa = "abckasdkfas;kldfjas;dfk'sapodfm.,ml  ;lk;k sd2222    as f asdf d";
        String ans = new ReplaceSpace().replaceSpace(testa.toCharArray(),testa.length());
        System.out.println("ans="+ ans);

        String testb = "http://localhost:2348/ abcd/ eskd f?query=ab&s   ";
        ans = new ReplaceSpace().replaceSpace(testb.toCharArray(),testb.length());
        System.out.println("ans="+ ans);        

    }

}