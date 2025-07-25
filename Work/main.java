public class main {
    public static void main(String[] args) {
        Fighter Bedo = new Fighter("Bedo", 15, 90, 80, 50);
        Fighter Batu = new Fighter("Batu", 10, 100, 80, 50);
        Match match = new Match(Bedo, Batu, 60, 100);
        match.run();

    }
}