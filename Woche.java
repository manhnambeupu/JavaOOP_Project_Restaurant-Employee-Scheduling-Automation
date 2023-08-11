public class Woche
{
    private Montag _Montag;
    private Dienstag _Dienstag;
    private Mittwoch _Mittwoch;
    private Donnerstag _Donnerstag;
    private Freitag _Freitag;
    private Samstag _Samstag;
    private Sonntag _Sonntag;
    
    public Woche()
    {
        this._Montag = new Montag();
        this._Dienstag = new Dienstag();
        this._Mittwoch = new Mittwoch();
        this._Donnerstag = new Donnerstag();
        this._Freitag = new Freitag();
        this._Samstag = new Samstag();
        this._Sonntag = new Sonntag();
    }
}
