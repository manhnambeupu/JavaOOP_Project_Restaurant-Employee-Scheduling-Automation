/**
 * Dieser Klasse modelliert das Arbeitsschicht des Donnerstag in der Woche  
 * @author (Tran Manh Nam)
 * @version (22.08.2023)
 */
public class Donnerstag
{
    private  Ca1 _ca_1;
    private  Ca2 _ca_2;
    private  CaFull _ca_Full;
    
    /**
     * Initialisiert die Arbeitssichten des Donnestag
     */
    public Donnerstag()
    {
        this._ca_1 = new Ca1();
        this._ca_2 = new Ca2();
        this._ca_Full = new CaFull();
    }
    
    /**
     * Override Object Donnerstag toString
     */
    public String toString(){
        return "Donnerstag";
    }
    
    /**
     * Arbeitssichten des Donnerstag toString
     */
    public String ca(){
        return _ca_1.toString() + " entweder " + _ca_2.toString() + " oder " + _ca_Full.toString();
    }
}
