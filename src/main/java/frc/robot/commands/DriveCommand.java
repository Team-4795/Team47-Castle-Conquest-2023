package frc.robot.commands; 

import java.util.function.Supplier;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.RomiDrivetrain;

public class DriveCommand extends CommandBase {
    private RomiDrivetrain m_subsystem;
    private Supplier<Double> m_speedSupplier;
    private Supplier<Double> m_rotationSupplier;
    public DriveCommand(RomiDrivetrain subsystem, Supplier<Double> speedSupplier, Supplier<Double> rotationSupplier){
        m_subsystem = subsystem;
        m_speedSupplier = speedSupplier;
        m_rotationSupplier = rotationSupplier;
        addRequirements(subsystem);
    }

    @Override
    public void execute() {
        m_subsystem.arcadeDrive(m_speedSupplier.get(), (-1) * m_rotationSupplier.get());
    }
}
