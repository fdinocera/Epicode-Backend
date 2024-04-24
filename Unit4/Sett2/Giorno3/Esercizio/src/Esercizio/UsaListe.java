package Esercizio;

import java.time.LocalDate;
import java.time.chrono.ChronoLocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class UsaListe {


    public static void main(String[] args) {

        //lista clienti
        List<Customer> listaClienti = new ArrayList<>();
        listaClienti.add(new Customer(123L, "Rossi Mario", 4));
        listaClienti.add(new Customer(153L, "Bianchi Aldo", 3));
        listaClienti.add(new Customer(253L, "Verdi Maria", 3));

        //prodotti
        List<Product> listaProdotti = new ArrayList<>();
        Product p1 = new Product(1234L, "Java Avanzato", "Books", 25.44);
        Product p2 = new Product(1347L, "Javascript, Css, HTML", "Books", 135.4);
        Product p3 =new Product(234L, "Tutina con animaletti", "Baby", 15.23);
        Product p4 =new Product(147L, "Lego. I pompieri", "Baby", 35.14);
        Product p5 =new Product(234L, "Skateboard", "Boys", 55.80);
        Product p6 =new Product(147L, "Cellulare Samsung", "Boys", 335.98);

        listaProdotti.add(p1);
        listaProdotti.add(p2);
        listaProdotti.add(p3);
        listaProdotti.add(p4);
        listaProdotti.add(p5);
        listaProdotti.add(p6);



//        listaProdotti.add(new Product(1234L, "Java Avanzato", "Books", 25.44));
//        listaProdotti.add(new Product(1347L, "Javascript, Css, HTML", "Books", 135.4));
//        listaProdotti.add(new Product(234L, "Tutina con animaletti", "Baby", 15.23));
//        listaProdotti.add(new Product(147L, "Lego. I pompieri", "Baby", 35.14));
//        listaProdotti.add(new Product(234L, "Skateboard", "Boys", 55.80));
//        listaProdotti.add(new Product(147L, "Cellulare Samsung", "Boys", 335.98));


        //liste prodotti
        List<Product> lista1 = new ArrayList<>();
        lista1.add(p1);
        lista1.add(p2);

        List<Product> lista2 = new ArrayList<>();
        lista1.add(p3);
        lista1.add(p4);

        List<Product> lista3 = new ArrayList<>();
        lista1.add(p5);
        lista1.add(p6);




        //lista ordini
        List<Order> listaOrdini = new ArrayList<>();
        listaOrdini.add(new Order(124L, "consegnato", LocalDate.of(2020, 05, 01),
                LocalDate.of(2020, 05, 05),
                lista1 ,
                listaClienti.get(0)));

        listaOrdini.add(new Order(128L, "spedito", LocalDate.of(2020, 06, 01),
                LocalDate.of(2020, 06, 05),
                lista2,
                listaClienti.get(1)));





        //esercizio 1---------------------------------------------------------------------------------------------------
        List<Product> listaEsercizio1 = getProdottiBooks(listaProdotti);
        for (Product p : listaEsercizio1) {
            stampaProdotto(p);
        }

        //esercizio 2
        //getListaOrdini(listaOrdini);

        //esercizio 3
        List<Product> listaEsercizio3 = getProdottiBoys(listaProdotti);
        for (Product p : listaEsercizio3) {
            stampaProdotto(p);
        }




    }

    public static void stampaProdotto(Product p) {
        System.out.println("----------------------------------------------");
        System.out.println("Id prodotto: " + p.getId());
        System.out.println("Descrizione: " + p.getName());
        System.out.println("Categoria: " + p.getCategory());
        System.out.println("Prezzo: " + p.getPrice());
        System.out.println("----------------------------------------------");
        System.out.println();
    }

    public static List<Product> getProdottiBooks(List<Product> lista) {
        return lista.stream()
                .filter(l -> (l.getCategory() == "Books" && l.getPrice() > 100))
                .collect(Collectors.toList());
    }

//    public static List<Order> getListaOrdini (List<Order> listaOrdini){
//        return listaOrdini.stream()
//                .flatMap(order -> order.getProducts()
//                .stream()
//                .filter(product -> product.getCategory()=="Baby")
//                .collect(Collectors.toList());
//    }


    public static List<Product> getProdottiBoys (List<Product> lista){
        return lista.stream()
                .filter(p -> p.getCategory() == "Boys")
                .map(p-> p.getPrice())
                        .collect (Collectors.toList());

    }
}
