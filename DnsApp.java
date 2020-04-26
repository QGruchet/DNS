import java.io.IOError;
import java.io.IOException;
import java.util.*;


public class DnsApp {

    private DnsTUI D;

    public DnsApp(){
        this.D = new DnsTUI();
    }
    public static void main(String[] args) throws IOException{
        DnsApp app = new DnsApp();
        System.out.println("Connexion au serveur....DONE\n");
        System.out.println("Pour obtenir de l'aide taper 'help'");
        while(true){
            app.run();
        }
    }

    public void run() throws IOException {
        Scanner sc = new Scanner(System.in);
        String commande;

        System.out.println(">>");
        if(sc.hasNextLine()){
            commande = sc.nextLine();
            D.nextCommande(commande);
        }
    }

}