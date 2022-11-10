package frc.robot.subsystems;

import frc.robot.util.WController;
import frc.robot.util.WScheduler;

public class ShooterSubsystem implements WController {

    private TalonSRX a;
    private int setpointRPM;
    private int currentRPM;
    private final WScheduler sched;

    public ShooterSubsystem(WScheduler sched) {
        sched.registerController(this);
        this.sched = sched;
    }

    public void initialize() {
        sched.register((rpm) -> setpointRPM = rpm.intValue(), "Shooter/TargetRPM");
        sched.putEntry("Shooter/AtRPM", 0);
    }

    public void periodic() {
        boolean atRPM = currentRPM < setpointRPM + 50 && currentRPM > setpointRPM - 50;
        if (setpointRPM > 0 && atRPM) {
            sched.putEntry("Shooter/AtRPM", 1);
        }
    }
}
