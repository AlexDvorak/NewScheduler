package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import frc.robot.util.WController;
import frc.robot.util.WScheduler;

public class TowerSubsytem implements WController {

    private final WScheduler sched;
    private boolean enabled;
    private TalonSRX mChute;

    public TowerSubsytem(WScheduler wsc) {
        this.sched = wsc;
        mChute = new TalonSRX(5);
        wsc.registerController(this);
    }

    public void initialize() {
        sched.register((run) -> enabled = run == 1.0, "Tower/RunTower");
    }

    public void periodic() {
        if (enabled) {
            mChute.set(ControlMode.PercentOutput, 0.7);
        } else {
            mChute.set(ControlMode.PercentOutput, 0.0);
        }
    }
}
