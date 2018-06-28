package wtc.jhb.school.simulator.Aircraft;
/*
    Author  : lmucassi
    Project : Avaj-launcher
    School  : wethinkcode.co.za
 */

import wtc.jhb.school.simulator.Simulator;
import wtc.jhb.school.weather.WeatherTower;
import java.util.HashMap;


public class Helicopter extends Aircraft implements IFlyable {
    private WeatherTower weatherTower;

    Helicopter(String name, Coordinates coordinates) {
        super(name, coordinates);
    }
    public void updateCondition() {
        String weather = weatherTower.getWeather(this.coordinates);
        HashMap<String, String> messages = new HashMap<String, String>() {{
            put("SUN", "this light is too much for my view!");
            put("RAIN", "This will be a bumpy ride in the tides of the winds");
            put("FOG", "I hope I can blow this fog with the choppers");
            put("SNOW", "Oh why did it have to this snowy.. :( ");

        }};

        if (weather.equals("SUN"))
            this.coordinates = new Coordinates(
                    coordinates.getLongitude() + 10,
                    coordinates.getLatitude() + 0,
                    coordinates.getHeight() + 2);
        else if (weather.equals("RAIN"))
            this.coordinates = new Coordinates(
                    coordinates.getLongitude() + 0,
                    coordinates.getLatitude() + 0,
                    coordinates.getHeight() + 5);
        else if (weather.equals("FOG"))
            this.coordinates = new Coordinates(
                    coordinates.getLongitude() + 0,
                    coordinates.getLatitude() + 0,
                    coordinates.getHeight() + 1);
        else if (weather.equals("SNOW"))
            this.coordinates = new Coordinates(
                    coordinates.getLongitude() + 0,
                    coordinates.getLatitude() + 0,
                    coordinates.getHeight() + 12);

        Simulator.printer.println("Tower Says: Helicopter " +
                this.name + " ID: [" + this.id + "] " + messages.get(weather));
        if (this.coordinates.getHeight() == 0) {
            Simulator.printer.println("Tower Says: Helicopter " +
                    this.name + " ID: [" + this.id + "] is now landing");
            this.weatherTower.unregister( this );
            Simulator.printer.println("Tower Says: Helicopter " +
                    this.name + " ID: [" + this.id + "] is now unregistered from weather tower");
        }
    }

    public void registerTower(WeatherTower weatherTower) {
        this.weatherTower = weatherTower;
        this.weatherTower.register( this );
        Simulator.printer.println("Tower Says: Helicopter " +
                this.name + " ID: [" + this.id + "] is registered to weather tower");
    }
}
