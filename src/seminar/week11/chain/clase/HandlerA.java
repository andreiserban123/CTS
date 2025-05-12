package seminar.week11.chain.clase;

import java.util.List;

public abstract class HandlerA {

    protected HandlerA nextHandler;

    public HandlerA() {
    }

    public HandlerA(String name) {
        FatadaFiltrare.mapFiltrare.put(name, this);
    }

    public void setNextHandler(HandlerA nextHandler) {
        this.nextHandler = nextHandler;
    }

    public abstract List<Candidat> handleRequest(List<Candidat> candidates);
}
