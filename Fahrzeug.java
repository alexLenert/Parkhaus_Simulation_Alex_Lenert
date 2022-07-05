package Parkhaus;
/**
 * Die Klasse Fahrzeug enthält im Konstruktor den zufällig generierten String "kennzeichen". Dieser wird mittels getter
 * für die Klasse ParkhausApp zugänglich.
 *
 * Die Methode "einparken" sucht in der Map "parkhaus" nach einem String mit der Zeichenkette "frei" und fügt das Kennzeichen an dieser Stelle in die Map parkahaus ein,
 * und speichert gleichzeitig das Kennzeichen in der globalen Array-List "eingeparkteFahrzeuge".
 * Die Ebene und die Parkplatz-Nr. welche an diesem Platz hinterlegt sind, werden über eine Ausgabe zusammen mit dem Kennzeichen angezeigt.
 *
 * Die Methode ausparken vergleicht die eingetragenen Kennzeichen mit einem Kennzeichen in der Map. Bei Übereinstimmung wird dieses Kennzeichen in der Map an gleicher Stelle
 * durch einen String mit der Zeichenkette "frei" ersetzt. In einer Ausgabe wird angegeben, dass das Fahrzeug mit diesem Kennzeichen das Parkhaus verlässt.
 * Momentan liest "ausparken" in Zeile 65 die Liste nicht aus. Stattdessen greift die Methode direkt auf
 *  "kennzeichen" zu.
 */

import java.util.ArrayList;
import java.util.List;

public class Fahrzeug {

    Parkhaus user = new Parkhaus();
    private String leererPlatz = "frei";
    private String kennzeichen = "";
    private List<String> eingeparkteFahrzeuge = new ArrayList<>();
    //Getter
    public String getKennzeichen() {
        return kennzeichen;
    }
    public List<String> getEingeparkteFahrzeuge() {
        return eingeparkteFahrzeuge;
    }
    public String getLeererPlatz() {
        return leererPlatz;
    }
    // Konstruktor
    public Fahrzeug(Parkhaus parkhaus) {
        this.user = parkhaus;
        this.kennzeichen = "Ve - " + this.kennzeichenGenerator(1000, 9999);
    }
    public int kennzeichenGenerator(int minimum, int Maximum) {
        return (int) ((Math.random() * Maximum) + 1 + minimum);
    }

    public void einparken(String kennzeichen) {

        boolean gefunden = false;
        for (int ebene = 0; ebene < user.ebenen; ebene++) {
            for (int platz = 0; platz < user.parkPlaetze; platz++) {
                if (user.parkhaus.get(ebene).get(platz).equals(leererPlatz)) { // get(ebene).get(platz) -> Position in der Map!!!
                    user.parkhaus.get(ebene).put(platz, getKennzeichen());// setzt Kennzeichen in den Parkplatz ein
                    eingeparkteFahrzeuge.add(user.parkhaus.get(ebene).get(platz));
                    kennzeichen = user.parkhaus.get(ebene).get(platz);
                    gefunden = true;
                    System.out.println("Das " + getClass().getSimpleName() + " mit dem Kennzeichen: < " + kennzeichen + " > soll auf Ebene < " + ebene + " > den Parkplatz < " + platz + " > anfahren");
                    break;
                }
            }
            if (gefunden) {
                break;
            }
        }
    }
    public void ausparken(String leererPlatz) {

        String kennzeichenAusDerListe =kennzeichen;// String.valueOf(eingeparkteFahrzeuge.stream().findAny());//
        System.out.println("Test ausparken " + kennzeichenAusDerListe);
        boolean gefunden = false;
        for (int ebene = 0; ebene < user.ebenen; ebene++) {
            for (int platz = 0; platz < user.parkPlaetze; platz++) {
                if (user.parkhaus.get(ebene).get(platz).equals(kennzeichenAusDerListe)) {// get(ebene).get(platz) -> Position in der Map!!!
                    user.parkhaus.get(ebene).put(platz, leererPlatz); // setzt Kennzeichen in den Parkplatz ein
                    gefunden = true;
                    System.out.println("Das " + getClass().getSimpleName() + " mit dem Kennzeichen: " + kennzeichenAusDerListe + " verlässt den Parkplatz " + platz + "  die Ebene " + ebene + " um aus dem Parkhaus auszufahren");
                    break;
                }
            }
            if (gefunden) {
                break;


            }
        }
    }
}





