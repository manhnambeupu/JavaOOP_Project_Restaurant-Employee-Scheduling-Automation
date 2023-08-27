/**
 * Dieser Klasse modelliert das Arbeitsschicht des Dienstags in der Woche  
 * @author (Tran Manh Nam)
 * @version (22.08.2023)
 */
public class Dienstag
{
    private  Ca1 _ca_1;
    private  Ca2 _ca_2;
    private  CaFull _ca_Full;
    
    /**
     * Initialisiert die Arbeitssichten des Montag
     */
    public Dienstag()
    {
        this._ca_1 = new Ca1();
        this._ca_2 = new Ca2();
        this._ca_Full = new CaFull();
    }
    
     /**
     * Override Object Dienstag toString
     */
    public String toString(){
        return "Dienstag";
    }
    
     /**
     * Arbeitssichten des Dienstags toString
     */
    public String ca(){
        return _ca_1.toString() + " entweder " + _ca_2.toString() + " oder " + _ca_Full.toString();
    }
}
