package ru.job4j.pojo;

public class Library {

    public static void main(String[] args) {
        Book book = new Book("War and piece", 10);
        Book book1 = new Book("Clean code", 120);
        Book book2 = new Book("Naruto", 736);
        Book book3 = new Book("One piece", 1150);

        Book[] books = new Book[4];
        books[0] = book;
        books[1] = book1;
        books[2] = book2;
        books[3] = book3;
        System.out.println("Вывод книг: ");
        for (int i = 0; i < books.length; i++) {
            Book title = books[i];
            System.out.println(title.getName() + " - " + title.getCount());
        }

        Book temp;
        temp = books[0];
        books[0] = books[3];
        books[3] = temp;

        System.out.println();
        System.out.println("Вывод книг после перестановки: ");
        for (int i = 0; i < books.length; i++) {
            Book title = books[i];
            System.out.println(title.getName() + " - " + title.getCount());
        }

        System.out.println();
        System.out.println("Вывод книг с именем Clean code: ");
        for (int i = 0; i < books.length; i++) {
            Book title = books[i];
            if ("Clean code".equals(title.getName())) {
                System.out.println(title.getName() + " - " + title.getCount());
            }
        }
    }
}