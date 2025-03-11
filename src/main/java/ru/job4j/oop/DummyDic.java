package ru.job4j.oop;

public class DummyDic {

    public static String engToRus(String eng) {
        return "Неизвестное слово. " + eng;
    }

    public static void main(String[] args) {
        DummyDic word = new DummyDic();
        String text = word.engToRus("popular");
        System.out.println(text);
    }
}