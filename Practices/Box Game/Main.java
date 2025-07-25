public class Main {
    public static void main(String[] args) {
        Fighter Bedo = new Fighter("Bedo", 15, 150, 82, 25, 25, 25);
        Fighter Batu = new Fighter("Batu", 15, 150, 82, 25, 25, 25);
        Match match = new Match(Bedo, Batu, 60, 100);
        match.run();

    }
}