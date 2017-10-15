package demo.lin1000.datatstructure;


import java.util.Arrays;
import java.util.function.Function;
import java.util.stream.Stream;
import java.util.stream.IntStream;
import java.util.Optional;
import java.util.Comparator;
import javax.sound.sampled.BooleanControl;

public class UniqueCharacter{

    /*/
    Time Complexity : O(N), depends on the input length of the string
    Space Complexity : O(1) , only used a 256 size array, which is a constant.
    //*/
    public boolean solve(String input){

        boolean[] isUsed = new boolean[256];
        Arrays.fill(isUsed,false);
        
        for(int i=0; i < input.length(); i++){
            char c = input.charAt(i);
            if(isUsed[c]==true){
                return false;
            }else{
                isUsed[c] = true;
            }  
        }
        return true;
    }

    /*/
    Time Complexity : O(N), depends on the input length of the string
    Space Complexity : O(1) , only used a 256 size array, which is a constant.
    //*/    
    public boolean solve2(String input){
        
                int[] isUsed = new int[256];
                Arrays.fill(isUsed,0);
                
                Stream<Integer> intStream = Arrays.stream(isUsed).boxed();
                Stream<Character> charStream =  IntStream.range(0, input.toCharArray().length).mapToObj(i->input.charAt(i));


                Optional<Integer> opInt = charStream.map(i->++isUsed[i]).max(Comparator.comparingInt(i->i));
                intStream.forEachOrdered(System.out::print);                
                
                Integer ret = opInt.orElse(Integer.valueOf(1));
                
                return ret==1? true: false;
            }    

    public static void main(String[] args){
        UniqueCharacter t = new UniqueCharacter();
        
        String test = "asdflkj\u00ea";
        System.out.println("t.solve(\""+test+"\")=" +t.solve(test));
        System.out.println("t.solve2(\""+test+"\")=" +t.solve2(test));

        /*
        solve better than solve2 
        //*/

    }

}