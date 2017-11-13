
public class BusArrivalDriver {
    public static void main(String[] args) {
        BusArrival firstBusArrival = new BusArrival(20, 55, 10, 0, 0);

        Time1 time1 = new Time1(16, 15, 0);
        BusArrival secondBusArrival = new BusArrival(18, 30, time1);

        BusArrival thirdBusArrival = new BusArrival(secondBusArrival);

        System.out.println("The line number of the first BusArrival object is: " + firstBusArrival.getLineNum());
        System.out.println("The number of passengers of the first BusArrival object is: " + firstBusArrival.getNoOfPass());
        System.out.println("The arrival time of the first BusArrival object is: " + firstBusArrival.getArrivalTime());

        firstBusArrival.setLineNum(35);
        firstBusArrival.setNoOfPass(24);
        firstBusArrival.setArrivalTime(new Time1(12, 20, 15));
        

        System.out.println("The line number of the first BusArrival object after re-setting it is: " + firstBusArrival.getLineNum());
        System.out.println("The number of passengers of first BusArrival object after re-setting it is: " + firstBusArrival.getNoOfPass());
        System.out.println("The arrival time of the first BusArrival object after re-setting it is: " + firstBusArrival.getArrivalTime());

        System.out.println("Is the first bus full? " + firstBusArrival.isFull());

        System.out.println("Is the second and third BusArrival objects equal? " + secondBusArrival.equals(thirdBusArrival));

        System.out.println("Is the second BusArrival before the first BusArrival? " + secondBusArrival.before(firstBusArrival));

        System.out.println("Is the third BusArrival fuller than the first BusArrival? " + thirdBusArrival.fuller(firstBusArrival));

        System.out.println("The elapsed time between the second and the first BusArrival objects is: " + secondBusArrival.elapsedTime(firstBusArrival));

        System.out.println("The string representation of the first BusArrival object is: " + firstBusArrival.toString());
    }
}
