package Entities;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);


        Product uno = new Product("LIBRO UNO", "BOOKS", 130);
        Product due = new Product("LIBRO CINQUE", "BOOKS", 98.7);
        Product tre = new Product("LIBRO TRE", "BOOKS", 179.41);
        Product quattro = new Product("LIBRO QUATTRO", "BOOKS", 68.20);
        Product cinque = new Product("LIBRO DUE", "BOOKS", 102.99);
        Product sei = new Product("BIBERON", "BABY", 22.4);
        Product sette = new Product("CULLA", "BABY", 160.88);
        Product otto = new Product("CIBO PER CANI", "ANIMALI", 42.80);
        Product nove = new Product("LEDGER NANO X", "SICUREZZA", 98.70);
        Product dieci = new Product("GIOCO BABY", "BABY", 26.40);
        Product undici = new Product("BOXER", "BOYS", 8.20);
        Product dodici = new Product("XXX", "BOYS", 22.4);

        Customer a = new Customer("GIOVANNI");
        Customer b = new Customer("GIACOMO");
        Customer c = new Customer("ALDO");

        Order primo = new Order("ORDINE IN TRANSITO", a, sette, LocalDate.now(), LocalDate.of(2024, 05, 22));
        Order secondo = new Order("ESEGUITO", b, otto, LocalDate.of(2024, 02, 24), LocalDate.now());
        Order terzo = new Order("ESEGUITO", a, sei, LocalDate.of(2024, 02, 24), LocalDate.now());
        Order quarto = new Order("ORDINE IN TRANSITO", c, uno, LocalDate.now(), LocalDate.of(2024, 04, 02));


        List<Product> all = new ArrayList<>();
        all.add(uno);
        all.add(due);
        all.add(tre);
        all.add(quattro);
        all.add(cinque);
        all.add(sei);
        all.add(sette);
        all.add(otto);
        all.add(nove);
        all.add(dieci);
        all.add(undici);
        all.add(dodici);

        List<Order> orders = new ArrayList<>();
        orders.add(primo);
        orders.add(secondo);
        orders.add(terzo);
        orders.add(quarto);

        System.out.println("PRODOTTI IN CATEGORIA BOOK CON PREZZO MAGGIORE DI DIECI:");
        all.stream().filter(book -> book.category.equals("BOOKS") && book.price > 100).forEach(prod -> System.out.println(prod));

        System.out.println("ORDINI CON PRODOTTI DA CATEGORIA BABY:");
        orders.stream().filter(order -> order.getProduct().category.equals("BABY")).forEach(System.out::println); //ForEach stampa gli ordini filtrati

        System.out.println("PRODOTTI IN CATEGORIA BOYS CON SCONTO 10%:");
        all.stream().filter(boy -> boy.category.equals("BOYS")).forEach(product -> {
            double prezzoScontato = product.price - (product.price * 0.1);
            System.out.println(product + " NEW PRICE: " + prezzoScontato);
        });


        System.out.println("LISTA DI PRODOTTI ORDINATI DA CLIENTI TIER 2 TRA 01/02/2021 E 01/04/2021:");
        orders.stream().filter(ord -> ord.getCustomer().getTier() == 2).filter(date -> !date.getOrderDate().isBefore(LocalDate.of(2021, 02, 01)) && !date.getOrderDate().isAfter(LocalDate.of(2021, 04, 01))).forEach(System.out::println);

        sc.close();
    }
}