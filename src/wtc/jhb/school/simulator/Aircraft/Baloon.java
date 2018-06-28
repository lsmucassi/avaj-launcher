package wtc.jhb.school.simulator.Aircraft;
/*
    Author  : lmucassi
    Project : Avaj-launcher
    School  : wethinkcode.co.za
 */

import wtc.jhb.school.simulator.Simulator;
import wtc.jhb.school.weather.WeatherTower;

import java.util.HashMap;

public class Baloon extends Aircraft implements IFlyable {
    private WeatherTower weatherTower;

    Baloon(String name, Coordinates coordinates) {
        super(name, coordinates);
    }

    public void updateCondition() {
        String weather = weatherTower.getWeather(this.coordinates);
        HashMap<String, String> messages = new HashMap<String, String>() {{
            put("SUN", "Oh what a lovely day to cruise the sky!");
            put("RAIN", "The view might be blurry, this rain is getting heavy");
            put("FOG", "Oh Nooooo! I can't see anything");
            put("SNOW", "Damn the snow is freezing our engines hard!");

        }};

        if (weather.equals("SUN"))
            this.coordinates = new Coordinates(
                    coordinates.getLongitude() + 2,
                    coordinates.getLatitude() + 0,
                    coordinates.getHeight() + 4);
        else if (weather.equals("RAIN"))
            this.coordinates = new Coordinates(
                    coordinates.getLongitude() + 0,
                    coordinates.getLatitude() + 0,
                    coordinates.getHeight() - 5);
        else if (weather.equals("FOG"))
            this.coordinates = new Coordinates(
                    coordinates.getLongitude() + 0,
                    coordinates.getLatitude() + 0,
                    coordinates.getHeight() - 3);
        else if (weather.equals("SNOW"))
            this.coordinates = new Coordinates(
                    coordinates.getLongitude() + 0,
                    coordinates.getLatitude() + 0,
                    coordinates.getHeight() - 15);

        Simulator.printer.println("Tower Says: Baloon " +
                this.name + " ID: [" + this.id + "] " + messages.get(weather));
        if (this.coordinates.getHeight() == 0) {
            Simulator.printer.println("Tower Says: Baloon " +
                    this.name + " ID: [" + this.id + "] is now landing");
            this.weatherTower.unregister( this );
            Simulator.printer.println("Tower Says: Baloon " +
                    this.name + " ID: [" + this.id + "] is now unregistered from weather tower");
        }
    }

    public void registerTower(WeatherTower weatherTower) {
        this.weatherTower = weatherTower;
        this.weatherTower.register( this );
        Simulator.printer.println("Tower Says: Baloon " +
                this.name + " ID: [" + this.id + "] is registered to weather tower");
    }
}
