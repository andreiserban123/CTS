package teme.pregatire.test1.s6.clase;

public class FactoryMedic implements IFactory {

    @Override
    public PersonalSpital creeaza() {
        return new Medic();
    }
}
