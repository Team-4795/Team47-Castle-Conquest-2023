// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import frc.robot.subsystems.RollerClaw;
import frc.robot.subsystems.RomiDrivetrain;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.CommandBase;

/** An example command that uses an example subsystem. */
public class AutoCommand extends CommandBase {
  @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})
  private final RomiDrivetrain m_drivetrain;
  private final RollerClaw rollerClaw;
  private double startTime;
  /**
   * Creates a new ExampleCommand.
   *
   * @param subsystem The subsystem used by this command.
   */
  public AutoCommand(RomiDrivetrain subsystem, RollerClaw intake) {
    m_drivetrain = subsystem;
    rollerClaw = intake;
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(subsystem, intake);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    startTime = Timer.getFPGATimestamp();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    if((Timer.getFPGATimestamp() - startTime) > 5){
      m_drivetrain.arcadeDrive(0.25, 0);  
    } else {
      rollerClaw.motorDrive(-1);
    }
    
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
