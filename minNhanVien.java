
public class minNhanVien
{
    private int[] _min_NV_in_Tag;
    
    public minNhanVien()
    {
         this._min_NV_in_Tag=new int[9];
         _min_NV_in_Tag[2] = 2;
         _min_NV_in_Tag[3] = 2;
         _min_NV_in_Tag[4] = 2;
         _min_NV_in_Tag[5] = 2;
         _min_NV_in_Tag[6] = 2;
         _min_NV_in_Tag[7] = 2;
         _min_NV_in_Tag[8] = 2;
    }
    
    public int[] ShowMinNhanVien(){
        return _min_NV_in_Tag;
    }
}
