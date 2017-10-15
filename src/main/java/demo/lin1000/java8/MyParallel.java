package demo.lin1000.java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.OptionalInt;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import java.util.stream.DoubleStream;
import java.util.Comparator.*;

public class MyParallel{

    public static void main(String args[]){

        //Streams
        Stream<Long> tenNaturalNumbers = Stream.iterate(1L, n  ->  n  + 1).limit(10);
        tenNaturalNumbers.forEach(System.out::println);

        byte b= 'a';
        short s = 'a';
        int x = 'a';
        long l = 'a';
        
        double d = 'a';
        float f = 'a';
        char c = 'a';
        boolean bool = false;

        //primitive types
        System.out.println("byte="+b);
        System.out.println("short="+s);
        System.out.println("int="+x);
        System.out.println("long="+l);
        System.out.println("double="+d);
        System.out.println("float="+f);
        System.out.println("char="+c);
        System.out.println("bool="+bool);
        System.out.println("bool internal="+bool);

        //Arrays

        //List<int> intList = Arrays.asList(1,2,3,4,5); //compile error because of lack of value type in java, that means the generic type can only be reference type
        List<Integer> intList = Arrays.asList(1,2,3,4,5);

        //Stream<int> intStream = Stream.of(1); //compile error, because of lack of value type in java.
        Stream<Integer> intStream = Stream.of(1);

        //Arrays.parallelSetAll on int
        int values[] = new int[1000];
        Arrays.parallelSetAll(values, a->a);
        System.out.println("Arrays.binarySearch(values,999)="+ Arrays.binarySearch(values,999));


        //Arrays.parallelSetAll on double
        //Note: Arrays.parallelSetAll is only work for int[], long[], double[]
        //not support float[], boolean[] ... the reason behind is to reduce interface pollution and a trade off made by expert group
        double[] fvalues = new double[1000];
        Arrays.parallelSetAll(fvalues, a-> 1d);
     

        // Imperative way : Convert a double[] to Stream<Double> 
        List<Double> fList = new ArrayList<>();
        for(int i=0; i <fvalues.length;i++){
            fList.add(Double.valueOf(fvalues[i]));
        }

        System.out.println("fList.stream().reduce(1.0f,(acc, p)-> acc + p))="+
                            fList.stream().reduce(1.0d,(acc, p)-> acc + p));

        // Functional way : Convert a double[] to Stream<Double>        
        System.out.println("DoubleStream.of(fvalues).boxed().reduce(1.0d,(acc, p)-> acc + p)="+                    
        DoubleStream.of(fvalues).boxed()
                        //.peek((p)->System.out.println(p))
                        .reduce(1.0d,(acc, p)-> acc + p));
                            

    }
}