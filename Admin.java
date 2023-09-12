import java.util.List;
import java.util.ArrayList;
import java.util.Random;
import java.util.Iterator; 
public class Admin
{
    private DoppelteLinkedList_NV _list_nv;
    private Arbeitstag_Nummer_List _listArb;
    private minNhanVien _minnv;
    
    /**
     * Main
     */
    public Admin(){
        //Tag to Integer, um danach einfacher mit if else zuverwenden
        this._listArb = new Arbeitstag_Nummer_List();
        //Bestimmen Wie viele Mitarbeiter muss minimum im Tag arbeiten
        this._minnv = new minNhanVien();
        // Update DoppeltLinkedList DataStruktur 
        this._list_nv = new DoppelteLinkedList_NV();
    }
    
    /**
     * Macht der Plan fur Woche
     */
    public void plannen(){
        List<Integer> arbeitstag = _listArb.ShowArbeitstag();
        int[] minNhanVien = _minnv.ShowMinNhanVien();
        List<Arbeitstag> sapxeplist= list_SapXep(_list_nv, arbeitstag, minNhanVien);
        System.out.println("Plan in dieser Woche");
        //toString des Plan  
        Iterator<Arbeitstag> iterator = sapxeplist.iterator();
        while (iterator.hasNext()) {
            Arbeitstag arbeistag = iterator.next();
            System.out.println( arbeistag.toString());
        }
    }
    
    /**
     * Add Employee in List
     */
    public void addinList(Nhan_Vien nv){
        this._list_nv.addTail(nv);
    }
    
    /**
     * Zeigt List Employee, die von Admin hinzugefugt wurde
     */
    public void getListEmployee(){
        this._list_nv.iterateForward();
    }
    
    /**
     * Methode list_sap_xep macht fur die Mitarbeiter Plan in der Woche 
     * @param nhanvien ist List der Mitarbeitern 
     * @param arbeitstag ist Tag to Integer, um danach einfacher mit if else zuverwenden
     * @param minNhanVien bestimmen, Wie viele Mitarbeiter muss minimum im Tag arbeiten
     */
    private static List<Arbeitstag> list_SapXep(DoppelteLinkedList_NV nhanvien, List<Integer> arbeitstag, int[] minNhanVien){
        /* 
         * shuffel:Es wird verwendet, um diese Situation zu vermeiden. 
         * Nachteile des QuickSort-Algorithmus: Die Leistung kann schlecht sein, wenn die Sequenz fast sortiert ist
        */
        nhanvien.shuffle(new Random(System.nanoTime()));
        quickSort(nhanvien,0,nhanvien.size()-1);

        List<Arbeitstag> list_pro_tag = new ArrayList<>();
        for(int tag : arbeitstag){
            int required_nv_pro_tag = minNhanVien[tag];
            List <Nhan_Vien>  arbeit_nv = new ArrayList<>();
            
            for(int i = 0; i < nhanvien.size(); i++){
                Nhan_Vien nv = nhanvien.getValueAtIndex(i);
                
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
    private static void quickSort(DoppelteLinkedList_NV nv, int L, int R){
        if(L >= R){return;}  
        Nhan_Vien key = nv.getValueAtIndex((L+R)/2);
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
    private static int partition(DoppelteLinkedList_NV nv, int L, int R, Nhan_Vien key){
        int iL = L;
        int iR = R;
        while(iL <= iR){
            //move pointer iL, wenn StundeVonLink  kleiner als recht ist
            while(nv.getValueAtIndex(iL).gesamt_stunde() < key.gesamt_stunde()){iL++;}
            //move pointer iR, wenn StundeVonRecht grosser als link ist
            while(nv.getValueAtIndex(iR).gesamt_stunde() > key.gesamt_stunde()){iR--;}
            //Wenn index(bei dieser Pointer_Position) von iL noch <= iR
            // Umtauschen mit logik (Kleiner bleiben unbedingt Link und Grosser beleiben unbedingt recht)
            if(iL <= iR){
                Nhan_Vien temp = nv.getValueAtIndex(iL);
                nv.setValueAtIndex(iL,nv.getValueAtIndex(iR));
                nv.setValueAtIndex(iR, temp);
                iL++; 
                iR--;
            }
        }
        return iL;
    }
}
