public class BusStopTest
{
public static void main (String args[]) {
BusStop b1 = new BusStop();
Time1 t1 = new Time1 (10,5,24);
Time1 t2 = new Time1 (9,5,5);
Time1 t3 = new Time1 (8,0,5);
Time1 t4 = new Time1 (7,0,5);
b1.add(4,25,t1);
b1.add(2,20,t2);
b1.add(5,30,t3);
b1.add(5,10,t4);
b1.add(3,40,t2);
b1.add(2,30,t3);
b1.add(5,55,t3);
System.out.print (b1);
System.out.println ("number of buses = " + b1.getNoOfBuses());
System.out.println ("average time = " + b1.getAverageTime());
System.out.println ("popular line = " + b1.getPopularLine());
System.out.println ("bus with max passengers");
System.out.println (b1.maxPassengers());
System.out.println ("total passengers = " + b1.totalPassengers());
BusArrival[] b2 = b1.getBuses();
System.out.println ("printing array");
for (int i=0;i < b2.length;i++)
System.out.println (b2[i]);
b1.removeAllLine(5);
System.out.println ("removing lines");
System.out.print (b1);
System.out.println ("number of buses = " + b1.getNoOfBuses());
System.out.println ("average time = " + b1.getAverageTime());
System.out.println ("popular line = " + b1.getPopularLine());
System.out.println ("bus with max passengers");
System.out.println (b1.maxPassengers());
System.out.println ("total passengers = " + b1.totalPassengers());
System.out.println ("Adding additional busses to the array.");
b1.add(11,25,t1);
b1.add(22,20,t2);
b1.add(33,30,t3);
b1.add(44,10,t4);
System.out.println ("Printing array: ");
System.out.println (b1.toString());
System.out.println ("number of buses = " + b1.getNoOfBuses());
System.out.println ("Cheers!");

BusStop stop = new BusStop(3);
Time1 t5 = new Time1(1, 1, 1);
Time1 t6 = new Time1(2, 2, 2);
Time1 t7 = new Time1(3, 3, 3);

//Checking add method.
stop.add(1, 1, t5);
t5.setHour(5);
System.out.println("if u see a 5 here- u fail:) \n" + stop);

//Cheking getBuses method.
BusArrival[] stopArr = stop.getBuses();
stopArr[0].setLineNum(5);
System.out.println("Another 5, but means the same.. \n" + stop);

System.out.print("Note: In the add method, The problem might also" +
"\ncome from the BusArrival or even the Time1 Classes."+
"\nSo if you use your own Classes check your grades for them first:)");
}
}	