/**
 * Dieser Klasse modelliert das Arbeitsschicht des Sonntag in der Woche  
 * @author (Tran Manh Nam)
 * @version (22.08.2023)
 */
public class Sonntag
{
    private  Ca1_CN _ca_1;
    private  Ca2_CN _ca_2;
    private  CaFull_CN _ca_Full;
    
    /**
     * Initialisiert die Arbeitssichten des Sonntag
     */
    public Sonntag()
    {
        this._ca_1 = new Ca1_CN();
        this._ca_2 = new Ca2_CN();
        this._ca_Full = new CaFull_CN();
    }
    
    /**
     * Override Object Sonntag toString
     */
    public String toString(){
        return "Sonntag";
    }
    
    /**
     * Arbeitssichten des Sonntag toString
     */
    public String ca(){
        return _ca_1.toString() + " enteder " + _ca_2.toString() + " oder " + _ca_Full.toString();
    }
}
