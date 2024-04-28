import org.apache.commons.io.FileUtils;

import javax.swing.plaf.PanelUI;
import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

public class Esercizio {


    public static void main(String[] args) {
        //lista clienti
        Customer cliente1 = new Customer(123L, "Rossi Mario", 2);
        Customer cliente2 = new Customer(153L, "Bianchi Aldo", 2);
        Customer cliente3 = new Customer(253L, "Verdi Maria", 2);
        List<Customer> listaClienti = List.of(cliente1, cliente2, cliente3);

        //lista prodotti
        Product p1 = new Product(1234L, "Java Avanzato", "Books", 25.0);
        Product p2 = new Product(2347L, "Javascript, Css, HTML", "Books", 135.0);
        Product p3 = new Product(334L, "Tutina con animaletti", "Baby", 15.0);
        Product p4 = new Product(447L, "Lego. I pompieri", "Baby", 35.0);
        Product p5 = new Product(534L, "Skateboard", "Boys", 55.0);
        Product p6 = new Product(647L, "Cellulare Samsung", "Boys", 335.0);
        List<Product> listaProdotti = List.of(p1, p2, p3, p4, p5, p6);

        //lista ordini
        Order ordine1 = new Order(124L, "consegnato", LocalDate.of(2020, 05, 01),
                LocalDate.of(2020, 05, 05),
                List.of(p1, p2),
                cliente1);

        Order ordine2 = new Order(128L, "spedito", LocalDate.of(2021, 02, 01),
                LocalDate.of(2021, 02, 05),
                List.of(p3, p4),
                cliente2);

        Order ordine3 = new Order(136L, "spedito", LocalDate.of(2021, 04, 01),
                LocalDate.of(2021, 04, 05),
                List.of(p5, p6),
                cliente3);
        List<Order> listaOrdini = List.of(ordine1, ordine2, ordine3);

        //Esercizio1
        System.out.println("Esercizio 1");
        Map<Customer, List<Order>> m1 = listaOrdini.stream().collect(Collectors.groupingBy(Order::getCustomer));
        m1.forEach((customer, orders) -> System.out.println(customer + " -> " + orders));

        //Esercizio2
        System.out.println("Esercizio 2");
        Map<Customer, Double> m2 = listaOrdini.stream()
                .collect(Collectors.groupingBy(Order::getCustomer, Collectors.summingDouble(value -> value.getProducts().stream()
                        .mapToDouble(Product::getPrice).sum())));
        m2.forEach((customer, aDouble) -> System.out.println(customer + " -> " + aDouble));

        //Esercizio3
        System.out.println("Esercizio 3");
        Map<String, Optional<Product>> m3 = listaProdotti.stream().collect(Collectors.groupingBy(Product::getCategory,
                Collectors.maxBy(Comparator.comparingDouble(Product::getPrice))));
        m3.forEach(((s, product) -> System.out.println(s + " -> " + product)));

        //Esercizio4
        System.out.println("Esercizio 4");
        Double media = listaOrdini.stream().collect(Collectors.averagingDouble(order -> order.getProducts().stream()
                .mapToDouble(Product::getPrice).sum()));
        System.out.println("Media ordini: " + media);

        //Esercizio5
        System.out.println("Esercizio 5");
        Map<String, Double> m5 = listaProdotti.stream().collect(Collectors.groupingBy(Product::getCategory,
                Collectors.summingDouble(p -> p.getPrice())));
        m5.forEach((cat, prezzo) -> System.out.println(cat + " -> " + prezzo));

        //[EXTRA] Esercizio6
        salvaProdottiSuDisco(listaProdotti);

        //[EXTRA] Esercizio7
        leggiProdottiDaDisco();

    }

    public static void salvaProdottiSuDisco(List<Product> listaProdotti) {

        File file = new File("./../prodotti.txt");

        String lista = listaProdotti.stream()
                .map(p -> p.getId() + "@" +
                        p.getName() + "@" +
                        p.getCategory() + "@" +
                        p.getPrice())
                .collect(Collectors.joining("#"));

        try {
            FileUtils.writeStringToFile(file, lista, Charset.defaultCharset());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        System.out.println("Stampa prodotti salvati su disco");
        listaProdotti.forEach(System.out::println);
        System.out.println();
    }

    public static void leggiProdottiDaDisco() {

        File file = new File("./../prodotti.txt");
        List<Product> lista= new ArrayList<>();

        try {
            String data = FileUtils.readFileToString(file, Charset.defaultCharset());

            lista = Arrays.stream(data.split("#"))
                    .map(record -> {
                        String[] campo = record.split("@");
                        return new Product(Long.parseLong(campo[0]),
                                campo[1],
                                campo[2],
                                Double.parseDouble(campo[3])
                        );
                    })
                   .collect(Collectors.toList());


        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        System.out.println("Stampa prodotti letti da disco");
        lista.forEach(System.out::println);
    }
}