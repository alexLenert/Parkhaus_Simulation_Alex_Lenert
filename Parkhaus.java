package Parkhaus;

/** Die Klasse Parkhaus stellt die Map und struckturiert durch die Methode "parkhausErstellen" die Map in
 * Etagen- und Parklplatz-Nummern zusammen mit einem String mit der Zeichenkette "frei".
 * Die Anzahl der Etagen und Parkplätze sind durch die globalen Integern "ebenen" und "parkPlätze" frei wählbar.
 *
 * Die Methode "fahrzeugFinden" vergleicht die Einträge aus der ArrayList der Klasse Fahrzeug. Bei Übereinstimmung gibt
 * die Methode durch eine Ausgabe das Kennzeichen und die Angabe der Etage und Parkplatz-Nr in der Map wieder.
 *In der Map wird dabei nichts verändert.
 *
 * Momentan liest "fahzeugFinden" in Zeile 38 die Liste nicht aus. Stattdessen greift die Methode direkt auf
 * die get-Methode von kennzeichen zu. Aber auch das führt zu keiner Ausgabe.
 */

import java.util.HashMap;
import java.util.Map;

public class Parkhaus {

    String leererPlatz = "frei";
    Integer ebenen = 4; //Anzahl der Ebenen im Parkhaus
    Integer parkPlaetze = 10;  //Anzahl der Parkplätze im Parkhaus
    Map<Integer, Map<Integer, String>> parkhaus = new HashMap<>();

    public void parkhausErstellen() {
        Parkhaus user = new Parkhaus();
        Fahrzeug userF = new Fahrzeug(user);

        for (int ebene = 0; ebene < ebenen; ebene++) {
            parkhaus.put(ebene, new HashMap<>());
            for (int platz = 0; platz < parkPlaetze; platz++) {
                parkhaus.get(ebene).put(platz, leererPlatz);//Verschachtelt durch get(ebene) -> pro ebene <Anzahl Parklplätze,String "frei" oder generiertes Kennzeichen.
            }
        }
    }
    public void fahrzeugFinden() {
        Parkhaus finde = new Parkhaus();
        Fahrzeug findeF = new Fahrzeug(finde);
        String gesucht = findeF.getKennzeichen();//String.valueOf(findeF.getEingeparkteFahrzeuge().stream().findAny());//
        System.out.println("Test Suche: " + gesucht);

        boolean gefunden = false;
        for (int ebene = 0; ebene < ebenen; ebene++) {
            for (int platz = 0; platz < parkPlaetze; platz++) {
                if (parkhaus.get(ebene).get(platz).equals(gesucht)) { // get(ebene).get(platz) -> Position in der Map!!!Integer floor = parkhaus.get(ebene).;
                    gefunden = true;
                    System.out.println("Das " + getClass().getSimpleName() +"mit dem Kennzeichen <"  + gesucht +"> befindet sich auf Ebene " + ebene + " auf Parkplatz Nr. " + platz);  // setzt Kennzeichen in den Parkplatz ein

                    break;
                }
            }
            if (gefunden) {
                break;
            }
        }


    }
}
