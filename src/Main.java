import java.sql.SQLOutput;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        printIsLeapYear(2021);
        printOSAndAppVersions(0, 2012);
        calculateDeliveryDays(95);
    }

    public static void printIsLeapYearResult(int year, boolean yearIsLeap) {
        if (yearIsLeap) {
            System.out.println(year + " год високосный");
        } else {
            System.out.println(year + " год не является високосным");
        }
    }

    public static void printIsLeapYear(int year) {
        boolean yearIsLeap = isLeap(year);
        printIsLeapYearResult(year, yearIsLeap);
    }

    public static boolean isLeap(int year) {
        return year % 4 == 0 && year % 100 != 0 || year % 400 == 0;
    }

    public static void printOSAndAppVersions(int clientOS, int deviceYear) {

        boolean deviceIsOld = isDeviceOld(deviceYear);
        System.out.print("Установите ");
        if (deviceIsOld) {
            System.out.print("lite ");
        }
        System.out.print("версию для ");
        if (clientOS == 0) {
            System.out.println("iOS");
        } else {
            System.out.println("Android");
        }
    }

    public static boolean isDeviceOld(int deviceYear) {
        int currentYear = LocalDate.now().getYear();
        return deviceYear <= currentYear;
    }

    public static String calculateDeliveryDays(int deliveryDistance) {
        int deliveryDays = 1;
        if (deliveryDistance > 20) {
            deliveryDistance++;
        }
        if (deliveryDistance > 60 && deliveryDistance <= 100) {
            deliveryDays++;
        } else if (deliveryDistance > 100) {
            return "Невозможно рассчитать срок доставки";
        }
        return "Потребуется дней: " + deliveryDays;
    }
}