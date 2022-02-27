// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DefaultDrive;

public class DriveTrainAuto extends CommandBase {
  private final DefaultDrive m_DefaultDrive;
  private final double m_speed;
  private final double m_turn;
  /** Creates a new DriveTrainAuto. */
  public DriveTrainAuto(DefaultDrive defaultDrive, double speed, double turn) {
    m_speed = speed;
    m_turn = turn;
    m_DefaultDrive = defaultDrive;
    addRequirements(m_DefaultDrive);
    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    m_DefaultDrive.my_DriveMotorsarcade(m_speed, m_turn);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    m_DefaultDrive.my_DriveMotorsarcade(0, 0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
