import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.Iterator; 
public class Main2
{
    /**
     * Main
     */
    public static void main(String[] args){
        //Tag to Integer, um danach einfacher mit if else zuverwenden
        Arbeitstag_Nummer_List listArb = new Arbeitstag_Nummer_List();
        List<Integer> arbeitstag = listArb.ShowArbeitstag();
        //Bestimmen Wie viele Mitarbeiter muss minimum im Tag arbeiten
        minNhanVien minnv = new minNhanVien();
        int[] minNhanVien = minnv.ShowMinNhanVien();
        
        //List der Mitarbeitern wurden deklariert
        List<Nhan_Vien> list_nhan_vien = new ArrayList<>();
        
        list_nhan_vien.add(new Nhan_Vien("Lan", null,170));
        list_nhan_vien.add(new Nhan_Vien("Nam",null,150));
        list_nhan_vien.add(new Nhan_Vien("Tung",null,160));
        list_nhan_vien.add(new Nhan_Vien("Long",null,100));
        
        //Planen fur die Mitarbeiter
        List<Arbeitstag> sapxeplist= list_SapXep(list_nhan_vien, arbeitstag, minNhanVien);
        System.out.println("Plan in dieser Woche");
        
        //toString des Plan  
        Iterator<Arbeitstag> iterator = sapxeplist.iterator();
        while (iterator.hasNext()) {
            Arbeitstag arbeistag = iterator.next();
            System.out.println( arbeistag.toString());
        }
    }
    
    /**
     * shuffelNhanVien-Methode:Es wird verwendet, um diese Situation zu vermeiden. 
     * Nachteile des QuickSort-Algorithmus: Die Leistung kann schlecht sein, wenn die Sequenz fast sortiert ist
     */
    static void shuffleNhanVien(List<Nhan_Vien> nhanvien){
        long time = System.nanoTime();
        Collections.shuffle(nhanvien, new Random(time));
    }
    
    /**
     * Methode list_sap_xep macht fur die Mitarbeiter Plan in der Woche 
     * @param nhanvien ist List der Mitarbeitern 
     * @param arbeitstag ist Tag to Integer, um danach einfacher mit if else zuverwenden
     * @param minNhanVien bestimmen, Wie viele Mitarbeiter muss minimum im Tag arbeiten
     */
    static List<Arbeitstag> list_SapXep(List<Nhan_Vien> nhanvien, List<Integer> arbeitstag, int[] minNhanVien){
        
        shuffleNhanVien(nhanvien);
        quickSort(nhanvien,0,nhanvien.size()-1);

        List<Arbeitstag> list_pro_tag = new ArrayList<>();
        for(int tag : arbeitstag){
            int required_nv_pro_tag = minNhanVien[tag];
            List <Nhan_Vien>  arbeit_nv = new ArrayList<>();
            for(Nhan_Vien nv: nhanvien){
                if(nv.MöglichArbeitInTag(tag)){
                    nv.countTag();
                    if(nv.getGesamt_Tag()<=4){//die arbeiten weniger, muss 4 Tag pro Woche arbeiten 
                        arbeit_nv.add(nv);
                    }
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
    
    /**
     * QuickSort-Alogrithm
     * @param L sollt Index 0 eingeben( 0 wurde initialisiert )
     * @param R sollt letzte Index von List eingeben( nv.size()-1 wurde initialisiert )
     */
    static void quickSort(List<Nhan_Vien> nv, int L, int R){
        if(L >= R){return;}  
        Nhan_Vien key = nv.get((L+R)/2);
        int k = partition(nv,L,R,key);
        quickSort(nv,L,k-1);
        quickSort(nv,k,R);
    }
    
    /**
     * Partition Methode, um Employees_List zuverteilen 
     * @param L sollt Index 0 eingeben( 0 wurde initialisiert )
     * @param R sollt letzte Index von List eingeben( nv.size() wurde initialisiert )
     * @param key sollt Pivot_Value eingeben (Nhan Vien (Key) )
     */
    static int partition(List<Nhan_Vien> nv, int L, int R, Nhan_Vien key){
        int iL = L;
        int iR = R;
        while(iL <= iR){
            //move pointer iL, wenn StundeVonLink  kleiner als recht ist
            while(nv.get(iL).gesamt_stunde() < key.gesamt_stunde()){iL++;}
            //move pointer iR, wenn StundeVonRecht grosser als link ist
            while(nv.get(iR).gesamt_stunde() > key.gesamt_stunde()){iR--;}
            //Wenn index(bei dieser Pointer_Position) von iL noch <= iR
            // Umtauschen mit logik (Kleiner bleiben unbedingt Link und Grosser beleiben unbedingt recht)
            if(iL <= iR){
                Nhan_Vien temp = nv.get(iL);
                nv.set(iL,nv.get(iR));
                nv.set(iR, temp);
                iL++; 
                iR--;
            }
        }
        return iL;
    }
}
