// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.RobotMap;

public class DriveTrain extends SubsystemBase {
  /** Creates a new DriveTrain. */
  CANSparkMax rightFront;
  CANSparkMax rightBack;
  CANSparkMax leftFront;
  CANSparkMax leftBack;

  public DriveTrain() {
    
    leftFront = new CANSparkMax(RobotMap.FRONT_LEFT_PORT, MotorType.kBrushless);
    leftBack = new CANSparkMax(RobotMap.BACK_LEFT_PORT, MotorType.kBrushless);
    rightFront = new CANSparkMax(RobotMap.FRONT_RIGHT_PORT, MotorType.kBrushless);
    rightBack = new CANSparkMax(RobotMap.BACK_RIGHT_PORT, MotorType.kBrushless);

    leftBack.follow(leftFront);
    rightBack.follow(rightFront);

    rightFront.setInverted(true);

  }
  

  public void drive (double x, double y){

    leftFront.set(x);
    rightFront.set(y);
    
  }
  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
