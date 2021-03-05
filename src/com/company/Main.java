package com.company;


import java.lang.reflect.Executable;

public class Main {

    public static void main(String[] args) {



        try {
            Persistence persistence = new Persistence();
            // insert a new student into the table
            persistence.insertStudent("Carlos","Avalle");
            persistence.insertStudent("Alberto","Mandioni");
            persistence.insertStudent("Adam","Avalle");
            persistence.insertStudent("Aaron","Avalle");


            //list all students in the db
            System.out.println("List of Students in the system");
            for (Student s : persistence.listStudents()){
                System.out.println(s);

            }
        }catch (Exception e){
            System.out.println(e);

        }



    }
}
