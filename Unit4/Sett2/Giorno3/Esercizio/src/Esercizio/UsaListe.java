package Esercizio;


import java.time.LocalDate;
import java.time.chrono.ChronoLocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class UsaListe {

    public static void main(String[] args) {

        //lista clienti
        Customer cliente1 = new Customer(123L, "Rossi Mario", 2);
        Customer cliente2 = new Customer(153L, "Bianchi Aldo", 2);
        Customer cliente3 = new Customer(253L, "Verdi Maria", 2);
        List<Customer> listaClienti = List.of(cliente1, cliente2, cliente3);

        //lista prodotti
        Product p1 = new Product(1234L, "Java Avanzato", "Books", 25.44);
        Product p2 = new Product(2347L, "Javascript, Css, HTML", "Books", 135.4);
        Product p3 = new Product(334L, "Tutina con animaletti", "Baby", 15.23);
        Product p4 = new Product(447L, "Lego. I pompieri", "Baby", 35.14);
        Product p5 = new Product(534L, "Skateboard", "Boys", 55.80);
        Product p6 = new Product(647L, "Cellulare Samsung", "Boys", 335.98);
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


        //esercizio 1---------------------------------------------------------------------------------------------------
        System.out.println();
        System.out.println("Esercizio1");
        List<Product> listaEsercizio1 = listaProdotti.stream()
                .filter(p -> p.getCategory() == "Books" && p.getPrice() > 100)
                .toList();
        listaEsercizio1.forEach(product -> System.out.println(product));

        //esercizio 2---------------------------------------------------------------------------------------------------
        System.out.println();
        System.out.println("Esercizio2");

//      List<Order> l2 = listaOrdini.stream()
//              .filter(o -> {
//                  List<Product> lstProd = o.getProducts().stream()
//                          .filter(p -> p.getCategory() == "Baby").toList();
//                  return !lstProd.isEmpty();
//              }).toList();
//      l2.forEach(o -> System.out.println(o));

        List<Order> l2 = listaOrdini.stream()
                .filter(o -> o.getProducts()
                        .stream()
                        .anyMatch(p -> p.getCategory() == "Baby")
                ).toList();
        l2.forEach(o -> System.out.println(o));


        //esercizio 3
        System.out.println();
        System.out.println("Esercizio3");
        List<Product> listaEsercizio3 = listaProdotti.stream().filter(p -> p.getCategory() == "Boys").
                peek(p -> p.setPrice(p.getPrice() * 0.9)).toList();
        listaEsercizio3.forEach(p -> System.out.println(p));

        //esercizio 4
        System.out.println();
        System.out.println("Esercizio4");
        List<Product> listaEsercizio4 = listaOrdini.stream()
                .filter(order -> order.getCustomer().getTier() == 2 &&
                                 order.getOrderDate().isAfter(LocalDate.of(2021, 1, 31)) &&
                                 order.getOrderDate().isBefore(LocalDate.of(2021, 4, 2)))
                .flatMap(order -> order.getProducts().stream())
                .collect(Collectors.toList());
        listaEsercizio4.forEach(System.out::println);
    }
}
