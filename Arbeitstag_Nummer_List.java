import java.util.ArrayList;
import java.util.List;
/**
 * Thu2 den CN (2 --> 8)
 */
public class Arbeitstag_Nummer_List
{
    private List<Integer> _arbeitstag;

    public Arbeitstag_Nummer_List()
    {
        this._arbeitstag = new ArrayList<Integer>();
        for(int i= 2; i <= 8; i++){
            _arbeitstag.add(i);
        }
    }
    
    public List<Integer> ShowArbeitstag(){
        return _arbeitstag;
    }
}


