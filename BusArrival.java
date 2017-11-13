
/**
 * Represents a BusArrival. BusArrival is represented by its line number, arrival time, number Of passengers.
 * 
 * @author (Matan) 
 * @version (28/11/15)
 */
public class BusArrival
{
    private int _lineNumber,_noOfPassengers;
    private Time1 _arrivalTime; 
    private final int MAX=70;
/**  Constructs a BusArrival object. with line number, number of passengers, and time(hour, minute and second) of arrival if the parameters are illegal they will be set to 0.
     @paramParameters:
     @param lineNum  The bus line number (should be between 1-99)
     @param pass  The number of passengers (should be between 0-70)
     @param h  The hour of bus arrival (should be between 0-23)
     @param m  The minute of bus arrival (should be between 0-59)
     @param s  The second of bus arrival (should be between 0-59)
     * 
     */
    public BusArrival(int lineNum, int pass, int h, int m, int s)
    {
        if(lineNum>0 && lineNum<100)
        _lineNumber=lineNum;
        else
        _lineNumber=1;    
        if(pass>-1 && pass<MAX+1)
        _noOfPassengers = pass;
        else
        _noOfPassengers = 0;
        _arrivalTime = new Time1(h,m,s);
    }
    /** public BusArrival(int lineNum,
                  int pass,
                  Time1 t)
Constructs BusArrival object. with line number, number of passengers, and time of arrival if the parameters are illegal they will be set to 0.
@paramParameters:
@param lineNum  The bus line number (should be between 1-99)
@param pass  The number of passengers (should be between 0-70)
@param t  The time of bus arrival
     * 
     */
    public BusArrival(int lineNum , int pass , Time1 t)
    {
        if(lineNum>0 && lineNum<100)
        _lineNumber=lineNum;
        else
        _lineNumber=1;    
        if(pass>-1 && pass<MAX+1)
        _noOfPassengers = pass;
        else
        _noOfPassengers = 0;
        Time1 _arrivalTime = new Time1(t);
    }
    /** public BusArrival(BusArrival other)
Copy constructor for a BusArrival. Constructs a BusArrival with the same attributes as another BusArrival.
@paramParameters:
@param other  The BusArrival object from which to construct the new BusArrival.
     * 
     */
    public BusArrival(BusArrival other) 
    {
        _lineNumber = other._lineNumber;
        _noOfPassengers = other._noOfPassengers;
        _arrivalTime = new Time1(other._arrivalTime.getHour(), other._arrivalTime.getMinute(),other._arrivalTime.getSecond());  
    }
    /** public int getLineNum()
Returns the bus line number.
@return Returns:
the bus line number.
     * 
     */
    public int getLineNum() 
    {
        return _lineNumber;
    }
    /** public int getNoOfPass()
Returns the number of passengers.
@return Returns:
the number of passengers.
     * 
     */
    public int getNoOfPass() 
    {
        return _noOfPassengers;
    }
    /** public Time1 getArrivalTime()
Returns the bus arrival time.
@return Returns:
the bus arrival time
     * 
     */
    public Time1 getArrivalTime()
    {
        return new Time1(_arrivalTime);
    }
    /** public void setLineNum(int num)
Changes the BusArrival's line number. if the parameter is illegal the line number will remain unchanged
@paramParameters:
@param num  The BusArrival's new line number.
     * 
     */
    public void setLineNum(int num) 
    {
        if(num>0 && num <100)
        this._lineNumber = num;
        else
        System.out.println("Please put a number between 1 to 99");
    }
    /** public void setNoOfPass(int num)
Changes the BusArrival's number of passengers. if the parameter is illegal the number of passengers will remain unchanged
@paramParameters:
@param num  The BusArrival's new number of passengers.

     * 
     */
    // this function gets number and check if the number between 0-70 and replacing it with the old number, if not he doesnt change anything.
    public void setNoOfPass (int num) 
    {
        if(num>-1 && num<MAX+1)
        this._noOfPassengers = num;
        else
        System.out.println("Please put a number between 0 to 70");
    }
    /**public void setArrivalTime(Time1 t)
Changes the BusArrival's time.
@paramParameters:
@param t  The BusArrival's new time.
*/
    public void setArrivalTime(Time1 t)
    {
        this._arrivalTime = new Time1(t);
    }
    /** public boolean equals(BusArrival other)
Checks if the received BusArrival is equal to this BusArrival.
@paramParameters:
@param other  The BusArrival to be compared with this BusArrival
@return Returns:
True if the received BusArrival is equal to this BusArrival

     * 
     */
    public boolean equals (BusArrival other)
    {
        return (this._lineNumber == other._lineNumber && this._noOfPassengers == other._noOfPassengers && this._arrivalTime.getHour() == other._arrivalTime.getHour() && this._arrivalTime.getMinute() == other._arrivalTime.getMinute() && this._arrivalTime.getSecond() == other._arrivalTime.getSecond());
    }
    /**public java.lang.String toString()
Returns a string representation of this BusArrival (for example: "Bus no. 27 arrived at 09:24:10 with 13 passengers").
Overrides:
toString in class java.lang.Object
@return Returns:
String representation of this BusArrival (for example: "Bus no. 27 arrived at 09:24:10 with 13 passengers").
     * 
     */
    public String toString()
    {
        return "Bus no. "+_lineNumber+" arrived at "+_arrivalTime.toString()+" with "+_noOfPassengers+" passengers";
    }
    /** public boolean fuller(BusArrival other)
Checks if this bus's number of passengers is larger than other bus's number of passengers.
@paramParameters:
@param other  The BusArrival to be compared with this BusArrival
@return Returns:
true if this bus's number of passengers is larger than other bus's number of passengers. false otherwise
     * 
     */
    //this function get 2 BusArrival parameters and check if the first bus if fulller then the other bus.
    public boolean fuller (BusArrival other)
    {
        return (this._noOfPassengers > other._noOfPassengers);
    }
    /** public boolean before(BusArrival other)
Checks if this bus's arrival time is before other bus's arrival time.
@paramParameters:
@param other  The BusArrival to be compared with this BusArrival
@return Returns:
true if this bus's arrival time is before other bus's arrival time. false otherwise
     * 
     */
    public boolean before (BusArrival other)
    {
        if(this._arrivalTime.getHour() < other._arrivalTime.getHour())
        return true;
        else if(this._arrivalTime.getHour() > other._arrivalTime.getHour() || this.equals(other))
        return false;
        else if(this._arrivalTime.getMinute() < other._arrivalTime.getMinute())
        return true;
        else if(this._arrivalTime.getMinute() > other._arrivalTime.getMinute())
        return false;
        else if(this._arrivalTime.getSecond() < other._arrivalTime.getSecond())
        return true;
        else 
        return false;
    }
    /** public boolean isFull()
Checks if this bus's number of passengers is equal to the maximum number of passengers allowed.
@return Returns:
true if this bus's number of passengers is equal to the maximum number of passengers allowed. false otherwise
     * 
     */
    public boolean isFull ()
    {
        return (_noOfPassengers >= MAX);
    }
    /** public int elapsedTime(BusArrival other)
Calculates the difference (in minutes) between this bus arrival time and other.
@paramParameters:
@param other  The time to check the difference with.
@return Returns:
int difference in minutes
     * 
     */
    public int elapsedTime (BusArrival other) 
    {
        if(this.before(other))
        {
            return ((int)other.getArrivalTime().secFromMidnight() - (int)this.getArrivalTime().secFromMidnight())/60;
        }
        else
        {
        return ((int)this.getArrivalTime().secFromMidnight()  - (int)other.getArrivalTime().secFromMidnight())/60;
        }
    }
}
