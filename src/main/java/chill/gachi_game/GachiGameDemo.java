package chill.gachi_game;

public class GachiGameDemo {
    public static void main(String[] args) {

        Josifs Josifs = new Josifs("Josifs", "5", 20, true, "black", "Gey");
        Mark Mark = new Mark("Mark", "99", 18, false, "white");

        Josifs.name();
        Mark.name();

        Josifs.sm();
        Mark.sm();

        Josifs.age();
        Mark.age();

        Josifs.waffle();
        Mark.waffle();

        Josifs.color();
        Mark.color();

        Josifs.geyOrNot();

    }
}
