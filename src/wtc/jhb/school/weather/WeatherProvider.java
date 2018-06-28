package wtc.jhb.school.weather;
/*
    Author  : lmucassi
    Project : Avaj-launcher
    School  : wethinkcode.co.za
 */

import wtc.jhb.school.simulator.Aircraft.Coordinates;

public class WeatherProvider {
    private static WeatherProvider weatherProvider;
    private static String[] weather;

    private WeatherProvider() {

    }

//    public static WeatherProvider getProvider() {
//       WeatherProvider gtProvider = new WeatherProvider("linda", 89989);
//       return gtProvider;
//    }

    public String getCurrentWeather(Coordinates coordinates) {
        return "currWeather";
    }
}
