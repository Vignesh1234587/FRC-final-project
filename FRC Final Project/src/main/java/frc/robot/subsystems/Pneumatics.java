// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj.PowerDistribution;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.PowerDistribution.ModuleType;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Pneumatics extends SubsystemBase {
  /** Creates a new Pneumatics. */

  Compressor compress;
  DoubleSolenoid intake;
  DoubleSolenoid climberBrake;
  public static boolean isClimbReverse;

  public Pneumatics() {
     compress = new Compressor(PneumaticsModuleType.CTREPCM);
     intake = new DoubleSolenoid(PneumaticsModuleType.CTREPCM, 0, 1);
     compress.enableDigital();
     isClimbReverse = false;
  }
  public void stopCompress(){
    if(compress.isEnabled()){
      compress.disable();
    } else {
      compress.enableDigital();
    }

  }
  public void setForward(){
    climberBrake.set(Value.kForward);
    isClimbReverse = false;
  }
  
  public void setReverse(){

    climberBrake.set(Value.kReverse);
    isClimbReverse = true;
  }

  public void turnOff(){

    climberBrake.set(Value.kOff);
    isClimbReverse = false;
  }
  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
