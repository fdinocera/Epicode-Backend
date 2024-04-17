package ECommerce;

public class Cliente {
    private String codiceCliente;
    private String nomeCognomeCliente;
    private String email;
    private String dataIscrizione;

    Cliente(String codiceCliente, String nomeCognomeCliente, String email, String dataIscrizione){
        this.codiceCliente=codiceCliente;
        this.nomeCognomeCliente=nomeCognomeCliente;
        this.email=email;
        this.dataIscrizione=dataIscrizione;
    }

    public String getCodiceCliente(){
        return this.codiceCliente;
    }

    public String getNomeCliente(){
        return this.nomeCognomeCliente;
    }

    public String getMailCliente(){
        return this.email;
    }

    public String getDataIscrizione(){
        return this.dataIscrizione;
    }
}