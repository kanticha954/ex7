/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ex7_studentdatabasejpa;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author ASUS
 */
public class Ex7_StudentDatabaseJPA {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        ///*insert
       Student stu1 = new Student(1, "John", 4.0);
       Student stu2 = new Student(2, "Marry", 3.25);
       StudentTable.insertStudent(stu1); 
       StudentTable.insertStudent(stu2);
        //*/
        
        
       /*Updaate / remove
        Student stu;
        stu = StudentTable.findStudentById(1);
       if (stu != null) {
           stu.setName("Jack");
           //StudentTable.removeStudent(stu);
           StudentTable.updateStudent(stu);
       }
       */
       List<Student> stuList = StudentTable.findAllStudent();
       printAllStudent(stuList);
        
    }
    
    public static void printAllStudent(List<Student> StudentList) {
        for(Student stu : StudentList) {
           System.out.print(stu.getId() + " ");
           System.out.print(stu.getName() + " ");
           System.out.println(stu.getGpa() + " ");
       }
    }
    

    public static void persist(Object object) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ex7_StudentDatabaseJPAPU");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        try {
            em.persist(object);
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
    }
    
}
