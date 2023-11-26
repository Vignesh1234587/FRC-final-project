// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;


import frc.robot.subsystems.Arm;
import frc.robot.subsystems.Climber;
import frc.robot.subsystems.DriveTrain;
import frc.robot.subsystems.Intake;
import frc.robot.subsystems.Pneumatics;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.RunCommand;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import edu.wpi.first.wpilibj2.command.button.Trigger;

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and trigger mappings) should be declared here.
 */
public class RobotContainer {

    Joystick driver = new Joystick(0);
    Joystick manip = new Joystick(1);
    DriveTrain driveTrain = new DriveTrain();
    Intake intake = new Intake();
    Arm arm = new Arm();
    public static Pneumatics pneumatics = new Pneumatics();
    Climber climb = new Climber();


  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {

     
    driveTrain.setDefaultCommand(new RunCommand(() ->
     driveTrain.drive(driver.getRawAxis(0), driver.getRawAxis(4)), driveTrain));

    climb.setDefaultCommand(new RunCommand(() -> 
    climb.controlClimb(manip.getRawAxis(0)), climb));

     // Configure the trigger bindings
    configureBindings();
  }

  
  private void configureBindings() {
     
    //intake 
    new JoystickButton(driver, RobotMap.DRIVER_RB_PORT).onTrue(new InstantCommand(intake::runIn, intake));
    new JoystickButton(driver, RobotMap.DRIVER_LB_PORT).onTrue(new InstantCommand(intake::runOut, intake));
    new JoystickButton(driver, RobotMap.DRIVER_RB_PORT).onFalse(new InstantCommand(intake::stop, intake));
    new JoystickButton(driver, RobotMap.DRIVER_LB_PORT).onFalse(new InstantCommand(intake::stop, intake));

    //Arm intake low mid high respective 
    new JoystickButton(manip, 1).onTrue(new InstantCommand(()-> arm.setExtendAndAnglePos(4250, 500)));
    new JoystickButton(manip, 2).onTrue(new InstantCommand(()-> arm.setExtendAndAnglePos(3500, 700)));
    new JoystickButton(manip, 3).onTrue(new InstantCommand(()-> arm.setExtendAndAnglePos(3000, 1000)));
    new JoystickButton(manip, 4).onTrue(new InstantCommand(()-> arm.setExtendAndAnglePos(2500, 1500)));
    new JoystickButton(manip, 5).onTrue(new InstantCommand(()-> arm.stationaryPos(), arm));

    //Pneumatics 
    new JoystickButton(driver, 7).onTrue(new InstantCommand(pneumatics::stopCompress, pneumatics));
    new JoystickButton(manip, 8).onTrue(new InstantCommand(pneumatics::setForward, pneumatics));
    
    
  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    // An example command will be run in autonomous
    return null;
  }
}
