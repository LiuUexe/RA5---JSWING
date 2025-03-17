package libraries;

import java.util.Scanner;

public class Scanners {

    public static int scannerInt() {
        Scanner sc = new Scanner(System.in);
        while (true) {
            try {
                return sc.nextInt();

            } catch (Exception e) {
                System.out.println("Only Numbers, Try Again");
                sc.nextLine();
            }
        }

    }

    public static String scannerLine() {
        Scanner sc = new Scanner(System.in);
        while (true) {
            try {
                return sc.nextLine();
            } catch (Exception e) {
                System.out.println("Only Texts, Try Again");
                sc.nextLine();
            }
        }

    }

    public static Boolean scannerBoolean() {
        Scanner sc = new Scanner(System.in);
        while (true) {
            try {
                return sc.nextBoolean();
            } catch (Exception e) {
                System.out.println("Only True or False, Try Again");
                sc.nextLine();
            }
        }

    }

    public static Double scannerDouble() {
        Scanner sc = new Scanner(System.in);
        while (true) {
            try {
                return sc.nextDouble();
            } catch (Exception e) {
                System.out.println("Only Decimals, Try Again");
                sc.nextLine();
            }
        }

    }

}
