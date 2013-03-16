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
import edu.wpi.first.wpilibj.Preferences;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.AutoSpreadsheetCommand;
import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc330.Beachbot2013Java.Robot;
/*
 * $Log: LaunchFrisbee.java,v $
 * Revision 1.8  2013-03-15 02:58:19  echan
 * robotbuilder update
 *
 * Revision 1.7  2013-03-15 02:50:55  echan
 * added cvs log comments
 *
 */
/**
 * Shoot a frisbee. Actuate the cylinder immediately and then wait until
 * retracting it. The retract time is the Preference "solenoidOffTime".
 */

//TODO wait to launch frisbee until shooter is at correct speed.
public class  LaunchFrisbee extends Command implements AutoSpreadsheetCommand {
    public LaunchFrisbee() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
	
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=REQUIRES
        requires(Robot.shooterLow);
    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=REQUIRES
    }
    private double endTime;
    private double solenoidOffTime;
    // Called just before this Command runs the first time
    protected void initialize() {
        solenoidOffTime = Robot.shooterLow.launchFrisbeeSolenoidOffTime();
        endTime = Timer.getFPGATimestamp() + solenoidOffTime;
    }
    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        Robot.shooterLow.armLoadShooterOn();
    }
    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        if (Timer.getFPGATimestamp() > endTime) 
        {
            return true;
        }
        return false;
    }
    // Called once after isFinished returns true
    protected void end() {
        Robot.shooterLow.armLoadShooterOff();
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
        return new LaunchFrisbee();
    }
}
