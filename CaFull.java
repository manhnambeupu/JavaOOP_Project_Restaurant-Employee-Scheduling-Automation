/**
 * Dieser Klasse modelliert das FUll.Arbeitsschicht des Montags,Dienstags,Mittwoch,Donnerstag,Freitag in der Woche  
 * @author (Tran Manh Nam)
 * @version (22.08.2023)
 */
public class CaFull
{
    private String _arbeit_zeit;
    
    /**
     * Initialisiert die FULL.Arbeitssichten des 2,3,4,5,6 
     */
    public CaFull()
    {
       this._arbeit_zeit = "Full: 11:30 bis 22:00";

    }
    
    /**
     * FULL.Arbeitssichten des 2,3,4,5,6 toString
     */
    public String toString(){
        return "Full: 11:30 bis 22:00";
    }
}
