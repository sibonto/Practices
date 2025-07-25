import java.util.Scanner;

public class SayiDeseni {
    static int number(int n) {
        System.out.print(n + " ");
        if (n <= 0) {
            return n;
        }
        number(n - 5);
        System.out.print(n + " ");
        return n;
    }


    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Sayı giriniz: ");
        int n = scan.nextInt();
        number(n);

    }
}
