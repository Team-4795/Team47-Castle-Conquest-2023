package frc.robot.subsystems;

import edu.wpi.first.wpilibj.motorcontrol.PWMVictorSPX;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class RollerClaw extends SubsystemBase {
    private final PWMVictorSPX m_motor = new PWMVictorSPX(5);
    public RollerClaw() {}
    public void motorDrive(double speed) {
        m_motor.set(speed);
        m_motor.feed();
    }
}
