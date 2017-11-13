
/**
 * BusArrivalNode Represents the base build of node that can be combain in a list.
 * 
 * @author (matan zilka) 
 * @version (31.1.16)
 */
public class BusArrivalNode
{
    /** indecaite a pravite argument
     * @paramParameters
     * @param BusArrival _busArr store object of the class BusArrival.
     * @param BusArrivalNode _next  store object of the class BusArrivalNode indicate the next node in the list
     * 
     */
    private BusArrival _busArr; // indicate the value.
    private BusArrivalNode _next;// indicate the next in bus in the list.
    /** public BusArrivalNode (BusArrival b)
     * constactor of BusArrivalNode with 1 argument.
     * 
     */
    public BusArrivalNode (BusArrival b)
    {
        _busArr = b;
        _next = null;
    }

    /** public BusArrivalNode (BusArrival b, BusArrivalNode n) 
     * constactor of BusArrivalNode with 2 argument.
     */
    public BusArrivalNode (BusArrival b, BusArrivalNode n) 
    {
        _busArr = b;
        _next = n;
    }

    /** public BusArrivalNode (BusArrivalNode b)
     * constactor a copy of b.
     */
    public BusArrivalNode (BusArrivalNode b)
    {
        _busArr = b._busArr;
        _next = b._next;
    }

    /** public BusArrival getBusArr()
     *  @return Returns:
     *  the bus of this node.
     */
    public BusArrival getBusArr()
    {
        return _busArr;
    }

    /** public BusArrivalNode  getNext()
     *  @return Returns:
     *  the next node in the list.
     */
    public BusArrivalNode  getNext()
    {
        return _next;
    }

    /** public void setBusArr (BusArrival b)
     *  change  _busArr with the b.
     */
    public void setBusArr (BusArrival b)
    {
        _busArr = b;
    }

    /** public void setNext(BusArrivalNode  next)
     * change  _next to next.
     * 
     */
    public void setNext(BusArrivalNode  next)
    {
        _next = next;
    }
}