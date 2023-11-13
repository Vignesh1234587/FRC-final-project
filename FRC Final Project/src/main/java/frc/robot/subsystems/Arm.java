// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.can.TalonFX;

import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import frc.robot.RobotMap;

public class Arm extends SubsystemBase {
  /** Creates a new Arm. */

  TalonFX armAngle;
  TalonFX armExtend;
  PIDController angleArmController;
  PIDController extendArmController;
  public double targetAngle;
  public double targetExtendPos;

  public Arm() {

      armAngle = new TalonFX(RobotMap.ARM1_PORT);
      armExtend = new TalonFX(RobotMap.ARM2_PORT);
     
      armAngle.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative, 0, 10);
      armExtend.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative, 0, 10);

      angleArmController = new PIDController(Constants.armAngleGains[0], Constants.armAngleGains[1], Constants.armAngleGains[2]);
      extendArmController = new PIDController(Constants.armExtendGains[0], Constants.armExtendGains[1], Constants.armExtendGains[2]);

      targetAngle = 0;
      targetExtendPos = 0;
  }


  public void stationaryPos(){

    targetAngle = 0;
    targetExtendPos = 0;

  }

  public void setExtendAndAnglePos(int angle, int extendPos){
    targetAngle = angle;
    targetExtendPos = extendPos;

  }
  @Override
  public void periodic() {
    // This method will be called once per scheduler run
    armAngle.set(ControlMode.PercentOutput, angleArmController.calculate(armAngle.getSelectedSensorPosition(), targetAngle));
    armExtend.set(ControlMode.PercentOutput, extendArmController.calculate(armExtend.getSelectedSensorPosition(), targetExtendPos));

  }
}
