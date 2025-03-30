package teme.tema4.main;

import teme.tema4.builder.MagazinBuilder;

public class Program {

    public static void main(String[] args) throws Exception {
        MagazinBuilder builder = new MagazinBuilder();

        var magazin1 = builder.setDenumire("Magazin 1")
                .setSuprafata(200)
                .setNrIntrari(2)
                .setPodeauaStandard(true)
                .setDuritate(3.5)
                .addMaterialDecoratiuni("Lemn")
                .build();
        System.out.println("Magazin 1: " + magazin1);

        try {
            var magazin2 = builder.setDenumire("Magazin 2")
                    .setSuprafata(300)
                    .setNrIntrari(4)
                    .setDuritate(1)
                    .addMaterialDecoratiuni("Sticla")
                    .addMaterialDecoratiuni("Lemn")
                    .build();
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }

        var magazin3 = builder.setDenumire("Magazin 3")
                .setSuprafata(300)
                .setNrIntrari(4)
                .setDuritate(8)
                .setPodeauaStandard(false)
                .addMaterialDecoratiuni("Sticla")
                .addMaterialDecoratiuni("Lemn")
                .build();

        System.out.println(magazin3);
        System.out.println("Grad incendiu " + magazin3.calculGradIncendiu());
    }
}
