package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import frc.robot.util.WBaseController;

public class TowerSubsytem extends WBaseController {

    private boolean enabled;
    private TalonSRX mChute;

    public void initialize() {
        mChute = new TalonSRX(5);
        this.subscribe("Tower/RunTower", (run) -> enabled = run == 1.0);
    }

    public void periodic() {
        if (enabled) {
            mChute.set(ControlMode.PercentOutput, 0.7);
        } else {
            mChute.set(ControlMode.PercentOutput, 0.0);
        }
    }
}
