
/**
 * Represents a BusStop. BusStop is represented by a array of BusArrivals, number of buses.
 * 
 * @author (Matan Zilka) 
 * @version (12.12.15)
 */
public class BusStop
{
    private BusArrival[] _buses;
    private int _noOfBuses=0;
    private final int MAXBUSES  = 1000;

    /** public BusStop()
     *  Constructs default array of BusArrival. with the max place to insret buses.
     *  
     */
    public BusStop()
    {
        _buses = new BusArrival[MAXBUSES]; 
    }

    /** public BusStop (int busesNumber)
     * Constructs array of buses. with buses number.
     * @paramParameters:
     * @param busesNumber the number of buses in the array(should be between 1-1000).
     */
    public BusStop (int busesNumber)
    {
        if(busesNumber>1000 || 0>busesNumber)
            System.out.println(" Error in Array size, array wasnt created"); // if the size is worng the system wont create the arry.
        else
        {
            _buses = new BusArrival[busesNumber];
        }
    }

    /** public int getNoOfBuses()
     * Returns the number of the buses.
     * @return Returns:
     * The number of the buses.
     */
    public int getNoOfBuses()
    {
        _noOfBuses =0;
        for(int i=0;i<_buses.length;i++)
        {
            if(_buses[i]!=null)
                _noOfBuses ++;
        }
        return _noOfBuses;
    }

    /** BusArrival[] getBuses() 
     * Returns the array of the buses.
     * @Return Returns:
     * The array of the buses.
     */
    public BusArrival[] getBuses() 
    {
        BusArrival[] temp = new BusArrival[_noOfBuses];
        for(int i=0;i<_noOfBuses;i++)
        {
            temp[i] = new BusArrival(_buses[i]);
        }
        return  temp;
    }

    /** public boolean add(int line, int pass, Time1 t)
     * Add a new bus arrival to the array, and returns true if it succeeded and false if not succeeded.
     * @paramParameters:
     * @param line the bus line number.
     * @param pass the number of the passenger of the bus.
     * @param t the arrival time of the bus.
     * @return Returns:
     * True if the bus insert successfully to the array.
     */
    public boolean add(int line, int pass, Time1 t)
    {
        for(int i=0;i<_buses.length;i++)
        {
            if(_buses[i] == null)
            {
                _buses[i] = new BusArrival(line,pass,t);
                return true;
            }
        }
        return false;
    }

    /** public void removeAllLine(int line)
     * Remove a bus from the array.
     * @paramParameters:
     * @param line the bus line number that need to be remove from the arrray.
     */
    public void removeAllLine(int line)
    {
        for(int i=0;i<_buses.length;i++)
        { 
            if(_buses[i] != null)
                if(_buses[i].getLineNum() == line)
                {
                    _buses[i] = null;
                }
        }
        for(int i=0,j=1;j<_buses.length;)
        {
            if(_buses[i] == null)
            {
                if(_buses[j] != null)
                {
                    _buses[i] = _buses[j];
                    _buses[j] = null;
                }
                else
                    j++;
            }
            else
            {
                i++;
                j++;
            }
        }
    }

    /** public int getPopularLine()
     * Returns the bus line number that appeared the most.
     * @return Returns:
     * The bus line number that appeared the most
     */
    public int getPopularLine()
    {
        int [] temp = new int[2]; // creating a new int array with 2 place, 1 for the bus line which is the most popular line, and 1 to check how many time is he appeared.
        int popularLine=0 , count =0;

        for(int i=0;i<_buses.length;i++)
        {
            if(_buses[i] != null)
            {
                temp[0]=_buses[i].getLineNum();
                temp[1] = 0;
                for(int j=0;j<_buses.length;j++)
                {
                    if(_buses[j] != null)
                    {
                        if(_buses[j].getLineNum() == temp[0])
                            temp[1]++;
                    }
                }            
                if(temp[1]>count)
                {
                    count=temp[1];
                    popularLine = temp[0];
                }
            }
        }
        return popularLine;
    }

    /** public long getAverageTime()
     * Returns the waiting average time between all the buses.
     * @return Returns:
     * The waiting average time between all the buses.
     */
    public long getAverageTime()
    {
        int count=0;
        long sum=0;  
        BusArrival earlest = new BusArrival(_buses[0]); //creating a new BusArrival to check who is the earlest bus.
        BusArrival latest = new BusArrival(_buses[0]); // //creating a new BusArrival to check who is the lastest bus.
        for(int i=1;i<_buses.length;i++)
        {
            if(_buses[i] != null)
            {
                if(earlest.getArrivalTime().after(_buses[i].getArrivalTime()))
                {
                    earlest=_buses[i];
                }
                else if(latest.getArrivalTime().before(_buses[i].getArrivalTime()))
                {
                    latest=_buses[i]; 
                }
                count++;
            }
        }
        return Math.abs(earlest.getArrivalTime().difference(latest.getArrivalTime())/count);
    }

    /** public int totalPassengers()
     * Returns the total number of the passengers in all the buses.
     * @return Returns:
     * The total number of the passengers in all the buses.
     */
    public int totalPassengers()
    {
        int pass=0;
        for(int i=0;i<_buses.length;i++)
        {
            if(_buses[i]!= null)
                pass+=_buses[i].getNoOfPass();
        }
        return pass;
    }

    /** public BusArrival maxPassengers()
     * Returns the bus with the most passengers.
     * @return Returns:
     * The bus with the most passengers.
     */
    public BusArrival maxPassengers()
    {
        BusArrival temp = new BusArrival(0,0,0,0,0); // creating a new BusArrival to insert the bus with the most passengers and return it.
        for(int i=0;i<_buses.length;i++)
        {
            if(_buses[i] != null)
            {
                if(temp.getNoOfPass()<_buses[i].getNoOfPass())
                    temp = new BusArrival(_buses[i]);
            }
        }
        return temp;
    }

    /** public java.lang.String toString()
     *  Returns a string representation of this BusStop  (for example: "Bus no. 27 arrived at 09:24:10 with 13 passengers"
     *                                                                 "Bus no. 12 arrived at 12:54:32 with 2 passengers").
     *  Overrides:
     *  toString in class java.lang.Object
     *  @return Returns:
     *  string representation of this BusStop  (for example: "Bus no. 27 arrived at 09:24:10 with 13 passengers"
     *                                                       "Bus no. 12 arrived at 12:54:32 with 2 passengers"). 
     */
    public String toString()
    {
        String str = ""; // creating a new string "str" to coustruct the string representation
        for(int i=0;i<_buses.length;i++)
        {
            if(_buses[i] != null)
                str+=_buses[i].toString()+"\n";
        }
        return str;
    }
}