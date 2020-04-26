import java.util.*;
import java.lang.*;
import java.io.*;

public class Dns {

   HashMap <AdresseIP, NomMachine> ipToMachine;
   HashMap <NomMachine, AdresseIP> machineToIp;

   public Dns(){
       this.ipToMachine = new HashMap<AdresseIP, NomMachine>();
       this.machineToIp = new HashMap<NomMachine, AdresseIP>();
   }

   public void initBDD() throws IOException{
       String nomFic = "database.txt";
       BufferedReader in = new BufferedReader(new FileReader(nomFic));;
       String line = "";

       try{
           while((line = in.readLine()) != null){
               NomMachine NM = new NomMachine(line.substring(0, 15));
               AdresseIP ip = new AdresseIP(line.substring(16, 27));
               this.ipToMachine.put(ip, NM);
               this.machineToIp.put(NM, ip);
           }
       } catch(FileNotFoundException e){
           System.out.println("Erreur de lecture dans la database");
           System.exit(1);
       }
   }

    public DnsItem getItemI(NomMachine nom){
        for (Map.Entry<NomMachine, AdresseIP> elem : this.machineToIp.entrySet()) {
            if (elem.getKey().toString().equals(nom.toString())) {
                return new DnsItem(elem.getValue(), nom);
            }
        }
        return new DnsItem(new AdresseIP("Erreur (4)"), new NomMachine("Erreur (3)"));
    }

    public DnsItem getItemN(AdresseIP adr){
        for (Map.Entry<AdresseIP, NomMachine> elem : this.ipToMachine.entrySet()) {
            if (elem.getKey().toString().equals(adr.toString())) {
                return new DnsItem (adr, elem.getValue());
            }
        }
        return new DnsItem(new AdresseIP("Erreur (4)"), new NomMachine("Erreur (3)"));
    }


//    public Collection<DnsItem> getItems(){
//        for(Map.Entry<NomMachine, AdresseIP> elem : this.machineToIp.entrySet()){
//            return new DnsItem(new AdresseIP(""), elem.getValue());
//        }
//    }
}
