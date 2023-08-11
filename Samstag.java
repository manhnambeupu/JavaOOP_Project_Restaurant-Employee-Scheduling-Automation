public class Samstag
{
    private  Ca1_7 _ca_1;
    private  Ca2 _ca_2;
    private  CaFull_7 _ca_Full;
    public Samstag()
    {
        this._ca_1 = new Ca1_7();;
        this._ca_2 = new Ca2();
        this._ca_Full = new CaFull_7();
    }
    //override for Object typ
    public String toString(){
        return "Samstag";
    }
    
    public String ca(){
        return _ca_1.toString() + " entweder " + _ca_2.toString() + " oder " + _ca_Full.toString();
    }
}
