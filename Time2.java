
/**
 *  Represents time - hours:minutes:seconds. Values must represent a proper time. 
 * 
 * @author (yMatan Zilka) 
 * @version (28/11/15)
 */public class Time2 
{
    private long _secFromMid;
    
    /** public Time2(int h,
             int m,
             int s)
Constructs a Time2 object. Construct a new time instance with the specified hour, minute and second. hour should be between 0-23, otherwise it should be set to 0. minute and second should be between 0-59, otherwise they should be set to 0.
@paramParameters:
@param h  hour
@param m  minute
@param s  second
     * 
     */
    public Time2(int h, int m , int s)
    {
        if(-1 < h && h < 24)
        _secFromMid = h*60*60;
        else
        {
        _secFromMid = 0;
        }
        if(-1 < m && m < 60)
        _secFromMid += m*60;
        else
        {
        _secFromMid += 0;
        }
        if(-1 < s && s <60)
        _secFromMid += s;  
        else
        {
        _secFromMid += 0;
        }
    }
    /** public Time2(Time2 other)
Copy constructor for Time2. Constructs a time with the same variables as another time.
@paramParameters:
@param other  The time object from which to construct the new time
     * 
     */
    public Time2(Time2 other)
    {
        _secFromMid = other._secFromMid;
    }
    /** public int getHour()
Returns the hour of the time.
@return Returns:
The hour of the time
     * 
     */
    // the function get the send the hour in second.
    public long getHour()
    {
        return _secFromMid/60/60;
    }
    /** public int getHour()
Returns the hour of the time.
@return Returns:
The hour of the time
     * 
     */
        public long getMinute()
    {
        return _secFromMid/60%60;
    }
    /** public int getSecond()
Returns the second of the time.
@return Returns:
The second of the time
     * 
     */
        public long getSecond()
    {
        return _secFromMid%60;
    }
    /** public void setHour(int num)
Changes the hour of the time. If illegal number is received hour will remain unchanged.
@paramParameters:
@param num  The new hour

     * 
     */
    // the function reset the hour in second if the input is between 0-23.
    public void setHour(int num)
    {
        if( num > -1  && num <24)
        {
            long temp = _secFromMid;
            temp = temp/60/60;
            _secFromMid = _secFromMid - (temp*60*60) + (num*60*60);
        }
    }
    /** public void setMinute(int num)
Changes the minute of the time. If illegal number is received minute will remain unchanged.
@paramParameters:
@param num  The new minute
     * 
     */
        public void setMinute (int num)
    {
        if( num > -1  && num <60)
        {
            long temp = _secFromMid;
            temp = temp/60%60;
            _secFromMid = _secFromMid - (temp*60) + (num*60);
        }
    }
    /** public void setSecond(int num)
Changes the second of the time. If illegal number is received second will remain unchanged.
@paramParameters:
@param num  The new second
     * 
     */
        public void setSecond(int num)
    {
        if( num > -1  && num <60)
        {
            _secFromMid -= _secFromMid%60;
            _secFromMid += num;
        }
    }
    /** public long secFromMidnight()
Calculate seconds since midnight.
@return Returns:
Seconds passed since midnight
     * 
     */
        public long secFromMidnight ()
    {
        return _secFromMid;
    }
    /** public java.lang.String toString()
Returns a string representation of this time(hh:mm:ss).
Overrides:
toString in class java.lang.Object
@return Returns:
String representation of this time(hh:mm:ss).
     * 
     */
    // this function check if the parameters is between 1-9 then it print the parameter with 0 before him' otherwise it print it as it is.
    public String toString()
    {
        String s;
        if(_secFromMid/60/60<10)
        s="0"+_secFromMid/60/60+":";
        else
        s=_secFromMid/60/60+":";
        if(_secFromMid/60%60<10)
        s+= "0"+_secFromMid/60%60+":";
        else
        s+=_secFromMid/60%60+":";
        if(_secFromMid%60<10)
        s+="0"+_secFromMid%60;
        else
        s+=_secFromMid%60;
        return (s);
    }
    /** public boolean equals(Time2 other)
Checks if the received time is equal to this time.
@paramParameters:
@param other  The time to be compared with this time
@return Returns:
True if the received time is equal to this time
     * 
     */
    public boolean equals(Time2 other)
    {
        return this._secFromMid == other._secFromMid;
    }
    /** public boolean before(Time2 other)
Checks if this time is before a received time.
@paramParameters:
@param other  The time to check if this time is before
@return Returns:
True if this time is before other time

     * 
     */
    public boolean before (Time2 other)
    {
        return (this._secFromMid < other._secFromMid);
    }
    /** public boolean after(Time2 other)
Checks if this time is after a received time.
@paramParameters:
@param other  The time to check if this time is after
@return Returns:
True if this time is after other time
     * 
     */
    public boolean after (Time2 other)
    {
        if(this.before(other) || this._secFromMid == other._secFromMid)
        	return false;
        else 
        	return true;
    }
    /** public int difference(Time2 other)
Calculates the difference (in seconds) between two times.
@paramParameters:
@param other  The time to check the difference with. Assumption: this time is after other time
@return Returns:
int difference in seconds
     * 
     */
    public int difference(Time2 other) 
    {
        if(this.after(other))
        return (int)this._secFromMid - (int)other._secFromMid;
        else
        return (int)other._secFromMid - (int)this._secFromMid;
    }
}