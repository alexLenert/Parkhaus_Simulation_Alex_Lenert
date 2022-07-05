package Parkhaus;

/**Die Klasse ParkhausApp enthält die main-Methode, in der Objekte von allen Klassen eingetragen sind.
 * Mit den Objekten aus Klasse Auto und Motorrad werden die Methoden von Fahrzeug und Parkhaus
 * ausgeführt. 
 *
 *
 */

public class ParkhausApp {


    public static void main(String[] args) {

        Parkhaus parkhausWaechter = new Parkhaus();
        Fahrzeug appF = new Fahrzeug(parkhausWaechter);
        Auto car = new Auto(parkhausWaechter);
        Auto car2 = new Auto(parkhausWaechter);
        Motorrad bike = new Motorrad(parkhausWaechter);

        System.out.println("vor dem Map-erstellen"); //Zeigt die noch unvorbereitete Map
        parkhausWaechter.parkhausErstellen();
        System.out.println("Vor dem einparken " + parkhausWaechter.parkhaus);//Zeigt die Map als leeres Parkhaus
        car.einparken(appF.getKennzeichen());   // Auto mit Kennzeichen parkt (Kennzeichen wird eingefügt)
        bike.einparken(appF.getKennzeichen());  // Mororrad mit Kennzeichen parkt (Kennzeichen wird eingefügt)
        car2.einparken(appF.getKennzeichen());
        bike.einparken(appF.getKennzeichen());
        car.einparken(appF.getKennzeichen());
        bike.einparken(appF.getKennzeichen());
        car2.einparken(appF.getKennzeichen());
        bike.einparken(appF.getKennzeichen());
        car.einparken(appF.getKennzeichen());
        bike.einparken(appF.getKennzeichen());



        System.out.println("Check Liste: " + appF.getEingeparkteFahrzeuge()); //Zeigt die Einträge der parallelen Liste (Verbesserungsbedürftig)

        System.out.println(" Nach dem einparken " + parkhausWaechter.parkhaus); // Zeigt die Map nach dem Einparken aller Autos und Motorräder
        parkhausWaechter.fahrzeugFinden();                                      // momentan außer Funktion
        parkhausWaechter.fahrzeugFinden();
        parkhausWaechter.fahrzeugFinden();
        parkhausWaechter.fahrzeugFinden();
        bike.ausparken(appF.getLeererPlatz());                                  //Motorrad parkt aus
        car.ausparken(appF.getLeererPlatz());                                   //Auto parkt aus
        car2.ausparken(appF.getLeererPlatz());
        car.ausparken(appF.getLeererPlatz());
        System.out.println(" Nach dem ausparken: " + parkhausWaechter.parkhaus);  //Zeigt das Parkaus nach dem die Fahrzeuge wieder ausgeparkt wurden. Da nicht alle ausparken bleiben die Übrigen im Parkhaus


    }


}
