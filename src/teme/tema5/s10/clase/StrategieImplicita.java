package teme.tema5.s10.clase;

public class StrategieImplicita implements StrategieParametrizare {

    @Override
    public ICautare creeazaParametrizare() {
        System.out.println("Se aplica parametrizarea implicita de cautare.");


        FiltruDisponibilitate filtruDisponibilitate = new FiltruDisponibilitate(true, true);
        return filtruDisponibilitate;
    }
}
