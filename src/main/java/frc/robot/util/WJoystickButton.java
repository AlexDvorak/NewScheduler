package frc.robot.util;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.Button;
import edu.wpi.first.wpilibj2.command.button.Trigger;

public class WJoystickButton extends Button {

    private final GenericHID m_joystick;
    private final int m_buttonNumber;

    public WJoystickButton(GenericHID joystick, int buttonNumber) {
        this.m_joystick = joystick;
        this.m_buttonNumber = buttonNumber;
    }

    @Override
    public boolean get() {
        return m_joystick.getRawButton(m_buttonNumber);
    }

    @Override
    public Trigger whileActiveOnce(final Command command, boolean interruptible) {
        throw new NullPointerException("Not Implemented");
        // return this;
    }

    @Override
    public Trigger whenActive(final Command command, boolean interruptible) {
        throw new NullPointerException("Not Implemented");
        // Runnable r = new Runnable() {
        // private boolean m_pressedLast = get();

        // @Override
        // public void run() {
        // boolean pressed = get();

        // if (!m_pressedLast && pressed) {
        // wsc.scheduleCommand(command, interruptible);
        // }

        // m_pressedLast = pressed;
        // }
        // };
        // return this;
    }

    @Override
    public Trigger whileActiveContinuous(final Command command, boolean interruptible) {
        throw new NullPointerException("Not Implemented");
        // Runnable r = new Runnable() {
        // private boolean m_pressedLast = get();

        // @Override
        // public void run() {
        // boolean pressed = get();

        // if (pressed) {
        // wsc.scheduleCommand(command, interruptible);
        // } else if (m_pressedLast) {
        // wsc.cancelCommand(command);
        // }

        // m_pressedLast = pressed;
        // }
        // };
        // this.wsc.addButton(this, r);
        // return this;
    }

    @Override
    public Trigger whenInactive(final Command command, boolean interruptible) {
        throw new NullPointerException("Not Implemented");
        // return this;
    }

    @Override
    public Trigger toggleWhenActive(final Command command, boolean interruptible) {
        throw new NullPointerException("Not Implemented");
        // return this;
    }

    @Override
    public Trigger cancelWhenActive(final Command command) {
        throw new NullPointerException("Not Implemented");
        // return this;
    }
}
