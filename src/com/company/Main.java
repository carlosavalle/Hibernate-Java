package com.company;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import java.util.Iterator;
import java.util.List;

public class Main {
private static  SessionFactory factory;
    public static void main(String[] args) {
        final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                .configure()
                .build();
        try {
           factory = new MetadataSources(registry)
                    .buildMetadata().buildSessionFactory();
            Session session = factory.openSession();
            Transaction transaction = session.beginTransaction();

            Student student = new Student();
            student.setFirstName("Albert");
            student.setLastName("Mandioni");

            session.save(student);

            transaction.commit();


            listStudents();
            session.close();
            factory.close();

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            ex.printStackTrace();
            StandardServiceRegistryBuilder.destroy(registry);
        }

    }
    public static void listStudents(){
        Session session = factory.openSession();
        Transaction tx = null;

        try {
            tx = session.beginTransaction();
            List employees = session.createQuery("FROM Student ").list();
            for (Iterator iterator = employees.iterator(); iterator.hasNext();){
                Student student = (Student) iterator.next();
                System.out.println("");
                System.out.println("Student_ID: " + student.getId());
                System.out.println("First Name: " + student.getFirstName());
                System.out.println("  Last Name: " + student.getLastName());
                System.out.println();

            }
            tx.commit();
        } catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

}
