package frc.robot.subsystems;

import edu.wpi.first.wpilibj.motorcontrol.PWMVictorSPX;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Arm extends SubsystemBase {
    private final PWMVictorSPX m_motor = new PWMVictorSPX(6);
    public Arm() {
        m_motor.setInverted(true);
    }
    public void motorDrive(double speed) {
        m_motor.set(0.5 * Math.pow(speed, 3));
        m_motor.feed();
    }
}