
import java.io.IOException;
import java.lang.*;

public class DnsTUI{

    private CMD commande;

    public DnsTUI(){
        this.commande = new CMD();
    }

    public void nextCommande(String cmd) throws IOException{
    int cmpt = 0;
    int i = 0;
    for(i = 0; i < cmd.length(); i++) {
        char tmp = cmd.charAt(i);
        if (tmp == '.') {
            cmpt++;
        }
    }
    Dns d = new Dns();
    d.initBDD();
    switch(cmpt) {
        case (0):
            if(cmd.contains("quitter")){
                commande.INIT(cmd, "quitter");
                commande.exec();
            }
            else if(cmd.equals("ls")) {
                commande.INIT(cmd, "ls");
                commande.exec();
            }
            else if(cmd.equals("ls [-a]")){
                commande.INIT(cmd, "ls/a");
                commande.exec();
                }
            else if(cmd.equals("help")){
                commande.INIT(cmd, "guide");
                commande.exec();
            }
            else{
                System.out.println("Erreur de saisie d'une commande ou celle-ci est inexistante. Veuillez essayer à nouveau.(1)");
            }
            break;

        case (2):
            commande.INIT(cmd, "machineToIP");
            commande.exec();
            break;

        case (3):
            commande.INIT(cmd, "ipToMachine");
            commande.exec();
            break;

        default:
            System.out.println("Erreur de saisie d'une commande ou celle-ci est inexistante. Veuillez essayer à nouveau.(2)");
            break;
        }
    }

    public void affiche(){
        System.out.println("Hello World");
    }
}






