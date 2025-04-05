package teme.pregatire.test1.s1.main;

import teme.pregatire.test1.s1.clase.Masina;
import teme.pregatire.test1.s1.clase.Sticker;
import teme.pregatire.test1.s1.clase.StickerFactory;

public class Main {
    public static void main(String[] args) throws CloneNotSupportedException {
        Masina m = new Masina("Golf 4", 2012, "300x300");
        StickerFactory factory = new StickerFactory();
        Sticker st = factory.getStickerforMasina(m);
        Sticker st2 = factory.getStickerforMasina(m);
        System.out.println(st);
        System.out.println(st2);
    }
}
