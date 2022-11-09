package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Timer;
import frc.robot.util.WController;
import frc.robot.util.WScheduler;

public class ShotController implements WController {

    private final WScheduler sched;
    private boolean state;
    private double k = 0;

    public ShotController(WScheduler wsc) {
        wsc.registerController(this);
        this.sched = wsc;
    }

    public void initialize() {
        sched.updateEntry("Target/ReadyShoot", 0);
    }

    public void periodic() {
        if (Timer.getFPGATimestamp() > (k + 5)) {
            state = !state;
            k = Timer.getFPGATimestamp();
            sched.updateEntry("Target/ReadyShoot", state ? 1 : 0);
        }
    }
}
