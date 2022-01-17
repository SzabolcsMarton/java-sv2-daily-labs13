package day01;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class ClassNotebookTest {

    @Test
    void  addStudentTest(){
        ClassNotebook classNotebook = new ClassNotebook();

        Student student = new Student(1, "Sanyi");
        classNotebook.addStudent(student);

        assertTrue(classNotebook.getStudentsWithMark().keySet().contains(student));
        assertEquals(0, classNotebook.getStudentsWithMark().get(student).size());
    }

    @Test
    void addStudentInOrderTest() {
        ClassNotebook classNotebook = new ClassNotebook();

        Student student = new Student(1, "Sanyi");
        Student student2 = new Student(3, "Pisti");
        Student student3 = new Student(2, "Bela");
        classNotebook.addStudent(student);
        classNotebook.addStudent(student2);
        classNotebook.addStudent(student3);

        assertEquals(List.of(student,student3,student2),new ArrayList<>(classNotebook.getStudentsWithMark().keySet()));

        int i = 1;
        for (Map.Entry<Student, List<Integer>> actual : classNotebook.getStudentsWithMark().entrySet()){
            assertEquals(i,actual.getKey().getId());
            i++;
        }
    }
    @Test
    void addMarkTest(){
        ClassNotebook classNotebook = new ClassNotebook();

        Student student = new Student(1, "Sanyi");
        Student student2 = new Student(3, "Pisti");
        Student student3 = new Student(2, "Bela");
        classNotebook.addStudent(student);
        classNotebook.addStudent(student2);
        classNotebook.addStudent(student3);

        classNotebook.addMark(2,5);

        assertEquals(5, classNotebook.getStudentsWithMark().get(student3).get(0));
    }


}