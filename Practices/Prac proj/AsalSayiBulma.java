import java.util.Scanner;

public class AsalSayiBulma {
    static boolean asal(int n, int i) {
        if (n <= 1)
            return false;
        if (i * i > n)
            return true;
        if (n % i == 0)
            return false;

        return asal(n, i + 1);
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Bir sayı giriniz : ");
        int sayı = scan.nextInt();

        if (asal(sayı, 2)) {
            System.out.println(sayı + " Bir asal sayıdır.");
        } else {
            System.out.println(sayı + " Bir asal sayı değildir!");
        }
    }
}