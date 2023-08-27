import java.util.ArrayList;
import java.util.List; 
/**
 * Dieser Klasse modelliert das Object-Mitarbeiter 
 * in Klasse gibt Name, MoglichArbeitstagList, ArbeitStunde der Mitarbeiter
 * @author (Tran Manh Nam)
 * @version (22.08.2023)
 */
public class Nhan_Vien
{
    private String _name;
    private Montag _ca_Montag;
    private Dienstag _ca_Dienstag;
    private Mittwoch _ca_Mittwoch;
    private Donnerstag _ca_Donnerstag;
    private Freitag _ca_Freitag;
    private Samstag _ca_Samstag;
    private Sonntag _ca_Sonntag;
    private int _arbeitZeit_Monat;  
    private List <Object> _arbeitZeitMöglich;
    private int _gesamt_Tag;
    /**
     * Initialisiert Object-Mitarbeiter
     */
    public Nhan_Vien(String name, int[]nicht_arbeit,int stunde){
        this._arbeitZeit_Monat = stunde;
        this._name = name;
        this._ca_Montag = new Montag(); 
        this._ca_Dienstag = new Dienstag(); 
        this._ca_Mittwoch = new Mittwoch(); 
        this._ca_Donnerstag = new Donnerstag(); 
        this._ca_Freitag = new Freitag(); 
        this._ca_Samstag = new Samstag(); 
        this._ca_Sonntag = new Sonntag();
        this._gesamt_Tag = 0;
        this._arbeitZeitMöglich = new ArrayList<Object>();
        if(nicht_arbeit == null){
            add_Arbeit_Möglich();
        }
        else{
            for(int i = 0 ; i < nicht_arbeit.length; i++){
                Nicht_Arbeitstag(nicht_arbeit[i]);
            }
            add_Arbeit_Möglich();
        }
    }
    
    /**
     * Methode arbeitZeitMoglich return List von Tage, die die Mitarbeiter in der Woche arbeiten konnen 
     */
    public List<Object> arbeitZeitMöglich_List(){
        List <Object> arbeitZeitMöglich = this._arbeitZeitMöglich;  
        return arbeitZeitMöglich;
    }
    
    /**
     * 
     */
    public void add_Arbeit_Möglich(){
        if(_ca_Montag == null && _ca_Dienstag == null && _ca_Mittwoch == null && _ca_Donnerstag == null && _ca_Freitag == null && _ca_Samstag == null && _ca_Sonntag == null){
            throw new IllegalArgumentException("Nhan vien nay nghi ca tuan nay");    
        }
        if(_ca_Montag != null ){
            _arbeitZeitMöglich.add(_ca_Montag);
        }
        if(_ca_Dienstag != null){
            _arbeitZeitMöglich.add(_ca_Dienstag);
        }
        if(_ca_Mittwoch != null){
            _arbeitZeitMöglich.add(_ca_Mittwoch);
        }
        if(_ca_Donnerstag != null){
            _arbeitZeitMöglich.add(_ca_Donnerstag);    
        }
        if(_ca_Freitag != null){
            _arbeitZeitMöglich.add(_ca_Freitag);
        }
        if(_ca_Samstag != null){
            _arbeitZeitMöglich.add(_ca_Samstag);
        }
        if(_ca_Sonntag != null){
            _arbeitZeitMöglich.add(_ca_Sonntag);
        }
    }
    
    public void Nicht_Arbeitstag(int Tag){
        switch(Tag){
            case 0,1:
                throw new IllegalArgumentException("Yeu cau chi dien 2(thu2),3(thu3),4(thu4),5(thu5),6(thu6),7(thu7),8(Chu Nhat)");
            case 2: _ca_Montag = null ;  break;
            case 3: _ca_Dienstag = null;   break;
            case 4: _ca_Mittwoch = null;  break;
            case 5: _ca_Donnerstag = null;  break;
            case 6: _ca_Freitag = null;  break;
            case 7: _ca_Samstag = null; break;
            case 8: _ca_Sonntag = null;  break;
            default: throw new IllegalArgumentException ("Ngay khong hop le");
        }
    }
    
    public boolean MöglichArbeitInTag(int Tag){
        boolean bool = true;
        switch(Tag){
            case 0,1:
                throw new IllegalArgumentException("Yeu cau chi dien 2(thu2),3(thu3),4(thu4),5(thu5),6(thu6),7(thu7),8(Chu Nhat)");
            case 2:
                if(_ca_Montag != null){bool = true;}
                else{bool = false;}
                break;
            case 3:
                if(_ca_Dienstag != null){bool = true;}
                else{bool = false;}
                break;
            case 4:
                if(_ca_Mittwoch != null){bool = true;}
                else{bool = false;}
                break;
            case 5:
                if(_ca_Donnerstag != null){bool = true;}
                else{bool = false;}
                break;
            case 6:
                if(_ca_Freitag != null){bool = true;}
                else{bool = false;}
                break;
        }
        return bool;
    }
    
    public String getName(){
        return _name;
    }
    
    public int arbeitszeit_Anmelden (int stunde){
        if(stunde == 0){
            throw new IllegalArgumentException("Yeu cau dien lai so tieng lam hom nay");
        }
        _arbeitZeit_Monat = _arbeitZeit_Monat + stunde;
        return _arbeitZeit_Monat;
    }
    
    public int gesamt_stunde(){
        return this._arbeitZeit_Monat;
    }
    
    public void countTag(){
    _gesamt_Tag++;    
    }
    
    public int getGesamt_Tag(){
        return this._gesamt_Tag;
    }
}
