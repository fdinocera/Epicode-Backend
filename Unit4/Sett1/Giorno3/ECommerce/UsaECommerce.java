package ECommerce;

public class UsaECommerce {

    public static void main(String[] args) {
        Articolo art1 = new Articolo("a100", "Televisore 34DS", 322.99, 10);
        Articolo art2 = new Articolo("a101", "Televisore 34XS", 422.99, 12);
        Articolo art3 = new Articolo("a102", "Televisore 34SS", 522.99, 14);

        Cliente cl1 = new Cliente("CL001", "Mario Rossi", "mario@rossi.com", "10/01/2022");
        Cliente cl2 = new Cliente("CL002", "Aldo Bianchi", "aldo@bianchi.com", "20/01/2022");


        //carrello1
        Articolo[] articoli1 = new Articolo[3];
        articoli1[0] = art1;
        articoli1[1] = art2;
        articoli1[2] = art3;
        Carrello car1 = new Carrello(cl1, articoli1);
        stampaDatiCarrello(car1);


        //carrello2
        Articolo[] articoli2 = new Articolo[1];
        articoli2[0] = art1;
        Carrello car2 = new Carrello(cl2, articoli2);
        stampaDatiCarrello(car2);


    }


    public static void stampaDatiCarrello(Carrello car1) {

        System.out.println("----- Carrello ------");
        System.out.println("nome: " + car1.getClienteCarrello().getNomeCliente());
        System.out.println("cod cliente: " + car1.getClienteCarrello().getCodiceCliente());
        System.out.println("mail: " + car1.getClienteCarrello().getMailCliente());
        System.out.println("data iscrizione: " + car1.getClienteCarrello().getDataIscrizione());
        System.out.println("totale carrello: " + car1.getTotaleCarrello());
        System.out.println();
    }
}
