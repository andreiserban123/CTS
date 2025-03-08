package tema2;

import java.util.Objects;

public class MateriePrima {
    private final String nume;
    private final String unitateMasura;

    public MateriePrima(String nume, String unitateMasura) {
        this.nume = nume;
        this.unitateMasura = unitateMasura;
    }

    public String getNume() {
        return nume;
    }

    public String getUnitateMasura() {
        return unitateMasura;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MateriePrima that = (MateriePrima) o;
        return Objects.equals(nume, that.nume);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nume);
    }

    @Override
    public String toString() {
        return nume + " (" + unitateMasura + ")";
    }
}
