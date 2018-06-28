package wtc.jhb.school.weather;
/*
    Author  : lmucassi
    Project : Avaj-launcher
    School  : wethinkcode.co.za
 */


import wtc.jhb.school.simulator.Aircraft.Coordinates;
import wtc.jhb.school.tower.Tower;

public class WeatherTower extends Tower {

    public String getWeather(Coordinates coordinates) {
        return WeatherProvider.getProvider().getCurrentWeather(coordinates);
    }

    void changeWeather() {
        this.conditionChanged();
    }
}
