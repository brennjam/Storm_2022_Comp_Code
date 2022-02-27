// RobotBuilder Version: 4.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.

// ROBOTBUILDER TYPE: RobotContainer.

package frc.robot;

import frc.robot.commands.*;
import frc.robot.subsystems.*;
import frc.robot.util.XboxControllerAxisButton;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=IMPORTS
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.PS4Controller.Button;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import edu.wpi.first.wpilibj2.command.button.Trigger;
import frc.robot.subsystems.*;

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=IMPORTS


/**
 * This class is where the bulk of the robot should be declared.  Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls).  Instead, the structure of the robot
 * (including subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {

  private static RobotContainer m_robotContainer = new RobotContainer();

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
// The robot's subsystems
    public final FlyWheel m_flyWheel = new FlyWheel();
    public final DefaultDrive m_defaultDrive = new DefaultDrive();
    public final Servos m_servos = new Servos();
    
    // Joysticks
    private final Joystick rightStick = new Joystick(1);
    private final Joystick leftStick = new Joystick(0);
    private final XboxController Xbox_Driver = new XboxController(3);
    private final XboxController logitech = new XboxController(4);

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
private final Climb m_climb1 = new Climb();
private final InitialArm m_arm = new InitialArm();
private final InitialIntake m_intake1 = new InitialIntake();
private final SecondClimb m_climb2 = new SecondClimb();
private final SecondIntake m_intake2 = new SecondIntake();
  
  // A chooser for autonomous commands
  SendableChooser<Command> m_chooser = new SendableChooser<>();

  /**
  * The container for the robot.  Contains subsystems, OI devices, and commands.
  */
  private RobotContainer() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=SMARTDASHBOARD
    // Smartdashboard Subsystems


    // SmartDashboard Buttons
    SmartDashboard.putData("Autonomous Command", new AutonomousCommand(m_flyWheel, m_intake2, m_defaultDrive));
   /*  SmartDashboard.putData("FlyWheelCommand: HighGoal", new FlyWheelCommand(.25, m_flyWheel));
    SmartDashboard.putData("FlyWheelCommand: LowGoalButton", new FlyWheelCommand(.125, m_flyWheel));
    SmartDashboard.putData("FlyWheelCommand: ReverseFlyWheel", new FlyWheelCommand(-.05, m_flyWheel)); */

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=SMARTDASHBOARD
   /*  SmartDashboard.putData("ClimbCommand: Raise", new ClimbCommand(.3, m_climb1));
    SmartDashboard.putData("ClimbCommand: Lower", new ClimbCommand(-.3, m_climb1));

    SmartDashboard.putData("SecondClimbCommand: Up", new SecondClimbCommand(.3, m_climb2));
    SmartDashboard.putData("SecondClimbCommand: Down", new SecondClimbCommand(-.3, m_climb2));

    SmartDashboard.putData("InitialArmCommand: Up", new InitialArmCommand(.4, m_arm));
    SmartDashboard.putData("InitialArmCommand: Down", new InitialArmCommand(-.4, m_arm));

    SmartDashboard.putData("InitialIntakeCommand: In", new IntitialIntakeCommand(.4, m_intake1));
    SmartDashboard.putData("InitialIntakeCommand: Out", new IntitialIntakeCommand(-.4, m_intake1));

    SmartDashboard.putData("SeondIntakeCommand: In", new SeondIntakeCommand(.3, m_intake2));
    SmartDashboard.putData("SeondIntakeCommand: out", new SeondIntakeCommand(-.3, m_intake2));

    SmartDashboard.putData("ServoSetCommand: up", new ServoSetCommand(1, m_servos));
    SmartDashboard.putData("ServoSetCommand: down", new ServoSetCommand(0.125, m_servos)); */
    // Configure the button bindings
    configureButtonBindings();

    // Configure default commands
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=SUBSYSTEM_DEFAULT_COMMAND


    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=SUBSYSTEM_DEFAULT_COMMAND

     m_defaultDrive.setDefaultCommand(new DriveWithJoySticks(Xbox_Driver::getLeftY, Xbox_Driver::getRightX, m_defaultDrive) );
/*     m_defaultDrive.setDefaultCommand(new DriveWithJoySticks(Xbox_Driver::getYChannel, Xbox_Driver::getXChannel, m_defaultDrive));
    m_climb1.setDefaultCommand(new ClimbCommand(Xbox_Driver::getLeftTriggerAxis, m_climb1) );
    m_climb2.setDefaultCommand(new SecondClimbCommand(Xbox_Driver::getRightTriggerAxis, m_climb2) ); */
    
    // Configure autonomous sendable chooser
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=AUTONOMOUS

    m_chooser.setDefaultOption("Shoot and Drive 1 sec", new AutonomousCommand(m_flyWheel, m_intake2, m_defaultDrive));
    m_chooser.addOption("Autonomous Command 2", new AutonomousCommand2(m_flyWheel, m_intake2, m_defaultDrive));

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=AUTONOMOUS

    SmartDashboard.putData("Auto Mode", m_chooser);
  }

  public static RobotContainer getInstance() {
    return m_robotContainer;
  }

  /**
   * Use this method to define your button->command mappings.  Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a
   * {@link edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=BUTTONS
// Create some buttons
final XboxControllerAxisButton reverseFlyWheelButton = new XboxControllerAxisButton(Xbox_Driver, XboxController.Axis.kLeftTrigger.value);     
//final XboxControllerAxisButton reverseFlyWheelButton = new XboxControllerAxisButton(Xbox_Driver, 2);     
reverseFlyWheelButton.whileHeld(new FlyWheelCommand(-.25, m_flyWheel) ,true);
    //SmartDashboard.putData("ReverseFlyWheelButton",new FlyWheelCommand(-.05, m_flyWheel) );

final JoystickButton lowGoalButton = new JoystickButton(Xbox_Driver, 3);        
lowGoalButton.toggleWhenPressed(new FlyWheelCommand(.25, m_flyWheel) ,true);
    //SmartDashboard.putData("LowGoalButton",new FlyWheelCommand(.125, m_flyWheel) );

final JoystickButton highGoalButton = new JoystickButton(Xbox_Driver, 4);        
highGoalButton.toggleWhenPressed(new FlyWheelCommand(.5, m_flyWheel) ,true);
   // SmartDashboard.putData("HighGoalButton",new FlyWheelCommand(.25, m_flyWheel) );

final JoystickButton raiseButton = new JoystickButton(logitech, 3);
raiseButton.whileHeld(new ClimbCommand(.8, m_climb1) ,true);
    //SmartDashboard.putData("RaiseButton",new ClimbCommand(.3, m_climb1) );
    
final JoystickButton lowerButton = new JoystickButton(logitech, 2);        
lowerButton.whileHeld(new ClimbCommand(-.8, m_climb1) ,true);
   // SmartDashboard.putData("LowerButton",new ClimbCommand(-.3, m_climb1) );
    
final JoystickButton secondCLimbUnwind = new JoystickButton(logitech, 3);        
secondCLimbUnwind.whileHeld(new SecondClimbCommand(.45, m_climb2) ,true);
   // SmartDashboard.putData("SecondCLimbUp",new SecondClimbCommand(.3, m_climb2) );

final JoystickButton secondClimbWind = new JoystickButton(logitech, 2);        
secondClimbWind.whileHeld(new SecondClimbCommand(-.45 , m_climb2) ,true);
   // SmartDashboard.putData("SecondClimbDown",new SecondClimbCommand(-.3, m_climb2) );

final JoystickButton initialArmDownButton = new JoystickButton(Xbox_Driver, 6);        
initialArmDownButton.whileHeld(new InitialArmCommand(-.3, m_arm) ,true);
    SmartDashboard.putData("initialArmDownButton",new InitialArmCommand(-.3, m_arm) );

final JoystickButton initialArmUpButton = new JoystickButton(Xbox_Driver, XboxController.Button.kLeftBumper.value);        
//final JoystickButton initialArmUpButton = new JoystickButton(Xbox_Driver, 5);        
initialArmUpButton.whileHeld(new InitialArmCommand(.2, m_arm) ,true);
  //  SmartDashboard.putData("InitialArmUpButton",new InitialArmCommand(.2, m_arm) );

final XboxControllerAxisButton initialIntakeButton = new XboxControllerAxisButton(Xbox_Driver, XboxController.Axis.kRightTrigger.value );        
initialIntakeButton.whileHeld(new IntitialIntakeCommand(.5, m_intake1) ,true);
  //  SmartDashboard.putData("InitialIntakeButton",new IntitialIntakeCommand(.7, m_intake1) );

final XboxControllerAxisButton secondIntakeIn = new XboxControllerAxisButton(Xbox_Driver, XboxController.Axis.kRightTrigger.value );
secondIntakeIn.whileHeld(new SeondIntakeCommand(.9, m_intake2) ,true);
  //  SmartDashboard.putData("SecondIntakeIn",new SeondIntakeCommand(.9, m_intake2) );

final XboxControllerAxisButton seondIntakeOut = new XboxControllerAxisButton(Xbox_Driver, XboxController.Axis.kLeftTrigger.value );
seondIntakeOut.whileHeld(new SeondIntakeCommand(-.3, m_intake2) ,true);
 //   SmartDashboard.putData("SeondIntakeOut",new SeondIntakeCommand(-.3, m_intake2) );

final JoystickButton servodownButton = new JoystickButton(logitech, 8);        
servodownButton.whenPressed(new ServoSetCommand(0.125, m_servos) ,true);
  //  SmartDashboard.putData("ServodownButton",new ServoSetCommand(0.125, m_servos) );

final JoystickButton servoupButton = new JoystickButton(logitech, 9);        
servoupButton.whenPressed(new ServoSetCommand(1, m_servos) ,true);
  //  SmartDashboard.putData("ServoupButton",new ServoSetCommand(1, m_servos) );


    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=BUTTONS
  }

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=FUNCTIONS
public Joystick getLeftStick() {
        return leftStick;
    }

public Joystick getRightStick() {
        return rightStick;
    }

public XboxController getXbox_Driver() {
        return Xbox_Driver;
    }


    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=FUNCTIONS

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
  */
  public Command getAutonomousCommand() {
    // The selected command will be run in autonomous
    return m_chooser.getSelected();
  }
  

}

