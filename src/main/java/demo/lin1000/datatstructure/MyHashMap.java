package demo.lin1000.datatstructure;

import java.util.*;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class MyHashMap{

    public static void main(String[] args){

        HashMap<Integer, Student> studentMap = new HashMap<>();
        Stream<Student> studentStream = IntStream.rangeClosed(1,10).boxed().map(Student::new);
        studentStream.forEach(s->studentMap.put(s.getId(), s));

        studentMap.forEach((key,value)-> System.out.println(key + ":" + value.toString()));
    }

}

class Student {
    Integer id; 

    public Student(int id){
        setId(id);
    }

    public Integer getId(){
        return id;
    }

    public void setId(int id){
        this.id = Integer.valueOf(id);
    }

    public String toString(){
        return "Student "+ id;
    }
}