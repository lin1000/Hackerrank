package demo.lin1000.datatstructure;

import java.util.Arrays;

public class StringCompression{


    /*/
    Time Complexity : O(N)
    Space Complexity : O(N)
    //*/
    public String compress(String input){
        if(input == null || input == "") return input;
        StringBuffer sb =  new StringBuffer();
        
        char[] inputStr = input.toCharArray();
        //Arrays.sort(inputStr); //O(n long n) worst case

        char curr = inputStr[0];
        int currBegin = 0 ;
        for(int i =0 ; i < inputStr.length;i++){
            if(curr == inputStr[i]){               
                continue;   
            }else{

                sb.append(compressStrategy(curr, currBegin, i));
                currBegin = i;
                curr = inputStr[i];

                if(sb.length() > input.length()) return input;
            }
        }

        sb.append(compressStrategy(curr, currBegin, inputStr.length));

        return sb.toString();
    }

    private String compressStrategy(char c, int currBegin, int currI){
        int count = currI - currBegin;
        if(count >=2){
            return String.valueOf(c) + count;
        }else{
            return String.valueOf(c);
        }
    }

    public static void main(String[] args){

        String test1 = "abbbbcedddkallk";
        String test2 = "zzklaaabcdellkk";
        String test3 = "abcdefg";

        StringCompression s = new StringCompression();
        System.out.println("s.compress("+test1+")="+s.compress(test1));
        System.out.println("s.compress("+test2+")="+s.compress(test2));
        System.out.println("s.compress("+test3+")="+s.compress(test3));

    }
}