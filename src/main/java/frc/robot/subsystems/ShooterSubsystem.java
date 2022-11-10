package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import frc.robot.util.WController;
import frc.robot.util.WScheduler;

public class ShooterSubsystem implements WController {

    private TalonSRX mFlywheel;
    private int setpointRPM, currentRPM;

    private final WScheduler sched;

    public ShooterSubsystem(WScheduler sched) {
        sched.registerController(this);
        this.sched = sched;
        mFlywheel = new TalonSRX(10);
    }

    public void initialize() {
        sched.register((rpm) -> setpointRPM = rpm.intValue(), "Shooter/TargetRPM");
        sched.putEntry("Shooter/AtRPM", 0);
    }

    public void periodic() {
        if (setpointRPM >= 0 && setpointRPM <= 5000) {
            mFlywheel.set(ControlMode.PercentOutput, setpointRPM);
        }

        final boolean atRPM = currentRPM < setpointRPM + 50 && currentRPM > setpointRPM - 50;
        if (setpointRPM > 0 && atRPM) {
            sched.putEntry("Shooter/AtRPM", 1);
        }
    }

}
