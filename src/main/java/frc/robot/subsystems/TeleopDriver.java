package frc.robot.subsystems;

import edu.wpi.first.wpilibj.XboxController;
import frc.robot.util.WController;
import frc.robot.util.WJoystickButton;
import frc.robot.util.WScheduler;

public class TeleopDriver implements WController {

    private WJoystickButton btnA, btnB;
    private final WScheduler wsc;

    public TeleopDriver(WScheduler wsc) {
        this.wsc = wsc;
    }

    public void initialize() {
        XboxController driver = new XboxController(0);
        btnA = new WJoystickButton(driver, XboxController.Button.kA.value);
        btnB = new WJoystickButton(driver, XboxController.Button.kB.value);
    }

    public void periodic() {
        if (btnA.get())
            shootRPM(2000);
        if (btnB.get())
            shootRPM(3000);
        if (!btnA.get() && !btnB.get()) {
            wsc.putEntry("Shooter/TargetRPM", 0);
            wsc.putEntry("ShotController/FireAtWill", 0);
        }
    }

    private void shootRPM(double rpm) {
        wsc.putEntry("Shooter/TargetRPM", rpm);
        wsc.putEntry("ShotController/FireAtWill", 1);
    }

}
