import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        String[] isimler = {"Fuat", "Sadık", "Nihat", "Bedo", "Batu"};
        int toplam = 0;

        for (int i = 0; i < isimler.length; i++) {
            System.out.print(isimler[i] + " için IQ girin: ");
            int iq = input.nextInt();
            toplam += iq;
        }

        double ortalama = (double) toplam / isimler.length;
        System.out.println("Girilen IQ'ların ortalaması: " + ortalama);
    }
}