package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.motorcontrol.PWMVictorSPX;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Arm extends SubsystemBase {
    private double kWheelDiameterInch = 1;
    private final PWMVictorSPX m_motor = new PWMVictorSPX(4);
    private final Encoder m_encoder = new Encoder(8, 9);
    public Arm() {
        m_encoder.setDistancePerPulse((Math.PI * kWheelDiameterInch));
    }
    public void motorDrive(double speed) {
        m_motor.set(speed);
        m_motor.feed();
    }
}
