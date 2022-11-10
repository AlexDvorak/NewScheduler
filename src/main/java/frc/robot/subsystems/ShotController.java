package frc.robot.subsystems;

import frc.robot.util.WController;
import frc.robot.util.WScheduler;

public class ShotController implements WController {

    private final WScheduler sched;
    private boolean atRPM;

    public ShotController(WScheduler wsc) {
        wsc.registerController(this);
        this.sched = wsc;
    }

    public void initialize() {
        sched.putEntry("Targeting/DistToTarget", -1);

        sched.register((s) -> atRPM = s == 1.0, "Shooter/AtRPM");
    }

    public void periodic() {
        if (atRPM) {
            System.out.println("At target RPM");
        }
    }
}
