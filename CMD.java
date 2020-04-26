import java.io.IOException;
import java.util.HashMap;

public class CMD{

    private String commande;
    private String argument;

    public void INIT(String commande, String argument){
        this.commande = commande;
        this.argument = argument;
    }

    public void exec() throws IOException {
        Dns d = new Dns();
        d.initBDD();
        String r = " ";
        switch (argument) {
            case "machineToIP":
                NomMachine nom = new NomMachine((commande));
                System.out.println(d.getItemI(nom).getIP().toString());
                break;
            case ("ipToMachine"):
                AdresseIP ip = new AdresseIP(commande);
                System.out.println(d.getItemN(ip).getNom_machine().toString());
                break;
            case ("quitter"):
                System.out.println("Deconnexion du serveur");
                System.exit(0);
                break;
            case ("ls"):
                System.out.println("Pas encore de commande ls.Désolé");
                break;
            case ("ls/a"):
                System.out.println("Pas encore de commande ls[-a].Désolé");
                break;
            case ("guide"):
                System.out.println("XXXXX.XXXXXX.fr : Obtenir l'adresse IP correspondant");
                System.out.println("XXX.XXX.XXX : obtenir le nom de la machine correspondant");
                System.out.println("help : Obtenir la liste des commandes");
                System.out.println("quitter : Fermer le serveur et quitter le programme");
                break;
            default:


        }
    }
}
