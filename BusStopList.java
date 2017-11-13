
/**
 * Write a description of class BusStopList here.
 * 
 * @author (matan Zilka) 
 * @version (31.1.16)
 */
public class BusStopList
{
    /** indecaite a pravite argument
     * @paramParameters
     * @param BusArrivalNode _head store the first node in the list. 
     */
    private BusArrivalNode  _head;
    /** public BusStopList()
     *  defualt constactor of BusStopList with 1 argument, that equals the _head to null.
     */
    public BusStopList()
    {
        _head = null;
    }

    /** public boolean add(int line, int pass, Time1 t)
     *  a funcation that add another node to the list if the same bus isnt apper in the list and return true if so and false otherwise.
     * @paramParameters
     * @param int line indicate the line number of the new bus.
     * @param int pass indicate the number of passengers of the new bus.
     * @param Time1 t indicate the time that the new bus arrive.
     * return Returns:
     * checks if the new bus isnt apper in the list and insert it adn return true, and flase otherwise.
     */
    public boolean add(int line, int pass, Time1 t)
    {
        BusArrivalNode dummy = _head;
        BusArrival b = new BusArrival(line, pass, t);
        if(_head == null)
        {
            _head = new BusArrivalNode(b,null);
            return true;
        }
        else if(dummy.getBusArr().equals(b))
            return false;
        while(dummy.getNext() != null && !(dummy.getBusArr().equals(b)))
        {
            dummy = dummy.getNext();
        }
        if(dummy.getNext() == null && !(dummy.getBusArr().equals(b)))
        {
            BusArrivalNode temp = new BusArrivalNode(b,null);
            dummy.setNext(temp);
            return true; 
        }
        else
            return false;
    }

    /** public void removeAllLine(int line)
     * remove all the bus in the list with the same number of the arrgumet line.
     * @paramParameters
     * @param int line indicate the line number that need to be remove.
     * 
     */
    public void removeAllLine(int line)
    {
        if(_head == null)
        {}
        else
        {
            while(_head != null && _head.getBusArr().getLineNum() == line)
            {
                if(_head.getNext() != null)
                {
                    _head =_head.getNext();
                }
                else
                {
                    _head = null;
                }
            }
            if(_head != null && _head.getNext() != null)
            {
                BusArrivalNode first = _head;
                BusArrivalNode second = _head.getNext();
                while(second.getNext() != null)
                {
                    if(second.getBusArr().getLineNum() == line)
                    {
                        second = second.getNext();
                        first.setNext(second);
                    }
                    first = second;
                    second = second.getNext();
                }
                if(second.getBusArr().getLineNum() == line)
                {
                    first.setNext(null);
                }
            }
        }
    }

    /** public int getPopularLine()
     * @return Returns
     * returns the bus line that apper the most in the list.
     * 
     */
    public int getPopularLine()
    {
        int [] temp = new int[100];
        int popularLine = 0 , count = 0 , i = 0;
        BusArrivalNode dummy = _head;
        while(dummy != null)
        {
            if(temp[dummy.getBusArr().getLineNum()] == 0)
            {
                temp[dummy.getBusArr().getLineNum()] = 1;
            }
            else
            {
                temp[dummy.getBusArr().getLineNum()]++;
            }
            dummy = dummy.getNext();
        }
        while(i<temp.length)
        {
            if(temp[i] > temp[popularLine])
            {
                popularLine = i;
            }
            i++;
        }
        return popularLine ;
    }

    /** public long getAverageTime()
     * @return Returns
     * returns the avrage time that a passenger need to wait for a bus in seconds.
     * 
     */
    public long getAverageTime()
    {
        BusArrival earlest , latest;
        int count=0;
        BusArrivalNode dummy = _head;
        if(dummy.getBusArr().getArrivalTime().before(dummy.getNext().getBusArr().getArrivalTime()))
        {
            earlest = new BusArrival(dummy.getBusArr()); //creating a new BusArrival to check who is the earlest bus.
            latest = new BusArrival(dummy.getNext().getBusArr()); // //creating a new BusArrival to check who is the lastest bus.

        }
        else
        {
            latest = new BusArrival(dummy.getBusArr()); // //creating a new BusArrival to check who is the lastest bus.
            earlest = new BusArrival(dummy.getNext().getBusArr()); //creating a new BusArrival to check who is the earlest bus.

        }
        dummy = dummy.getNext();
        while(dummy != null)
        {
            if(earlest.getArrivalTime().before(dummy.getBusArr().getArrivalTime()))
            {
                earlest= dummy.getBusArr();
            }
            else if(latest.getArrivalTime().after(dummy.getBusArr().getArrivalTime()))
            {
                latest=dummy.getBusArr();
            }
            count++;
            dummy = dummy.getNext();
        }
        return Math.abs(earlest.getArrivalTime().difference(latest.getArrivalTime())/count);
    }

    /** public int totalPassengers()
     * @return Returns
     * returns the the total number of all the passenger of each bus in the list.
     */
    public int totalPassengers()
    {
        int totalPass = 0;
        BusArrivalNode dummy = _head;
        while(dummy != null)
        {
            totalPass = totalPass + dummy.getBusArr().getNoOfPass();
            dummy = dummy.getNext();
        }
        return totalPass;
    }

    /** public BusArrival maxPassengers()
     * @return Returns
     * returns the bus with the most passengers.
     * 
     */
    public BusArrival maxPassengers()
    {
        BusArrivalNode dummy =_head;
        BusArrival temp = new BusArrival(0,0,0,0,0);
        while(dummy != null)
        {
            if(temp.getNoOfPass() < dummy.getBusArr().getNoOfPass())
            {
                temp = dummy.getBusArr();
            }
            dummy = dummy.getNext();
        }
        return temp;
    }

    /** public String toString()
     * @return Returns
     * returns a string of all the buses details.
     * 
     */
    public String toString()
    {
        String str = ""; // creating a new string "str" to coustruct the string representation
        BusArrivalNode dummy = _head;
        while(dummy != null)
        {
            str = str + dummy.getBusArr().toString()+"\n";
        }
        return str;
    }
}
