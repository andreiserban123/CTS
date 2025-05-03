package teme.pregatire.test1.s6.clase;

public class FactoryAsistent implements IFactory {
    @Override
    public PersonalSpital creeaza() {
        return new Asistent();
    }
}
