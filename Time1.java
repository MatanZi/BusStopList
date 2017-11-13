
/**
 * Represents time - hours:minutes:seconds. Values must represent a proper time.
 * 
 * @author (Matan Zilka) 
 * @version (28/11/15)
 */

public class Time1 
{
    private int _hour , _minute , _second;
    /**
     * public Time1(int h,
             int m,
             int s)

             
             Constructs a Time1 object . Constructs a new time instance with the specified hour, minute and second. hour should be between 0-23, otherwise it should be set to 0. minute and second should be between 0-59, otherwise they should be set to 0.

             @paramParameters:

             @param h  hour

             @param m  minute

             @param s  second
*/
    public Time1(int hour, int minute , int second)
    {
        if(-1 < hour && hour < 24)
        _hour = hour; 
        else
        {
            _hour = 0;
        }
        if(-1 < minute && minute < 60)
        _minute = minute;
        else
        {
            _minute = 0;
        }
        if(-1 < second && second < 60)
        _second = second;  
        else
        {
            _second = 0;
        }
    }
     /** public Time1(Time1 other)
     * Copy constructor for Time1. Constructs a time with the same variables as another time.
     * @paramParameters:
     * @param other The time object from which to construct the new time
     * 
     */

    public Time1(Time1 other)
    {
        _hour = other._hour;
        _minute = other._minute;
        _second = other._second;  
    }
    /** public int getHour() 
     * Returns the hour of the time.
     * @return Returns:
     * The hour of the time
     * 
     */
    public int getHour()
    {
        return _hour;
    }
    /**  getMinute
     * public int getMinute()
     * Returns the minute of the time.
     * @return Returns:
     * The minute of the time
     * 
     */
        public int getMinute()
    {
        return _minute;
    }
    /** public int getSecond()
     * Returns the second of the time.
     * @return Returns:
     * The second of the time
     * 
     */
        public int getSecond()
    {
        return _second;
    }
    /** public void setHour(int num)
     * Changes the hour of the time. If illegal number is received hour will remain unchanged.
     * @paramParameters:
     * @param num  The new hour
     * 
     */
    public void setHour(int num)
    {
        if( num > -1  && num <24)
        _hour = num;
    }
    /**  public void setMinute(int num)
     * Changes the minute of the time. If illegal number is received minute will remain unchanged.
     * @paramParameters:
     * @param num  The new minute
     * 
     */
        public void setMinute (int num)
    {
        if( num > -1  && num <60)
        _minute = num;
    }
    /** public void setSecond(int num)
     * Changes the second of the time. If illegal number is received second will remain unchanged.
     * @paramParameters:
     * @param num  The new second
     * 
     */
        public void setSecond(int num)
    {
        if( num > -1  && num <60)
        _second = num;
    }
    /**  Returns a string representation of this time (hh:mm:ss).
     * Overrides:
     * toString in class java.lang.Object
     * @return Returns:
     * String representation of this time (hh:mm:ss).
     * 
     */
    public String toString()
    {
        String s;
        if(_hour<10)
        s="0"+_hour+":";
        else
        s=_hour+":";
        if(_minute<10)
        s+= "0"+_minute+":";
        else
        s+=_minute+":";
        if(_second<10)
        s+="0"+_second;
        else
        s+=_second;
        return (s);
    }
    /** public long secFromMidnight()
     * Calculate seconds since midnight.
     * @return Returns:
     * Seconds passed since midnight
     * 
     */
    // secFromMidnight the whole time into seconds.
    public long secFromMidnight ()
    {
        return ((_hour*60)*60) + (_minute*60) + _second;
    }
    /** public boolean equals(Time1 other)
     * Checks if the received time is equal to this time.
     * @paramParameters:
     * @param other  The time to be compared with this time
     * @return Returns:
     * True if the received time is equal to this time
     * 
     */
    // equals compare between 2 Time1 parameters and send true is the both equals' flase otherwise.
    public boolean equals(Time1 other)
    {
        return this._hour == other._hour && this._minute == other._minute && this._second == other._second;
    }
    /** public boolean before(Time1 other)
     * Checks if this time is before a received time.
     * @paramParameters:
     * @param other  The time to check if this time is before
     * @return Returns:
     * True if this time is before other time.
     * 
     */
    // checks between 2 Time1 parameters who is the first time to come and return it.
    public boolean before (Time1 other)
    {
        if(this._hour < other._hour)
        return true;
        else if(this._hour > other._hour || this.equals(other))
        return false;
        else if(this._minute < other._minute)
        return true;
        else if(this._minute > other._minute)
        return false;
        else if(this._second < other._second)
        return true;
        else 
        return false;
    }
    /**  public boolean after(Time1 other)
     * Checks if this time is after a received time.
     * @paramParameters:
     * @param other  The time to check if this time is after
     * @return Returns:
     * True if this time is after other time
     * 
     */
    public boolean after (Time1 other)
    {
        if(this.before(other) || (this._hour == other._hour && this._minute == other._minute && this._second == other._second))
        	return false;
        else 
        	return true;
    }
    /** public int difference(Time1 other)
     * Calculates the difference (in seconds) between two times.
     * @paramParameters:
     * @param other  The time to check the difference with. Assumption: this time is after other time
     * @return Returns:
     * int difference in seconds
     * 
     */
    public int difference (Time1 other) 
    {
        return ((this._hour - other._hour)*60*60) + ((this._minute - other._minute)*60) + (this._second - other._second);
    }
}
