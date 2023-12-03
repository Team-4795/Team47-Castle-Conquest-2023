package frc.robot.commands;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.subsystems.RollerClaw;

public class OuttakeCommand extends CommandBase {
    private RollerClaw m_subsystem;
    public OuttakeCommand(RollerClaw subsystem) {
        m_subsystem = subsystem;
        addRequirements(m_subsystem);
    }
    
    @Override
    public void execute() {
        SmartDashboard.putBoolean("outtake", true);
        m_subsystem.motorDriveOut(Constants.maxIntakeSpeed);
    }
}
