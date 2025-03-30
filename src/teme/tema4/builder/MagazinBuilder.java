package teme.tema4.builder;

public class MagazinBuilder {
    private static Magazin magazin = new Magazin();

    public MagazinBuilder setDenumire(String denumire) {
        magazin.setDenumire(denumire);
        return this;
    }

    public MagazinBuilder setSuprafata(int suprafata) {
        magazin.setSuprafata(suprafata);
        return this;
    }

    public MagazinBuilder setNrIntrari(int nrIntrari) {
        magazin.setNrIntrari(nrIntrari);
        return this;
    }

    public MagazinBuilder setPodeauaStandard(boolean podeauaStandard) {
        magazin.setPodeauaStandard(podeauaStandard);
        return this;
    }

    public MagazinBuilder setDuritate(double duritate) {
        magazin.setDuritate(duritate);
        return this;
    }

    public MagazinBuilder addMaterialDecoratiuni(String materialeDecoratiuni) {
        magazin.addMaterialDecoratiuni(materialeDecoratiuni);
        return this;
    }

    public Magazin build() throws Exception {
        try {

            if (magazin.getDenumire() == null) {
                throw new RuntimeException("Denumirea nu poate fi null");
            }
            if (magazin.getSuprafata() <= 0) {
                throw new RuntimeException("Suprafata trebuie sa fie mai mare decat 0");
            }
            if (magazin.getNrIntrari() < 1) {
                throw new RuntimeException("Numarul de intrari trebuie sa fie mai mare decat 0");
            }
            if (magazin.getNrIntrari() * 100 < magazin.getSuprafata()) {
                throw new RuntimeException("Nu pot exista mai puțin de 1 intrări per 100 mp de magazin;");
            }
            if (magazin.getDuritate() < 2 && magazin.getMaterialeDecoratiuni().contains("Sticla")) {
                throw new RuntimeException("Duritatea trebuie sa fie mai mare de 2 pentru a folosi sticla");
            }

            return magazin.clone();

        } finally {
            magazin = new Magazin();

        }

    }

}
