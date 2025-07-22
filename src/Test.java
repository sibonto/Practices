import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        int number, total = 0, per = 0;
        Scanner input = new Scanner(System.in);

        System.out.print("Enter a number: ");
        number = input.nextInt();
        while (number <= 0) {
            System.out.println("Sayı 0'dan büyük olmalı. Sayıyı Tekrar Giriniz: ");
            number = input.nextInt();

        }

        for (int i = 1; i <= number; i++) {
            if ((i % 3 == 0) && (i % 4 == 0)) {
                total += i;
                per++;

            }
        }
        if (per > 0) {
            int avg = (int) total / per;
            System.out.println("3 ve 4'e tam bölünen sayıların ortalaması: " + avg);
        } else {
            System.out.println("0'dan" + number + "'ye kadar 3 ve 4'e tam bölünen sayı yok.");
        }


    }
}