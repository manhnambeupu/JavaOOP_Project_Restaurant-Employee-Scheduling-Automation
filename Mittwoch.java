public class Mittwoch
{
    private  Ca1 _ca_1;
    private  Ca2 _ca_2;
    private  CaFull _ca_Full;
    
    public Mittwoch()
    {
        this._ca_1 = new Ca1();
        this._ca_2 = new Ca2();
        this._ca_Full = new CaFull();
    }
    //override for Object typ
    public String toString(){
        return "Mittwoch";
    }
    
    public String ca(){
        return _ca_1.toString() + " enteder " + _ca_2.toString() + " oder " + _ca_Full.toString();
    }
}
