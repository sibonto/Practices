import java.util.Scanner;

class UsHesaplamaNegatifDahil {

    static double base(int a, int b) {

        double result = 1;

        if (b == 0) {
            return 1;
        } else if (b > 0) {
            for (int i = 1; i <= b; i++) {
                result *= a;
            }
        } else {
            // negatif üs
            for (int i = 1; i <= -b; i++) {
                result *= a;
            }
            result = 1 / result;
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Taban değeri giriniz: ");
        int a = sc.nextInt();

        System.out.print("Üs değeri giriniz: ");
        int b = sc.nextInt();

        double result = base(a, b);
        System.out.println(a + " üzeri " + b + " = " + result);
    }
}