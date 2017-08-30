package demo.lin1000.hackerrank.BufferedReader;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.Collectors;
import java.util.stream.Stream;
 
public class Solution {
 
	public static void main(String[] args) {
		// java 7:try with resources
		System.out.println(System.getProperty("user.dir"));
		
		try(BufferedReader reader = new BufferedReader(new InputStreamReader( Solution.class.getClassLoader().getResourceAsStream("BufferedReader/myapplication.log")))) {
 
		Stream<String> stream = reader.lines();
		Stream<String> stream1 = stream.filter(line -> line.contains("INFO")).map(s -> s.replace("INFO","TONY"));
		stream1.forEach(x -> System.out.println(x) );
								//   .findFirst()
		                        //   .ifPresent(System.out::println);
 
		} catch(IOException ioe ){
		 ioe.printStackTrace();
		}
   }
 
}
