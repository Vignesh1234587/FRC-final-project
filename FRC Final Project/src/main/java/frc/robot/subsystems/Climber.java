// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.can.TalonFX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.RobotContainer;
import frc.robot.RobotMap;

public class Climber extends SubsystemBase {
  /** Creates a new Climber. */
  TalonFX climb;
  public Climber() {
    
     climb = new TalonFX(RobotMap.CLIMB_MOTOR_PORT);
     climb.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Absolute);

  }
  

  public void controlClimb(double speed){
    RobotContainer.pneumatics.setReverse();
    
    climb.set(ControlMode.PercentOutput, speed);

  }

  public void zeroClimbPos(){
    climb.setSelectedSensorPosition(0);
  }


  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
