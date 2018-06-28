package wtc.jhb.school.simulator.Aircraft;
/*
    Author  : lmucassi
    Project : Avaj-launcher
    School  : wethinkcode.co.za
 */

import wtc.jhb.school.simulator.Simulator;
import wtc.jhb.school.weather.WeatherTower;

import java.util.HashMap;

public class JetPlane extends Aircraft implements IFlyable {
    private WeatherTower weatherTower;

    JetPlane(String  name, Coordinates coordinates) {
        super(name, coordinates);
    }

    public void updateCondition() {
        String weather = weatherTower.getWeather(this.coordinates);
        HashMap<String, String> messages = new HashMap<String, String>() {{
            put("SUN", "This is clear view me, I like it!");
            put("RAIN", "I really have to get above the clouds, damn this rain!");
            put("FOG", "There seem to be a lot of fog but I'll rise above ");
            put("SNOW", "Not even snow can stop this beast!");

        }};

        if (weather.equals("SUN"))
            this.coordinates = new Coordinates(
                    coordinates.getLongitude() + 0,
                    coordinates.getLatitude() + 10,
                    coordinates.getHeight() + 2);
        else if (weather.equals("RAIN"))
            this.coordinates = new Coordinates(
                    coordinates.getLongitude() + 0,
                    coordinates.getLatitude() + 5,
                    coordinates.getHeight() + 0);
        else if (weather.equals("FOG"))
            this.coordinates = new Coordinates(
                    coordinates.getLongitude() + 0,
                    coordinates.getLatitude() + 1,
                    coordinates.getHeight() + 0);
        else if (weather.equals("SNOW"))
            this.coordinates = new Coordinates(
                    coordinates.getLongitude() + 0,
                    coordinates.getLatitude() + 0,
                    coordinates.getHeight() - 7);

        Simulator.printer.println("Tower Says: JetPlane " +
                this.name + " ID: [" + this.id + "] " + messages.get(weather));
        if (this.coordinates.getHeight() == 0) {
            Simulator.printer.println("Tower Says: JetPlane " +
                    this.name + " ID: [" + this.id + "] is now landing");
            this.weatherTower.unregister( this );
            Simulator.printer.println("Tower Says: JetPlane " +
                    this.name + " ID: [" + this.id + "] is now unregistered from weather tower");
        }
    }

    public void registerTower(WeatherTower weatherTower) {
        this.weatherTower = weatherTower;
        this.weatherTower.register( this );
        Simulator.printer.println("Tower Says: JetPlane " +
                this.name + " ID: [" + this.id + "] is registered to weather tower");
    }
}
