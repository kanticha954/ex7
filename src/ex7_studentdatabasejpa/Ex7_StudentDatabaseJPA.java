/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ex7_studentdatabasejpa;

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
       Student stu1 = new Student(1, "John", 12345.0);
       Student stu2 = new Student(2, "Marry", 45678.0);
       StudentTable.insertStudent(stu1); 
       StudentTable.insertStudent(stu2);
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
