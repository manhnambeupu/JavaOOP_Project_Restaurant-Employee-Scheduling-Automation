public class Sonntag
{
    private  Ca1_CN _ca_1;
    private  Ca2_CN _ca_2;
    private  CaFull_CN _ca_Full;
   
    public Sonntag()
    {
        this._ca_1 = new Ca1_CN();
        this._ca_2 = new Ca2_CN();
        this._ca_Full = new CaFull_CN();
    }
    //override for Object typ
    public String toString(){
        return "Sonntag";
    }
    
    public String ca(){
        return _ca_1.toString() + " enteder " + _ca_2.toString() + " oder " + _ca_Full.toString();
    }
}
