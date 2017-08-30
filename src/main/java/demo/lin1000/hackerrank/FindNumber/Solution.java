package demo.lin1000.hackerrank.FindNumber;
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
import java.util.stream.*;

public class Solution {

    /*
    * Complete the function below.
    */

    static String findNumber(int[] arr, int k) {
        
        Stream<Boolean> stream = Arrays.stream(arr).mapToObj(x->x==k);
        stream.filter(x->Boolean.valueOf(x).equals(Boolean.TRUE)).findFirst().ifPresent(System.out::println);
        return "test";
    }

    public static void main(String[] args) throws IOException{
        Scanner in = new Scanner(System.in);
        final String fileName = System.getProperty("OUTPUT_PATH");
        System.out.println(fileName);
        BufferedWriter bw = new BufferedWriter(new FileWriter(fileName));
        String res;
        
        int _arr_size = 0;
        _arr_size = Integer.parseInt(in.nextLine().trim());
        int[] _arr = new int[_arr_size];
        int _arr_item;
        for(int _arr_i = 0; _arr_i < _arr_size; _arr_i++) {
            _arr_item = Integer.parseInt(in.nextLine().trim());
            _arr[_arr_i] = _arr_item;
        }
        
        int _k;
        _k = Integer.parseInt(in.nextLine().trim());
        
        res = findNumber(_arr, _k);
        bw.write(res);
        bw.newLine();
        bw.close();
    }
}    