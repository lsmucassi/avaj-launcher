package wtc.jhb.school.weather;
/*
    Author  : lmucassi
    Project : Avaj-launcher
    School  : wethinkcode.co.za
 */

import wtc.jhb.school.simulator.Aircraft.Coordinates;

public class WeatherProvider {
    private static WeatherProvider weatherProvider = new WeatherProvider();
    private static String[] weather = {
            "SUN", "FOG", "SNOW", "RAIN"
    };

    private WeatherProvider() {}

    public static WeatherProvider getProvider() {
       return WeatherProvider.weatherProvider;
    }

    private int byteToInt(byte[] bi) {
        int val = 0;
        for (int i = 0; i < bi.length; i++) {
            val = (val << 8 | bi[i]);
        }
        return val;
    }

    public String getCurrentWeather(Coordinates coordinates) {
        int sed = coordinates.getLongitude() + coordinates.getLatitude() + coordinates.getHeight();
        return weather[sed % 4];
    }
}
