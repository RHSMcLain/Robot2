package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.DriveSubsystem;

public class TurnToAngle1 extends Command {
 private final DriveSubsystem chassis;
 
 public TurnToAngle1(DriveSubsystem chassisSubsystem){
    chassis = chassisSubsystem;
    addRequirements(chassis);
 }

 @Override
 public void initialize(){
    chassis.resetNavx();
 }
 @Override
 public void execute(){
    chassis.arcadeDrive(0, 0.4);

 }
 @Override
 public boolean isFinished(){
    return chassis.getAngle() >= 90;
 }
 @Override
 public void end(boolean isInterrupted){
    chassis.arcadeDrive(0,0);
    
 }
    
}
