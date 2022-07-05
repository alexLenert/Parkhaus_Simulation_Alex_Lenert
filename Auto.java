package Parkhaus;

/**
 * Da die Klasse Auto von der Klasse Fahrzeug erbt, kann das Objekt in der Ausgabe mit "getSimplName" als "auto"
 * ausgegeben werden. Objekte der Klasse Auto können die Methoden der Klasse Fahrzeug ausführen.
 *
 */

public class Auto extends Fahrzeug{
    public Auto(Parkhaus parkhaus) {
        super(parkhaus);
    }
}
