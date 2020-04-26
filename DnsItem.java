public class DnsItem {
    private final AdresseIP ip;
    private final NomMachine nom_machine;

    public DnsItem(AdresseIP ip, NomMachine nom_machine){
        this.ip = ip;
        this.nom_machine = nom_machine;
    }

    public AdresseIP getIP(){
        return this.ip;
    }

    public NomMachine getNom_machine(){
        return this.nom_machine;
    }

    public String getTotal(){
        return ip.toString() + "" + nom_machine.toString();
    }
}
