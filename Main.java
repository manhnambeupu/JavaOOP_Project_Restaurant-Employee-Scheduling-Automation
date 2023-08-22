import java.util.List;
import java.util.ArrayList;

public class Main
{
    public static void main(String[] args)
    {
        Nhan_Vien Lan = new Nhan_Vien("Lan",new int[]{3,6},10 );
        List<Object> list = Lan.arbeitZeitMöglich_List();
        System.out.println(Lan.toString() + "(ngay co the lam trong tuan)");
        for (Object obj : list)
        {
            if (obj instanceof Montag)
            {
                Montag montag = (Montag) obj;
                System.out.println("Montag: " + montag.ca());
            } else if (obj instanceof Dienstag)
            {
                Dienstag dienstag = (Dienstag) obj;
                System.out.println("Dienstag: " + dienstag.ca());
            } else if (obj instanceof Mittwoch)
            {
                Mittwoch mittwoch = (Mittwoch) obj;
                System.out.println("Mittwoch: " + mittwoch.ca());
            } else if (obj instanceof Donnerstag)
            {
                Donnerstag donnerstag = (Donnerstag) obj;
                System.out.println("Donnerstag: " + donnerstag.ca());
            } else if (obj instanceof Freitag)
            {
                Freitag freitag = (Freitag) obj;
                System.out.println("Freitag: " + freitag.ca());
            } else if (obj instanceof Samstag)
            {
                Samstag samstag = (Samstag) obj;
                System.out.println("Samstag: " + samstag.ca());
            } else if (obj instanceof Sonntag)
            {
                Sonntag sonntag = (Sonntag) obj;
                System.out.println("Sonntag: " + sonntag.ca());
            } else
            {
                throw new IllegalArgumentException("Object khong hop le!");
            }
        }
    }
}
