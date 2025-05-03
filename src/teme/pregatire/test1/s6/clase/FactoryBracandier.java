package teme.pregatire.test1.s6.clase;

public class FactoryBracandier implements IFactory {
    @Override
    public PersonalSpital creeaza() {
        return new Brancardier();
    }
}
