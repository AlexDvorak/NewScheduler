package frc.robot.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;

public class WScheduler {

    private final Map<String, Double> lu_table;
    private final List<String> lu_table_dirty;

    private final List<WController> controllers;
    private final Map<String, Consumer<Double>> listeners;

    public WScheduler() {
        listeners = new HashMap<>();
        controllers = new ArrayList<>();

        lu_table_dirty = new ArrayList<>();
        lu_table = new HashMap<String, Double>();
        lu_table.put("Scheduler/Status", 0.0); // disabled
    }

    public void putEntry(String key, double value) {
        lu_table.put(key, value);
        lu_table_dirty.add(key);
    }

    public void register(Consumer<Double> listener, String key) {
        listeners.put(key, listener);
        putEntry(key, 0);
    }

    public void registerController(WController controller) {
        controllers.add(controller);
        controller.initialize();
    }

    public void run() {
        for (WController c : controllers) {
            c.periodic();
        }

        for (String k : lu_table_dirty) {
            Consumer<Double> l = listeners.get(k);
            if (l != null && lu_table.containsKey(k)) {
                System.out.println(k);
                l.accept(lu_table.get(k));
            }
        }
        lu_table_dirty.clear();
    }

    // format:off
    /**
     * limelight publishes data
     * |--> Target (Image) (x, y)
     * |--> Target (robot) (theta vertical)
     * \--> Target (robot) (theta horizontal)
     *
     * turret publishes data
     * |--> Current Angle
     * \--> Angular velocity
     * subscribes
     * \--> Desired Angle
     *
     * shooter publishes data
     * |--> Current RPM
     * |--> Enabled
     * \--> At target RPM
     * subscribes
     * \--> Desired RPM
     *
     * Shot controller takes all logic for shooting and issues commands
     * |--> Ready to Shoot
     * |--> Desired RPM
     * |--> Desired Angle
     * |--> Target Distance
     * subscribes
     * |--> Shooter/AtTargetRPM
     * |--> Limelight/TargetThetaVertical
     * |--> Limelight/TargetThetaHorizontal
     * \--> Turret/CurrentAngle
     */
    // format:off
}
