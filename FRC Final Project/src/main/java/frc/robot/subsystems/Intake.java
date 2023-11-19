// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.RobotMap;

public class Intake extends SubsystemBase {
  /** Creates a new Intake. */

  CANSparkMax intakeMotor; 

  public Intake() {

    intakeMotor = new CANSparkMax(RobotMap.INTAKE_MOTOR_PORT, MotorType.kBrushless);



  }


  public void runIn(){
    intakeMotor.set(0.5);

  }
  
  public void runOut(){
    intakeMotor.set(-0.5);

  }
  public void stop(){

    intakeMotor.set(0);
  }
  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
