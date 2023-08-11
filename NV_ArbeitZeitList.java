import java.util.ArrayList;
import java.util.List;
public class NV_ArbeitZeitList
{
    private List <Nhan_Vien> _Nhan_Vien_List ;
    
    public NV_ArbeitZeitList()
    {
        this._Nhan_Vien_List = new ArrayList<>();
    }

    public void Add_Nhan_Vien(Nhan_Vien ten )
    {
        _Nhan_Vien_List.add(ten);
    }
    
    
    public List <Nhan_Vien> NhanVienList(){
        return _Nhan_Vien_List;
    }
}
