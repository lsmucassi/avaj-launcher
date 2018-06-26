package wtc.jhb.school.simulator.Aircraft;

public class Aircraft {
    protected long id;
    protected String name;
    protected Coordinates coordinates;
    private static long idCounter;

    protected Aircraft(String name, Coordinates coordinates) {

    }

    private long nextId() {
        return 0;
    }
}
