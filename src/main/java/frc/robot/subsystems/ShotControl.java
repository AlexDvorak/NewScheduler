package frc.robot.subsystems;

import frc.robot.util.WBaseController;

public class ShotControl extends WBaseController {

    private boolean atRPM, fire;
    private double manualRpm;

    public void initialize() {
        // Subscribe to controller commands
        this.subscribe("Controls/FireAtWill", (f) -> fire = f == 1.0);
        this.subscribe("Controls/ManualRPM", this::setRPM);

        // Subscribe to subsystem status
        this.subscribe("Shooter/AtRPM", (s) -> atRPM = s == 1.0);

        // Publish status
        this.publish("ShotControl/Firing", 0);
        this.publish("ShotControl/ReadyShoot", 0);
    }

    public void periodic() {
        if (atRPM) {
            this.publish("ShotControl/ReadyShoot", 1);
        }
        if (atRPM && fire) {
            this.publish("ShotControl/Firing", 1);
        }
    }

    private void setRPM(Double RPM) {
        // TODO add clamping logic
        this.manualRpm = RPM;
        this.publish("ShotControl/ManualRPM", manualRpm);
    }

}
