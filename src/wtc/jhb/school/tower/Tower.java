package wtc.jhb.school.tower;
/*
    Author  : lmucassi
    Project : Avaj-launcher
    School  : wethinkcode.co.za
 */

import wtc.jhb.school.simulator.Aircraft.IFlyable;
import java.util.ArrayList;

public class Tower {
    private ArrayList<IFlyable> observers = new ArrayList<IFlyable>();

    public void register(IFlyable flyable) {
        if (observers.contains(flyable))
            return ;
        observers.add(flyable);
    }

    public void unregister(IFlyable flyable) {
        observers.remove(flyable);
    }

    protected void conditionChanged() {
        for (int i = 0; i < observers.size(); i++) {
            observers.get(i).updateCondition();
        }
    }
}
