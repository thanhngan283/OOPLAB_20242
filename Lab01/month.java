 import java.util.Scanner;

public class DaysInMonth {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int month, year;

        while (true) {
            System.out.print("Enter month : ");
            String monthInput = input.nextLine();

            System.out.print("Enter year: ");
            year = input.nextInt();
            input.nextLine(); 
            month = getMonthNumber(monthInput);

            if (month != -1 && year >= 0) {
                break;
            } else {
                System.out.println("Invalid month or year. Please enter again.");
            }
        }

        int days = getDaysInMonth(month, year);
        System.out.println("Number of days in month " + month + " year " + year + " is: " + days);
    }

    public static int getMonthNumber(String monthInput) {
        String[] months = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
        String[] abbreviations = {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};

        try {
            int month = Integer.parseInt(monthInput);
            if (month >= 1 && month <= 12) {
                return month;
            }
        } catch (NumberFormatException e) {
            for (int i = 0; i < months.length; i++) {
                if (months[i].equalsIgnoreCase(monthInput) || abbreviations[i].equalsIgnoreCase(monthInput) || months[i].substring(0, 3).equalsIgnoreCase(monthInput)) {
                    return i + 1;
                }
            }
        }

        return -1;
    }

    public static int getDaysInMonth(int month, int year) {
        int[] daysInMonth = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

        if (month == 2 && isLeapYear(year)) {
            return 29;
        } else {
            return daysInMonth[month - 1];
        }
    }

    public static boolean isLeapYear(int year) {
        if (year % 400 == 0) {
            return true;
        } else if (year % 100 == 0) {
            return false;
        } else {
            return year % 4 == 0;
        }
    }
}