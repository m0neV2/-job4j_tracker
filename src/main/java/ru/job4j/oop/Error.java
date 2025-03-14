package ru.job4j.oop;

public class Error {

    private boolean active;
    private int status;
    private String message;

    public Error(boolean active, int status, String message) {
        this.active = active;
        this.status = status;
        this.message = message;
    }

    public Error() {
    }

    public void printInfo() {
        System.out.println(active);
        System.out.println(status);
        System.out.println(message);
    }

    public static void main(String[] args) {
        Error defaultError = new Error();
        defaultError.printInfo();
        Error error = new Error(true, 10, "Unknown");
        Error error1 = new Error(true, 500, "work");
        Error error2 = new Error(false, 200, "Unknown");
        error.printInfo();
        System.out.println();
        error1.printInfo();
        System.out.println();
        error2.printInfo();
    }
}