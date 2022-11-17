package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import frc.robot.util.WBaseController;

public class ShooterSubsystem extends WBaseController {

    private TalonSRX mFlywheel;
    private int setpointRPM, currentRPM;

    public void initialize() {
        mFlywheel = new TalonSRX(10);
        this.subscribe("Shooter/TargetRPM", (rpm) -> setpointRPM = rpm.intValue());
        this.publish("Shooter/AtRPM", 0);
    }

    public void periodic() {
        if (setpointRPM >= 0 && setpointRPM <= 5000) {
            mFlywheel.set(ControlMode.PercentOutput, setpointRPM);
        }

        final boolean atRPM = currentRPM < setpointRPM + 50 && currentRPM > setpointRPM - 50;
        if (setpointRPM > 0 && atRPM) {
            this.publish("Shooter/AtRPM", 1);
        }
    }

}
