package ECommerce;

public class Cliente {
    private String codiceCliente;
    private String nome;
    private String cognome;
    private String email;
    private String dataIscrizione;

    public Cliente(String codiceCliente, String nome, String cognome, String email, String dataIscrizione) {
        this.codiceCliente = codiceCliente;
        this.nome = nome;
        this.cognome = cognome;
        this.email = email;
        this.dataIscrizione = dataIscrizione;
    }

    public String getCodiceCliente() {
        return codiceCliente;
    }

    public void setCodiceCliente(String codiceCliente) {
        this.codiceCliente = codiceCliente;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDataIscrizione() {
        return dataIscrizione;
    }

    public void setDataIscrizione(String dataIscrizione) {
        this.dataIscrizione = dataIscrizione;
    }

    //    Cliente(String codiceCliente, String nomeCognomeCliente, String email, String dataIscrizione){
//        this.codiceCliente=codiceCliente;
//        this.nomeCognomeCliente=nomeCognomeCliente;
//        this.email=email;
//        this.dataIscrizione=dataIscrizione;
//    }
//
//    public String getCodiceCliente(){
//        return this.codiceCliente;
//    }
//
//    public String getNomeCliente(){
//        return this.nomeCognomeCliente;
//    }
//
//    public String getMailCliente(){
//        return this.email;
//    }
//
//    public String getDataIscrizione(){
//        return this.dataIscrizione;
//    }


}