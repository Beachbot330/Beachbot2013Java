// RobotBuilder Version: 1.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.
package org.usfirst.frc330.Beachbot2014Java.commands;
import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc330.Beachbot2014Java.Robot;
import org.usfirst.frc330.Beachbot2014Java.subsystems.Chassis;
/**
 *
 */
public class  DriveEncoder extends Command {
    double leftDistance, rightDistance, tolerance;
    boolean stopAtEnd = false;
    
    public DriveEncoder()
    {
        this(0,0,0,false);
    }
    
    public DriveEncoder(double distance) {
        this(distance, 0, 0, false);
    }
    
    public DriveEncoder(double distance, double tolerance)
    {
        this(distance, tolerance, 0, false);
    }
    
    public DriveEncoder(double distance, double tolerance, double timeout, boolean stopAtEnd) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
	
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=REQUIRES
        requires(Robot.chassis);
    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=REQUIRES
        this.leftDistance = distance;
        this.rightDistance = distance;
        this.tolerance = tolerance;
        setTimeout(timeout);
        this.stopAtEnd = stopAtEnd;
    }
    // Called just before this Command runs the first time
    protected void initialize() {
        Robot.chassis.gyroPID.disable();
        if (!Robot.chassis.getShiftState())
        {
            Robot.chassis.leftDrivePID.setGainName(Chassis.DRIVELOW);
            Robot.chassis.rightDrivePID.setGainName(Chassis.DRIVELOW);
        }
        else
        {
             Robot.chassis.leftDrivePID.setGainName(Chassis.DRIVEHIGH);
             Robot.chassis.rightDrivePID.setGainName(Chassis.DRIVEHIGH);
        }
        Robot.chassis.leftDrivePID.setSetpoint(leftDistance);
        Robot.chassis.rightDrivePID.setSetpoint(rightDistance);
        Robot.chassis.leftDrivePID.enable();
        Robot.chassis.rightDrivePID.enable();
        Robot.chassis.leftDrivePID.setAbsoluteTolerance(tolerance);
        Robot.chassis.rightDrivePID.setAbsoluteTolerance(tolerance);
        
    }
    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    }
    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }
    // Called once after isFinished returns true
    protected void end() {
        if (stopAtEnd)
        {
            Robot.chassis.stopDrive();
        }
    }
    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
        stopAtEnd = true;
        end();
    }
}
