package app.business;

public class FacadeFactory {

    private static final Facade FACADE = new FacadeImplementation();

    public static Facade getFacade() {
        return FACADE;
    }
}
