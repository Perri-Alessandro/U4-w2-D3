package Entities;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Hello world!");

        Product uno = new Product("LIBRO UNO", "BOOKS", 130);
        Product due = new Product("LIBRO CINQUE", "BOOKS", 98.7);
        Product tre = new Product("LIBRO TRE", "BOOKS", 179.41);
        Product quattro = new Product("LIBRO QUATTRO", "BOOKS", 68.20);
        Product cinque = new Product("LIBRO DUE", "BOOKS", 102.99);
        Product sei = new Product("BIBERON", "BABY", 22.4);
        Product sette = new Product("CULLA", "BABY", 160.88);
        Product otto = new Product("CIBO PER CANI", "ANIMALI", 42.80);
        Product nove = new Product("LEDGER NANO X", "SICUREZZA", 98.70);


        List<Product> books = new ArrayList<>();
        books.add(uno);
        books.add(due);
        books.add(tre);
        books.add(quattro);
        books.add(cinque);
        books.add(sei);
        books.add(sette);
        books.add(otto);
        books.add(nove);

        books.stream().filter(book -> book.category.equals("BOOKS") && book.price > 100).forEach(prod -> System.out.println(prod));
        sc.close();
    }
}