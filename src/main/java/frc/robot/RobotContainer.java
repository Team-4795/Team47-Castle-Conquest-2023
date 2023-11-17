// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.
package frc.robot;

// Subsystem imports
import frc.robot.subsystems.RomiDrivetrain;
import frc.robot.subsystems.Arm;
import frc.robot.subsystems.RollerClaw;

// Command imports
import frc.robot.commands.AutoCommand;
import frc.robot.commands.DriveCommand;
import frc.robot.commands.IntakeCommand;
import frc.robot.commands.OuttakeCommand;
import frc.robot.commands.ArmCommand;
// WPILib imports
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;

public class RobotContainer {
  // Controller definition
  private final CommandXboxController m_controller = new CommandXboxController(0);

  // Subsystem definitions
  private final RomiDrivetrain m_romiDrivetrain = new RomiDrivetrain();
  private final Arm m_arm = new Arm();
  private final RollerClaw m_rollerClaw = new RollerClaw();

  // Command definitions
  private final AutoCommand m_autoCommand = new AutoCommand(m_romiDrivetrain, m_rollerClaw);

  private final DriveCommand m_driveCommand = new DriveCommand(
    m_romiDrivetrain, // Subsystem
    () -> m_controller.getLeftY(), // Left joystick Y input supplier (returns speed)
    () -> m_controller.getLeftX() // Light joystick X input supplier (returns rotation)
  );

  private final ArmCommand m_armCommand = new ArmCommand(
    m_arm, // Subsystem
    () -> m_controller.getRightY() // Right joystick Y input supplier (returns speed)
  );

  private final IntakeCommand m_intakeCommand = new IntakeCommand(
    m_rollerClaw // Subsystem
  );

  private final OuttakeCommand m_outtakeCommand = new OuttakeCommand(
    m_rollerClaw // Subsystem
  );
 
  public RobotContainer() {
    m_romiDrivetrain.setDefaultCommand(m_driveCommand);
    m_arm.setDefaultCommand(m_armCommand);
    configureButtonBindings();
  }

  private void configureButtonBindings() {
    m_controller.leftBumper().whileTrue(m_intakeCommand);
    m_controller.rightBumper().whileTrue(m_outtakeCommand);
  }

  public Command getAutonomousCommand() {
    return m_autoCommand;
  }
}
