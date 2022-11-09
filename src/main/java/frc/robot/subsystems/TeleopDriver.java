package frc.robot.subsystems;

import edu.wpi.first.wpilibj.XboxController;
import frc.robot.util.WController;
import frc.robot.util.WJoystickButton;
import frc.robot.util.WScheduler;

public class TeleopDriver implements WController {

    private WJoystickButton btnA, btnB, btnX;
    private final WScheduler wsc;

    public TeleopDriver(WScheduler wsc) {
        this.wsc = wsc;
    }

    public void initialize() {
        XboxController driver = new XboxController(0);
        btnA = new WJoystickButton(driver, XboxController.Button.kA.value);
        btnB = new WJoystickButton(driver, XboxController.Button.kB.value);
        btnX = new WJoystickButton(driver, XboxController.Button.kX.value);
    }

    public void periodic() {
        if (btnA.get()) wsc.updateEntry("Shooter/TargetRPM", 3000);
        if (btnB.get()) wsc.updateEntry("Shooter/TargetRPM", 2000);
        if (btnX.get()) wsc.updateEntry("Driver/EnableShot", 1);
    }

}
