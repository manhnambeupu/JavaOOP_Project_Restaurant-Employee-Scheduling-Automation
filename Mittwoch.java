/**
 * Dieser Klasse modelliert das Arbeitsschicht des Mittwoch in der Woche  
 * @author (Tran Manh Nam)
 * @version (22.08.2023)
 */
public class Mittwoch
{
    private  Ca1 _ca_1;
    private  Ca2 _ca_2;
    private  CaFull _ca_Full;
    
    /**
     * Initialisiert die Arbeitssichten des Mittwoch
     */
    public Mittwoch()
    {
        this._ca_1 = new Ca1();
        this._ca_2 = new Ca2();
        this._ca_Full = new CaFull();
    }
    
    /**
     * Override Object Mittwoch toString
     */
    public String toString(){
        return "Mittwoch";
    }
    
    /**
     * Arbeitssichten des Mittwoch toString
     */
    public String ca(){
        return _ca_1.toString() + " enteder " + _ca_2.toString() + " oder " + _ca_Full.toString();
    }
}
