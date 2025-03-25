package ru.job4j.pojo;

import java.util.Date;

public class College {

    public static void main(String[] args) {
        Student student = new Student();
        student.setName("Salahov Sadih");
        student.setGroup(3403);
        student.setEnter(new Date());

        System.out.println("Student name: " + student.getName()
               + System.lineSeparator() + "Student group: " + student.getGroup()
               + System.lineSeparator() + "When he entered: " + student.getEnter());
    }
}
