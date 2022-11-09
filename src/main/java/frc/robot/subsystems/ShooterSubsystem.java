package frc.robot.subsystems;

import frc.robot.util.WController;
import frc.robot.util.WScheduler;

public class ShooterSubsystem implements WController {

    private boolean readyToShoot;
    private int setpointRPM;
    private final WScheduler sched;

    public ShooterSubsystem(WScheduler sched) {
        sched.registerController(this);
        this.sched = sched;
    }

    public void initialize() {
        sched.register(this::listenShot, "Target/ReadyShoot");
        sched.register(this::listenRPM, "Shooter/TargetRPM");
    }

    public void listenShot(double ready) {
        readyToShoot = ready == 1.0;
        System.out.print("Ready To Shoot: ");
        System.out.println(readyToShoot);
    }

    public void listenRPM(double rpm) {
        setpointRPM = (int)rpm;
        System.out.print("Set Target RPM to:");
        System.out.println(setpointRPM);
    }

    public void periodic() {
        if (readyToShoot) {
            // spinup motor
            System.out.println("Shooter: spinning up");
            if (setpointRPM > 0) // pretend to compare against motor RPM
                System.out.println("Shooter: Up to speed");
        }
    }
}
