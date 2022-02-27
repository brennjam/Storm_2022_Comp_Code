// RobotBuilder Version: 4.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.

// ROBOTBUILDER TYPE: Command.

package frc.robot.commands;
import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.CommandScheduler;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.ParallelCommandGroup;
import edu.wpi.first.wpilibj2.command.PerpetualCommand;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.subsystems.DefaultDrive;
import frc.robot.subsystems.FlyWheel;
import frc.robot.subsystems.SecondIntake;

// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=IMPORTS

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=IMPORTS

/**
 *
 */

public class AutonomousCommand extends CommandBase {
    private final CommandScheduler m_CommandScheduler = CommandScheduler.getInstance();
    private final FlyWheel m_FlyWheel;
    private final SecondIntake m_sSecondIntake;
    private final DefaultDrive m_dDefaultDrive;
    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_DECLARATIONS
 
    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_DECLARATIONS

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS

    public AutonomousCommand(FlyWheel flyWheel, SecondIntake secondIntake, DefaultDrive DefaultDrive) {
        m_FlyWheel = flyWheel;
        m_sSecondIntake = secondIntake;
        m_dDefaultDrive = DefaultDrive;
        addRequirements(flyWheel, secondIntake, DefaultDrive);


    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_SETTING

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_SETTING
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=REQUIRES

        // m_subsystem = subsystem;
        // addRequirements(m_subsystem);    

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=REQUIRES
    }

    // Called when the command is initially scheduled.
    @Override
    public void initialize() {
        m_CommandScheduler.schedule(new SequentialCommandGroup(
            new ParallelCommandGroup
            (
                new PerpetualCommand
                                    (
                                        new InstantCommand( () -> {} )
                                    ).withTimeout(5).andThen
                                                        (new SeondIntakeCommand(60, m_sSecondIntake)
                                                        ), 
                new FlyWheelCommand
                                    (
                                        .5, m_FlyWheel
                                    )
            ).withTimeout(7),
            new DriveTrainAuto(m_dDefaultDrive, -.4, 0).withTimeout(1)
        ));

    }

    // Called every time the scheduler runs while the command is scheduled.
    @Override
    public void execute() {
    }

    // Called once the command ends or is interrupted.
    @Override
    public void end(boolean interrupted) {
    }

    // Returns true when the command should end.
    @Override
    public boolean isFinished() {
        return false;
    }

    @Override
    public boolean runsWhenDisabled() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DISABLED
        return false;

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DISABLED
    }
}
