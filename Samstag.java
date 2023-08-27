/**
 * Dieser Klasse modelliert das Arbeitsschicht des Samstag in der Woche  
 * @author (Tran Manh Nam)
 * @version (22.08.2023)
 */
public class Samstag
{
    private  Ca1_7 _ca_1;
    private  Ca2 _ca_2;
    private  CaFull_7 _ca_Full;
    
    /**
     * Initialisiert die Arbeitssichten des Samstag
     */
    public Samstag()
    {
        this._ca_1 = new Ca1_7();;
        this._ca_2 = new Ca2();
        this._ca_Full = new CaFull_7();
    }
    
    /**
     * Override Object Samstag toString
     */
    public String toString(){
        return "Samstag";
    }
    
    /**
     * Arbeitssichten des Samstag toString
     */
    public String ca(){
        return _ca_1.toString() + " entweder " + _ca_2.toString() + " oder " + _ca_Full.toString();
    }
}
