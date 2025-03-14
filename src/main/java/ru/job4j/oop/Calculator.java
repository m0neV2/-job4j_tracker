package ru.job4j.oop;

public class Calculator {

    private static int x = 5;

    public static int sum(int y) {
        return x + y;
    }

     public static int minus(int y) {
        return x - y;
     }

    public int multiply(int a) {
        return x * a;
    }

     public int divide(int y) {
        return y / 5;
     }

     public int sumAllOperation(int y) {
        return y + sum(10) + minus(5) + multiply(4) + divide(8);
     }

    public static void main(String[] args) {
        int result = Calculator.sum(10);
        Calculator calculator = new Calculator();
        int res1 = minus(5);
        int res2 = calculator.multiply(4);
        int res3 = calculator.divide(8);
        int res4 = calculator.sumAllOperation(0);
        System.out.println("Сумма: " + result);
        System.out.println("Разность: " + res1);
        System.out.println("Произведение: " + res2);
        System.out.println("Деление: " + res3);
        System.out.println("Сумма всех вычислений: " + res4);
    }
}