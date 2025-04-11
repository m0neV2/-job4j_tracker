package ru.job4j.oop;

public class College {
    public static void main(String[] args) {
        Freshman freshman = new Freshman(); // Создаём объект Freshman

        // Приведение Freshman → Student (Upcasting)
        Student student = freshman;

        // Приведение Student → Object (Upcasting)
        Object obj = student;
    }
}