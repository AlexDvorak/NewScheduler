package frc.robot;

import edu.wpi.first.wpilibj.TimedRobot;
import frc.robot.subsystems.*;
import frc.robot.util.WScheduler;


public class Robot extends TimedRobot {

    private ShooterSubsystem ss;
    private ShotControl sc;
    private TowerSubsytem ts;

    @Override
    public void robotInit() {
        ss = new ShooterSubsystem();
        sc = new ShotControl();
        ts = new TowerSubsytem();
    }

    @Override
    public void robotPeriodic() {
        WScheduler.getInstance().run();
    }

    @Override
    public void teleopInit() {
    }

    @Override
    public void teleopPeriodic() {
    }
}
