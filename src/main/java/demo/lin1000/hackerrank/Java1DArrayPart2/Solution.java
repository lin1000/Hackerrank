package demo.lin1000.hackerrank.Java1DArrayPart2;

import java.util.*;
import java.util.stream.*;

public class Solution {
    
    static boolean debug = false;
    
    public static boolean canWin(int leap, int[] game) {
        // Return true if you can win the game; otherwise, return false.
        int c = 0;
        int step = 1;
        boolean step_back = false;
        while(true){
            int jump = c+leap;
            int next = c+step;
            int prev = c-step;
            if(leap == 0 ) jump = c + step;
            if(next == game.length) return true;
            if(jump >= game.length) return true;
            else if(game[jump]==0 && leap!=0){
                if(debug) System.out.println("jump");
                step_back = false;
                c = jump;
                continue;
            }else if(game[next]==0 && !step_back){
                if(debug) System.out.println("next");
                step_back = false;                
                c = next;
                continue;
            }else if(prev >0 && game[prev]==0){
                if(debug) System.out.println("prev");
                step_back = true;
                c = prev;
                continue;
            }
            else{
                if(debug){
                    System.out.println("leap " + leap);                
                    Arrays.stream(game).forEach(System.out::print);
                }
                return false;
            }
        }
       
    }
    
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int q = scan.nextInt();
        while (q-- > 0) {
            int n = scan.nextInt();
            int leap = scan.nextInt();
            
            int[] game = new int[n];
            for (int i = 0; i < n; i++) {
                game[i] = scan.nextInt();
            }

            System.out.println( (canWin(leap, game)) ? "YES" : "NO" );
        }
        scan.close();
    }
}
