package frc.robot.commands;

import java.util.function.Supplier;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Arm;

public class ArmCommand extends CommandBase {
    private Arm m_subsystem;
    private Supplier<Double> m_speedSupplier;
    public ArmCommand(Arm subsystem, Supplier<Double> speedSupplier) {
        m_speedSupplier = speedSupplier;
        m_subsystem = subsystem;
        addRequirements(m_subsystem);
    }

    @Override
    public void execute() {
        m_subsystem.motorDrive(m_speedSupplier.get());
    }
}
