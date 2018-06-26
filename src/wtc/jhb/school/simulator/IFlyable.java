package wtc.jhb.school.simulator;

import wtc.jhb.school.tower.WeatherTower;

public interface IFlyable {

    public void updateCondition();
    public void registerTower(WeatherTower weatherTower);
}
