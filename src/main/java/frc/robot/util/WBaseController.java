package frc.robot.util;

import java.util.function.Consumer;

public class WBaseController implements WController {

    protected final WScheduler scheduler;

    public WBaseController(WScheduler wsc) {
        this.scheduler = wsc;
        this.scheduler.registerController(this);
    }

    public WBaseController() {
        this(WScheduler.getInstance());
    }

    protected void publish(String key, double v) {
        this.scheduler.putEntry(key, v);
    }

    protected void subscribe(String key, Consumer<Double> s) {
        this.scheduler.register(key, s);
    }

    public void initialize() {}

    public void periodic() {}

}
