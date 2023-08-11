import java.util.List;
public class Arbeitstag
{
    private  int _tag;
    private  List<Nhan_Vien> _möglich_arbeit_nv;
    
    /**
     * Konstruktor für Objekte der Klasse Arbeitstag
     */
    public Arbeitstag(int tag, List<Nhan_Vien> möglich_arbeit_nv){
        this._tag = tag;
        this._möglich_arbeit_nv = möglich_arbeit_nv;
    }

    
    public int getTag(){
        return _tag;
    }
    
    public List<Nhan_Vien> getlist_möglich_arbeit_nv(){
        return _möglich_arbeit_nv;
    }
    
    public String to(){
        StringBuilder sb = new StringBuilder();
        sb.append("Ngày ").append(_tag).append(": ");
        for (Nhan_Vien nv : _möglich_arbeit_nv) {
            sb.append(nv.getName()).append(", ");
        }
        return sb.toString();
    }
    
}
