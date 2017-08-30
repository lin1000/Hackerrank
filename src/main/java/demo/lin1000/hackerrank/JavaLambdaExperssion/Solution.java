package demo.lin1000.hackerrank.JavaLambdaExperssion;
import java.io.*;
import java.util.*;
interface PerformOperation {
 boolean check(int a);
}
class MyMath {
 public static boolean checker(PerformOperation p, int num) {
  return p.check(num);
 }

 public PerformOperation isOdd(){
    return (int x)->x%2==1;
}

public PerformOperation isPrime(){
    return (int x) -> java.math.BigInteger.valueOf(x).isProbablePrime(1);
}
   
public PerformOperation isPalindrome(){
    
    return n -> java.util.stream.IntStream.iterate(n, e -> e/10 )
                    .limit(11)
                    .filter(f -> f>0)
                    .map(e -> e%10)
                    .reduce(0, (c,e)->c*10+e)
                    == n;
}

}

public class Solution {
    
     public static void main(String[] args) throws IOException {
      MyMath ob = new MyMath();
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      int T = Integer.parseInt(br.readLine());
      PerformOperation op;
      boolean ret = false;
      String ans = null;
      while (T--> 0) {
       String s = br.readLine().trim();
       StringTokenizer st = new StringTokenizer(s);
       int ch = Integer.parseInt(st.nextToken());
       int num = Integer.parseInt(st.nextToken());
       if (ch == 1) {
        op = ob.isOdd();
        ret = ob.checker(op, num);
        ans = (ret) ? "ODD" : "EVEN";
       } else if (ch == 2) {
        op = ob.isPrime();
        ret = ob.checker(op, num);
        ans = (ret) ? "PRIME" : "COMPOSITE";
       } else if (ch == 3) {
        op = ob.isPalindrome();
        ret = ob.checker(op, num);
        ans = (ret) ? "PALINDROME" : "NOT PALINDROME";
    
       }
       System.out.println(ans);
      }
     }
    }
    