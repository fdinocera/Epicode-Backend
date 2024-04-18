package OperatoreTelefoniaCellulare;

public class UsaSIM {

    public static void main(String[] args) {
        SIM sim = new SIM(33912347);
        sim.setCreditoDisponibile(10);

        Chiamata [] chiamate = new Chiamata[5];
        Chiamata ch1 = new Chiamata(339121231, 5);
        Chiamata ch2 = new Chiamata(338121231, 5);
        Chiamata ch3 = new Chiamata(337121231, 5);
        Chiamata ch4 = new Chiamata(336121231, 5);
        Chiamata ch5 = new Chiamata(335121231, 5);

        chiamate[0]= ch1;
        chiamate[1]= ch2;
        chiamate[2]= ch3;
        chiamate[3]= ch4;
        chiamate[4]= ch5;

        sim.setUltime5Chiamate(chiamate);
        sim.stampaDati();
    }
}
