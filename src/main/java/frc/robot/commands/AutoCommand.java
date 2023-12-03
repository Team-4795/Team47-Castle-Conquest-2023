// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import frc.robot.subsystems.RollerClaw;
import frc.robot.subsystems.Arm;
import frc.robot.subsystems.RomiDrivetrain;
import edu.wpi.first.wpilibj2.command.CommandBase;

/** An example command that uses an example subsystem. */
public class AutoCommand extends CommandBase {
  @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})
  private final RomiDrivetrain m_drivetrain;
  private final Arm m_arm;
  private final RollerClaw m_rollerClaw;
  /**
   * Creates a new ExampleCommand.
   *
   * @param subsystem The subsystem used by this command.
   */
  public AutoCommand(RomiDrivetrain drivetrain, Arm arm, RollerClaw claw) {
    m_drivetrain = drivetrain;
    m_arm = arm;
    m_rollerClaw = claw;
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(drivetrain, arm, claw);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
  }

  // Called every time the scheduler runs while the command is scheduled.
  public void driveForward() {
    m_drivetrain.arcadeDrive(1, 0);
  }
  public void driveBackward() {
    m_drivetrain.arcadeDrive(-.5, 0);
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
