package Parkhaus;

/**Da die Klasse Motorrad von der Klasse Fahrzeug erbt, kann das Objekt in der Ausgabe mit "getSimplName" als "motorrad"
 * ausgegeben werden. Objekte der Klasse Motorrad können die Methoden der Klasse Fahrzeug ausführen.
 */

public class Motorrad extends Fahrzeug {
    public Motorrad(Parkhaus parkhaus) {
        super(parkhaus);
    }
}
