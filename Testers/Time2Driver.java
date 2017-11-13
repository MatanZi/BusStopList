
public class Time2Driver {

    public static void main(String[] args) {
        Time2 firstTime = new Time2(18, 33, 59);
        Time2 secondTime = new Time2(firstTime);

        System.out.println("The hour of first Time2 object is: " + firstTime.getHour());
        System.out.println("The minute of first Time2 object is: " + firstTime.getMinute());
        System.out.println("The second of first Time2 object is: " + firstTime.getSecond());

        secondTime.setHour(16);
        secondTime.setMinute(55);
        secondTime.setSecond(21);

        System.out.println("The hour of second Time2 object is: " + secondTime.getHour());
        System.out.println("The minute of second Time2 object is: " + secondTime.getMinute());
        System.out.println("The second of second Time2 object is: " + secondTime.getSecond());

        System.out.println("Is the first time equal to the second time? " + firstTime.equals(secondTime));

        System.out.println("Is the first time before the second time? " + firstTime.before(secondTime));

        System.out.println("Is the first time after the second time? " + firstTime.after(secondTime));

        System.out.println("The difference in seconds between the first and second time is: " + firstTime.difference(secondTime));

        System.out.println("The string representation of the first time is: " + firstTime.toString());
    }
}
