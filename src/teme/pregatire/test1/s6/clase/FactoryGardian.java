package teme.pregatire.test1.s6.clase;

public class FactoryGardian implements IFactory {
    @Override
    public PersonalSpital creeaza() {
        return new Gardian();
    }
}
