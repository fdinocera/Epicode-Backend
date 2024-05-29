package Adapter;

import java.time.LocalDate;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class InfoAdapter implements DataSource {


    Info info = new Info();

    public Info getInfo() {
        return info;
    }

    public void setInfo(Info info) {
        this.info = info;
    }

    public InfoAdapter(Info info) {
        this.info = info;
    }

    public String getNome() {
        return info.getNome();
    }

    public String getCognome() {
        return info.getCognome();
    }

    public Date getDataDiNascita(){
        return info.getDataDiNascita();
    }


    @Override
    public String getNomeCompleto() {
        return info.getNome() + " " + info.getCognome();
    }

    @Override
    public int getEta() {

        Date dataDiNascita = info.getDataDiNascita();
        Date oggi = new Date();
        long differenzaMillisecondi = oggi.getTime() - dataDiNascita.getTime();


        long differenzaAnni = TimeUnit.MILLISECONDS.toDays(differenzaMillisecondi);

        return (int) differenzaAnni;
    }

    @Override
    public String toString() {
        return "InfoAdapter{" +
                "info=" + info +
                '}';
    }
}
