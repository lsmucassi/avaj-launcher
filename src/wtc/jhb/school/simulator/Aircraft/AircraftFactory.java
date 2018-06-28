package wtc.jhb.school.simulator.Aircraft;
/*
    Author  : lmucassi
    Project : Avaj-launcher
    School  : wethinkcode.co.za
 */

public class AircraftFactory {

    public static IFlyable newAircraft(String type, String name,
                                       int longitude, int latitude, int height) {

        Coordinates coordinates = new Coordinates(longitude, latitude, height);
        if (type.toLowerCase().equals("baloon"))
            return new Baloon(name, coordinates);
        else if (type.toLowerCase().equals("jetplane"))
            return new JetPlane(name, coordinates);
        else if (type.toLowerCase().equals("helicopter"))
            return new Helicopter(name, coordinates);
        return null;
        }
}