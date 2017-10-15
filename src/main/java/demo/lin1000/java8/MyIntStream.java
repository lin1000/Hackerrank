package demo.lin1000.java8;

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
import java.util.Comparator.*;

public class MyIntStream{

    public static void main(String args[]){


        //IntStream.range
        //IntTream.range return value is a IntStream
        List<Integer> intList = IntStream.range(0,1000).map(x->x).boxed().collect(Collectors.toList());
        intList.forEach(System.out::print);
        System.out.println("");

        //IntStream.range
        List<Integer> intList2 = IntStream.range(0,1000).boxed().map(x->x).collect(Collectors.toList());
        intList2.forEach(System.out::print);
        System.out.println("");

        //IntStream.concat
        //forEachOrdered
        //forEach -- not ordered
        IntStream.concat(IntStream.range(0,5),IntStream.range(0,5)).boxed().forEachOrdered(System.out::print);
        System.out.println("");
        IntStream.concat(IntStream.range(0,5),IntStream.range(0,5)).boxed().forEach(System.out::print);
        System.out.println("");

        //IntSteram builder
        int sum = IntStream.builder().add(10).add(10).build().sum();
        System.out.println(sum);
        System.out.println("");

        //IntStream.generate to generate a infinite list of ints and use limit to limit it
        IntStream randomIntStream = IntStream.generate(() -> Double.valueOf(Math.random()*100).intValue()).limit(10);
        randomIntStream.forEach(System.out::print);
        //System.out.println("Math.random()="+  Double.valueOf(Math.random()*100).intValue());
        System.out.println("");

        //Reduction operation , findFirst which return optionalInt
        OptionalInt one = IntStream.generate(() -> Double.valueOf(Math.random()*100.0).intValue()).peek((x)->System.out.println(x + "peek")).limit(10).distinct().findFirst();        
        System.out.println("");

        //Reduction operation , sum()
        int summary = IntStream.generate(() -> Double.valueOf(Math.random()*100.0).intValue()).peek((x)->System.out.println(x + "peek")).limit(10).distinct().sum();        
        System.out.println("summary=" + summary);

        //Reduction operation, summaryStatistics
        IntStream notReuse = IntStream.generate(() -> Double.valueOf(Math.random()*100.0).intValue()).peek((x)->System.out.println(x + "peek")).limit(10).distinct();        
        IntSummaryStatistics intSummaryStat =notReuse.summaryStatistics();        
        System.out.println(intSummaryStat);
    
        // java.lang.IllegalStateException: stream has already been operated upon or closed
        //notReuse.forEach(System.out::print);

        //Reduction operation, averagingInt
        Double avg = IntStream.range(0,1000).boxed().collect(Collectors.averagingInt(Integer::intValue));
        System.out.println("avg="+avg);        


        //Partition By Colletors.paritioningBy
        Map<Boolean,List<Integer>> partitionList = IntStream.range(0,100).boxed().collect(Collectors.partitioningBy(x->x.intValue()%2==0));
        System.out.println("partitionList="+partitionList);                

        //Group By Colletors.groupingBy
        Map<Integer,List<Integer>> groupingList = IntStream.range(0,100).boxed().collect(Collectors.groupingBy(x->Integer.valueOf(x.intValue()%10)));
        System.out.println("groupingList="+groupingList);   

        //Group By Colletors.groupingBy coutning
        Map<Integer,Long> groupingListCount = IntStream.range(0,99).boxed().collect(Collectors.groupingBy(x->Integer.valueOf(x.intValue()%10), Collectors.counting()));
        System.out.println("groupingListCount="+groupingListCount   );           

        //Group By Colletors.groupingBy mapping
        Map<Integer,List<String>> groupingLisOfList = IntStream.range(0,99).boxed().collect(Collectors.groupingBy(x->Integer.valueOf(x.intValue()%10), Collectors.mapping(x->{
            return ((Integer) x).toBinaryString(x);
        }, Collectors.toList())));
        System.out.println("groupingLisOfList="+groupingLisOfList);                   

        //Group By Colletors.joining
        String result = IntStream.range(0,10).boxed().map(String::valueOf).collect(Collectors.joining(",","{","}"));
        System.out.println("result="+result);           

        
        //ordering
        for(Entry<Integer,List<Integer>> entry: groupingList.entrySet()){
            Integer key = entry.getKey();
            List<Integer> value =entry.getValue();
            String valueResult = value.stream()
                                        .sorted(Comparator.comparing(Integer::intValue).reversed().thenComparing(Integer::doubleValue))
                                        .sorted((x,y)-> Double.compare(-x, -y))
                                        .map(String::valueOf)                                        
                                        .collect(Collectors.joining(",","<<",">>"));
            System.out.println(valueResult);

        }

        //Java.lang.IllegalStateException: stream has already been operated upon or closed
        //Same stream operated twice will haave the error

    }
}