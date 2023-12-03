package frc.robot.subsystems;

import edu.wpi.first.wpilibj.motorcontrol.PWMVictorSPX;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class RollerClaw extends SubsystemBase {
    private final PWMVictorSPX m_motor = new PWMVictorSPX(5);
    public RollerClaw() {}
    public void motorDriveIn(double speed) {
        m_motor.set(speed);
        m_motor.feed();
    }
    public void motorDriveOut(double speed) {
        m_motor.set(-1 * speed);
        m_motor.feed();
    }
}
