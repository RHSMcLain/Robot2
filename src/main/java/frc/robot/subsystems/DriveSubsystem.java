// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.motorcontrol.PWMTalonSRX;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class DriveSubsystem extends SubsystemBase {
  /** Creates a new DriveSubsystem. */
  private final PWMTalonSRX rightMotor1 = new PWMTalonSRX(1);
  private final PWMTalonSRX rightMotor2 = new PWMTalonSRX(2);
  private final PWMTalonSRX leftMotor1 = new PWMTalonSRX(3);
  private final PWMTalonSRX leftMotor2 = new PWMTalonSRX(4);
  
  public DriveSubsystem() {
    leftMotor1.setInverted(true);
    leftMotor2.setInverted(true);
  }
  public void tankDrive(double left, double right){
    leftMotor1.set(left);
    rightMotor1.set(right);
  }

  public void arcadeDrive(double y, double x){
    double left = y + x;
    double right = y - x;
    leftMotor1.set(left);
    leftMotor2.set(left);
    rightMotor1.set(right);
    rightMotor2.set(right);
  }
  /**
   * Example command factory method.
   *
   * @return a command
   */
  public Command exampleMethodCommand() {
    // Inline construction of command goes here.
    // Subsystem::RunOnce implicitly requires `this` subsystem.
    return runOnce(
        () -> {
          /* one-time action goes here */
        });
  }

  /**
   * An example method querying a boolean state of the subsystem (for example, a digital sensor).
   *
   * @return value of some boolean subsystem state, such as a digital sensor.
   */
  public boolean exampleCondition() {
    // Query some boolean state, such as a digital sensor.
    return false;
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  @Override
  public void simulationPeriodic() {
    // This method will be called once per scheduler run during simulation
  }
}