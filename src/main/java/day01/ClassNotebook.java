package day01;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class ClassNotebook {

    private Map<Student, List<Integer>> studentsWithMark = new TreeMap<>();

    public void addStudent(Student student){
        studentsWithMark.put(student,new ArrayList<>());
    }

    public void addMark(int id, int mark){
        for(Map.Entry<Student, List<Integer>> actual : studentsWithMark.entrySet()){
            if(actual.getKey().getId() == id){
                actual.getValue().add(mark);
            }
        }
    }

    public Map<Student, List<Integer>> getStudentsWithMark() {
        return studentsWithMark;
    }
}
