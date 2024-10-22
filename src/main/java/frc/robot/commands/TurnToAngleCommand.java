package frc.robot.commands;

import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.wpilibj2.command.PIDCommand;
import frc.robot.Constants.DriveConstants;
import frc.robot.subsystems.DriveSubsystem;

public class TurnToAngleCommand extends PIDCommand {
    public TurnToAngleCommand(DriveSubsystem chassis, double targetAngle){
        super(new PIDController(DriveConstants.kP, DriveConstants.kI, DriveConstants.kD), chassis::getAngle, targetAngle, output -> {
            System.out.println("Output: " + output);
            if (output > 0 && output < 30){
                output = 30;
            }
            if (output < -0.05 && output > -30){
                output = -30;
            }
            chassis.arcadeDrive(0,output/100);
        }, chassis);
       
        getController().enableContinuousInput(-180,180);
        getController().setTolerance(5, 5);

    }
    @Override 
    public boolean isFinished(){
        return getController().atSetpoint();
    }
    
    
}
