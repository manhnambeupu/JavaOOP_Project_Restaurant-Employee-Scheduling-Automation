public class Node_NV
{
    Nhan_Vien _nv;
    Node_NV prev;
    Node_NV next;

    /**
     * Konstruktor für Objekte der Klasse Node_NV
     */
    public Node_NV(Nhan_Vien nv)
    {
        this._nv = nv;
        this.prev = null;
        this.next = null;
    }

}
