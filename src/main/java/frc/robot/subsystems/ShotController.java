package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Timer;
import frc.robot.util.WController;
import frc.robot.util.WScheduler;

public class ShotController implements WController {

    private final WScheduler sched;
    private boolean state;
    private double k = 0;
    private boolean atRPM;

    public ShotController(WScheduler wsc) {
        wsc.registerController(this);
        this.sched = wsc;
    }

    public void initialize() {
        sched.putEntry("Targeting/ReadyShoot", 0);
        sched.putEntry("Targeting/DistToTarget", -1);

        sched.register((s) -> atRPM = s==1.0, "Shooter/AtRPM");
    }

    public void periodic() {
        // if (Timer.getFPGATimestamp() > (k + 5)) {
        //     state = !state;
        //     k = Timer.getFPGATimestamp();
        //     sched.putEntry("Targeting/ReadyShoot", state ? 1 : 0);
        // }
    }
}
