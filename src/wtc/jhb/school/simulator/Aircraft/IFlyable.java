package wtc.jhb.school.simulator.Aircraft;
/*
    Author  : lmucassi
    Project : Avaj-launcher
    School  : wethinkcode.co.za
 */

import wtc.jhb.school.weather.WeatherTower;

public interface IFlyable {

    public void updateCondition();
    public void registerTower(WeatherTower weatherTower);
}
