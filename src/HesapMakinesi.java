import java.util.Scanner;

public class HesapMakinesi {
    static void plus() {
        Scanner input = new Scanner(System.in);
        int number, result = 0, i = 1;
        while (true) {
            System.out.print(i++ + ". Sayı: ");
            number = input.nextInt();
            if (number == 0) {
                break;
            }
            result += number;
        }
        System.out.println("Sonuç: " + result);
    }

    static void minus() {
        Scanner input = new Scanner(System.in);
        System.out.print("Kaç adet sayı gireceksiniz: ");
        int counter = input.nextInt();
        int number, result = 0;

        for (int i = 1; i <= counter; i++) {
            System.out.print(i + ". sayı: ");
            number = input.nextInt();
            if (i == 1) {
                result += number;
                continue;
            }
            result -= number;
        }
        System.out.println("Sonuç: " + result);
    }

    static void multiply() {
        Scanner input = new Scanner(System.in);
        System.out.print("Kaç adet sayı gireceksiniz: ");
        int counter = input.nextInt();
        int number, result = 0, i = 1;
        for (i = 1; i <= counter; i++) {
            System.out.print(i + ". sayı: ");
            number = input.nextInt();
            if (i == 1) {
                result += number;
                continue;
            }
            result *= number;
        }
        System.out.println("Sonuç: " + result);
    }

    static void divide() {
        Scanner input = new Scanner(System.in);
        System.out.print("Kaç adet sayı gireceksiniz:  ");
        int counter = input.nextInt();
        double number, result = 0.0;

        for (int i = 1; i <= counter; i++) {
            while (true) {
                System.out.print(i + ". sayı: ");
                number = input.nextDouble();

                if (number == 0 && i != 1) {
                    System.out.println("Böleni 0 giremezsiniz. Lütfen tekrar girin.");

                } else {
                    break;
                }
            }
            if (i == 1) {
                result += number;
                continue;
            }
            result /= number;
        }
        System.out.println("Sonuç: " + result);
    }

    static void square() {
        Scanner input = new Scanner(System.in);
        int result = 1;
        System.out.print("Taban değeri giriniz: ");
        int base = input.nextInt();
        System.out.print("Üs değeri giriniz: ");
        int power = input.nextInt();
        for (int i = 1; i <= power; i++) {
            result *= base;
            if (power == 0) {
                base = 1;
            }
        }
        System.out.println("Sonuç: " + result);
    }

    static void factorial() {
        Scanner input = new Scanner(System.in);
        int result = 1;
        System.out.print("Faktöriyelini hesaplamak istediğiniz sayıyı giriniz: ");
        int factorial = input.nextInt();
        for (int i = 1; i <= factorial; i++) {
            result *= i;
        }
        System.out.println(factorial + " sayısının faktöriyeli: " + result);
    }

    static void module() {
        Scanner input = new Scanner(System.in);
        System.out.print("Sayı giriniz: ");
        int m1 = input.nextInt();

        System.out.print("Mod alınacak sayıyı giriniz: ");
        int m2 = input.nextInt();

        int result = m1 % m2;

        System.out.println("Mod: " + result);
    }

    static void alanvecevre() {
        Scanner input = new Scanner(System.in);

            System.out.print("Uzun kenarı giriniz: ");
            int uzun = input.nextInt();
            System.out.print("Kısa kenarı giriniz: ");
            int kisa = input.nextInt();
            int alan, cevre, result;
            alan = uzun * kisa;
            cevre = ((uzun + kisa) * 2);
            while (true) {
                if (uzun == 0 || kisa == 0) {
                    System.out.print("Kenar uzunluğu 0 olamaz. Tekrar giriniz.");
                } else {
                    break;
                }
            }
            System.out.println("Alan: " + alan + "\nÇevre: " + cevre);
        }


    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int select;

        String menu = "1-Toplama İşlemi\n"
                + "2-Çıkarma İşlemi\n"
                + "3-Çarpma İşlemi\n"
                + "4-Bölme İşlemi\n"
                + "5-Üslü Sayı Hesaplama\n"
                + "6-Faktöriyel Hesaplama\n"
                + "7-Mod Alma\n"
                + "8-Dikdörtgen Alan ve Çevre Hesabı\n"
                + "0-Çıkış Yap";
        do {
            System.out.println(menu);
            System.out.print("Yapmak istediğiniz işlemi seçiniz: ");
            select = sc.nextInt();
            switch (select) {
                case 1:
                    plus();
                    break;
                case 2:
                    minus();
                    break;
                case 3:
                    multiply();
                    break;
                case 4:
                    divide();
                    break;
                case 5:
                    square();
                    break;
                case 6:
                    factorial();
                    break;
                case 7:
                    module();
                    break;
                case 8:
                    alanvecevre();
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Yanlış bir değer girdiniz, tekrar deneyiniz.");
            }
        } while (select != 0);
        System.out.println("Güle Güle");

    }
}
