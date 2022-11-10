package frc.robot.subsystems;

import frc.robot.util.WController;
import frc.robot.util.WScheduler;

public class ShotController implements WController {

    private final WScheduler sched;
    private boolean atRPM, fire;

    public ShotController(WScheduler wsc) {
        this.sched = wsc;
        wsc.registerController(this);
    }

    public void initialize() {
        sched.putEntry("Targeting/DistToTarget", -1);

        sched.register((s) -> atRPM = s == 1.0, "Shooter/AtRPM");
        sched.register((f) -> fire=f==1, "ShotController/FireAtWill");
    }

    public void periodic() {
        if (atRPM && fire) {
            System.out.println("At target RPM");
            sched.putEntry("Tower/Enabled", 1);
        }
    }
}
