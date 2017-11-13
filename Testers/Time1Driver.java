
public class Time1Driver {
    public static void main(String[] args) {
        Time1 firstTime = new Time1(2, 15, 32);
        Time1 secondTime = new Time1(firstTime);

        System.out.println("The hour of first Time1 object is: " + firstTime.getHour());
        System.out.println("The minute of first Time1 object is: " + firstTime.getMinute());
        System.out.println("The second of first Time1 object is: " + firstTime.getSecond());

        secondTime.setHour(23);
        secondTime.setMinute(20);
        secondTime.setSecond(45);

        System.out.println("The hour of second Time1 object is: " + secondTime.getHour());
        System.out.println("The minute of second Time1 object is: " + secondTime.getMinute());
        System.out.println("The second of second Time1 object is: " + secondTime.getSecond());

        System.out.println("Is the first time equal to the second time? " + firstTime.equals(secondTime));

        System.out.println("Is the first time before the second time? " + firstTime.before(secondTime));

        System.out.println("Is the first time after the second time? " + firstTime.after(secondTime));

        System.out.println("The difference in seconds between the second and first time is: " + secondTime.difference(firstTime));

        System.out.println("The string representation of the first time is: " + firstTime.toString());
    }
}
