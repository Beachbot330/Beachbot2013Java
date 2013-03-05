// RobotBuilder Version: 0.0.2
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in th future.
package org.usfirst.frc330.Beachbot2013Java.commands;
import edu.wpi.first.wpilibj.command.AutoSpreadsheetCommand;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import org.usfirst.frc330.Beachbot2013Java.Robot;
/**
 *
 */
//TODO create a new command that always runs the lower shooter at full speed
public class  ShootLow extends Command implements AutoSpreadsheetCommand {
    public ShootLow() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
	
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=REQUIRES
        requires(Robot.shooterLow);
    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=REQUIRES
        SmartDashboard.putNumber("ShooterLowCommand", 0);
    }
    double voltage;
    // Called just before this Command runs the first time
    protected void initialize() {
        counter=0;
    }
    double counter;
    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        voltage = SmartDashboard.getNumber("ShooterLowCommand");
        Robot.shooterLow.shoot(voltage);
        if (counter%10==0)
            SmartDashboard.putNumber("ShooterLowSpeed", Robot.shooterLow.getSpeed());
        counter++;
    }
    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }
    // Called once after isFinished returns true
    protected void end() {
    }
    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
    public void setParam1(double param1) {
    }
    public void setParam2(double param2) {
    }
    public void setParam3(double param3) {
    }
    public void setStopAtEnd(boolean stopAtEnd) {
    }
    public Command copy() {
        return new ShootLow();
    }
}
