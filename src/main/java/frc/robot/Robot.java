package frc.robot;

import edu.wpi.first.wpilibj.TimedRobot;
import frc.robot.subsystems.ShooterSubsystem;
import frc.robot.subsystems.ShotController;
import frc.robot.util.WScheduler;

/**
 * The VM is configured to automatically run this class, and to call the functions corresponding to
 * each mode, as described in the TimedRobot documentation. If you change the name of this class or
 * the package after creating this project, you must also update the build.gradle file in the
 * project.
 */
public class Robot extends TimedRobot {

    private WScheduler wsc;
    private ShooterSubsystem ss;
    private ShotController sc;

    @Override
    public void robotInit() {
        wsc = new WScheduler();
        ss = new ShooterSubsystem(wsc);
        sc = new ShotController(wsc);
    }

    @Override
    public void robotPeriodic() {
        wsc.run();
    }

    @Override
    public void teleopInit() {}

    @Override
    public void teleopPeriodic() {}
}
