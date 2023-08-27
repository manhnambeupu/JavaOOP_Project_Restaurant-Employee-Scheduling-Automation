/**
 * Dieser Klasse modelliert das Arbeitsschicht des Freitag in der Woche  
 * @author (Tran Manh Nam)
 * @version (22.08.2023)
 */
public class Freitag
{
    private  Ca1 _ca_1;
    private  Ca2 _ca_2;
    private  CaFull _ca_Full;
    
    /**
     * Initialisiert die Arbeitssichten des Freitag
     */
    public Freitag()
    {
        this._ca_1 = new Ca1();
        this._ca_2 = new Ca2();
        this._ca_Full = new CaFull();
    }
    
    /**
     * Override Object Freitag toString
     */
    public String toString(){
        return "Freitag";
    }
    
    /**
     * Arbeitssichten des Freitag toString
     */
    public String ca(){
        return _ca_1.toString() + " entweder " + _ca_2.toString() + " oder " + _ca_Full.toString();
    }
}
