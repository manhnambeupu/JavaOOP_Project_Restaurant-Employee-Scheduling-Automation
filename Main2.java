import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.Iterator; 
public class Main2
{
    public static void main(String[] args){
        //Xac dinh cac ngay lam viec trong tuan tu thu 2 den chu nhat
        Arbeitstag_Nummer_List listArb = new Arbeitstag_Nummer_List();
        List<Integer> arbeitstag = listArb.ShowArbeitstag();
        //Xac dinh so nhan vien toi thieu can lam viec trong ngay
        minNhanVien minnv = new minNhanVien();
        int[] minNhanVien = minnv.ShowMinNhanVien();
        //
        List<Nhan_Vien> list_nhan_vien = new ArrayList<>();
        
        list_nhan_vien.add(new Nhan_Vien("Lan", new int[]{2,3}));
        list_nhan_vien.add(new Nhan_Vien("Nam",new int[]{5,6}));
        list_nhan_vien.add(new Nhan_Vien("Tung",new int[]{2}));
        list_nhan_vien.add(new Nhan_Vien("Long",null));
        
        //Sep lich ngau nhien
        List<Arbeitstag> sapxeplist= list_SapXep(list_nhan_vien, arbeitstag, minNhanVien);
        
        //Show result
        System.out.println("Lich lam viec");
        // for(Arbeitstag arbeistag : sapxeplist){
             // System.out.println(arbeitstag.to());
        // }
        Iterator<Arbeitstag> iterator = sapxeplist.iterator();
        while (iterator.hasNext()) {
            Arbeitstag arbeistag = iterator.next();
            System.out.println( arbeitstag.to());
        }
    }
    
    /**
     * Xao tron danh sach nhan vien
     */
    public static void shuffleNhanVien(List<Nhan_Vien> nhanvien){
        long time = System.nanoTime();
        Collections.shuffle(nhanvien, new Random(time));
    }
    
    public static List<Arbeitstag> list_SapXep(List<Nhan_Vien> nhanvien, List<Integer> arbeitstag, int[] minNhanVien){
        shuffleNhanVien(nhanvien);
        List<Arbeitstag> list_pro_tag = new ArrayList<>();
        for(int tag : arbeitstag){
            int required_nv_pro_tag = minNhanVien[tag];
            List <Nhan_Vien>  arbeit_nv = new ArrayList<>();
            for(Nhan_Vien nv: nhanvien){
                if(nv.MöglichArbeitInTag(tag)){
                    arbeit_nv.add(nv);
                }
                if(arbeit_nv.size() == required_nv_pro_tag){
                    break;
                }
            }
            if(arbeit_nv.size() < required_nv_pro_tag){
                throw new IllegalArgumentException("Khong du nhan vien cho ngay");
            }
            list_pro_tag.add(new Arbeitstag(tag,arbeit_nv ));
        }
        return list_pro_tag;    
    }
}
