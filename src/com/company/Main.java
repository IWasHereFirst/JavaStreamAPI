package com.company;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {

        // 1
        System.out.println("1.\n" + Stream.iterate(1, a -> a + 1)
                .limit(10000)
                .filter(a -> a % 3 == 0 && a % 5 == 0 && a % 7 != 0)
                .mapToInt(a -> a).sum());

        // 2
        System.out.println("\n2.");
        Stream.iterate(1, a -> a + 1)
                .filter(a -> a % 2 == 0 && a % 8 != 0)
                .limit(100)
                .forEach(a -> System.out.print(a + " "));

        // 3 Sample data
        List<Book> list = new ArrayList<>();
        list.add(new Book("Damned", 99));
        list.add(new Book("Damned part two", 98));
        list.add(new Book("Damned part three", 102));
        list.add(new Book("Damned the whole glory trilogy", 150));
        list.add(new Book("Jerry1", 15));
        list.add(new Book("Jerry2", 150));
        list.add(new Book("Tom1", 12));
        list.add(new Book("Tom2", 120));
        list.add(new Book("Motorbike encyclopedia", 501));

        // 3.1
        System.out.println("\n\n3.1");
        list.stream()
                .filter(a -> a.price < 100)
                .sorted(Comparator.comparing(Book::getName))
                .forEach(a -> System.out.println(a.name));

        // 3.2
        System.out.println("\n3.2:\n" + list.stream()
                .filter(a -> a.name.length() < 5)
                .count());

        // 3.3
        System.out.println("\n3.3");
        list.stream()
                .mapToDouble(Book::getPrice).average()
                .ifPresent(System.out::println);

        // 3.4
        System.out.println("\n3.4\n" + (list.stream()
                .allMatch(a -> a.price < 500) ? "\u001b[32mtrue" : "\u001b[31mfalse"));
    }

    static class Book {

        public Book(String name, Integer price) {
            this.name = name;
            this.price = price;
        }

        private String name;

        private Integer price;

        public String getName() {
            return this.name;
        }

        public Integer getPrice() {
            return this.price;
        }
    }

}
