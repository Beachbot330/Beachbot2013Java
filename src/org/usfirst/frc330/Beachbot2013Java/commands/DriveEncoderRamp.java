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
public class  DriveEncoderRamp extends AutoSpreadsheetCommand {
    double distance, angle;
    double tolerance = 0.1;
    boolean stopAtEnd = false;
    double maxoutput = 0;
    double maxoutputStep = .02;
    
    public DriveEncoderRamp(double distance, double angle) {
        this(distance, 0, angle, 0, true);
    }
    
    public DriveEncoderRamp(double distance, double tolerance, double angle, double timeout, boolean stopAtEnd) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
	
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=REQUIRES
        requires(Robot.chassis);
    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=REQUIRES
        this.distance = distance;
        this.angle = angle;
        setTimeout(timeout);
        this.stopAtEnd = stopAtEnd;
    }
    // Called just before this Command runs the first time
    protected void initialize() {
        maxoutput = maxoutputStep;
        
        if (!Robot.chassis.getShiftState())
        {
            Robot.chassis.gyroPIDLow.enable();
            Robot.chassis.gyroPIDLow.setSetpoint(angle);
            Robot.chassis.leftDrivePIDLow.setSetpoint(distance);
            Robot.chassis.rightDrivePIDLow.setSetpoint(distance);
            Robot.chassis.leftDrivePIDLow.enable();
            Robot.chassis.rightDrivePIDLow.enable();
            Robot.chassis.leftDrivePIDHigh.disable();
            Robot.chassis.rightDrivePIDHigh.disable();
            Robot.chassis.leftDrivePIDLow.setAbsoluteTolerance(tolerance);
            Robot.chassis.rightDrivePIDLow.setAbsoluteTolerance(tolerance);
            Robot.chassis.leftDrivePIDLow.setOutputRange(-maxoutput, maxoutput);
            Robot.chassis.rightDrivePIDLow.setOutputRange(-maxoutput, maxoutput);
        }
        else
        {
            Robot.chassis.gyroPIDHigh.enable();
            Robot.chassis.gyroPIDHigh.setSetpoint(angle);
            Robot.chassis.leftDrivePIDHigh.setSetpoint(distance);
            Robot.chassis.rightDrivePIDHigh.setSetpoint(distance);
            Robot.chassis.leftDrivePIDHigh.enable();
            Robot.chassis.rightDrivePIDHigh.enable();
            Robot.chassis.leftDrivePIDLow.disable();
            Robot.chassis.rightDrivePIDLow.disable();
            Robot.chassis.leftDrivePIDHigh.setAbsoluteTolerance(tolerance);
            Robot.chassis.rightDrivePIDHigh.setAbsoluteTolerance(tolerance);
            Robot.chassis.leftDrivePIDHigh.setOutputRange(-maxoutput, maxoutput);
            Robot.chassis.rightDrivePIDHigh.setOutputRange(-maxoutput, maxoutput);            
        }
    }
    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        maxoutput = maxoutput + maxoutputStep;
        if (maxoutput > .8)
        {
            maxoutput = .8;
        }
        if (!Robot.chassis.getShiftState())
        {
            Robot.chassis.leftDrivePIDLow.setOutputRange(-maxoutput, maxoutput);
            Robot.chassis.rightDrivePIDLow.setOutputRange(-maxoutput, maxoutput);
        }
        else
        {
            Robot.chassis.leftDrivePIDHigh.setOutputRange(-maxoutput, maxoutput);
            Robot.chassis.rightDrivePIDHigh.setOutputRange(-maxoutput, maxoutput);            
        }
        Robot.chassis.pidDrive();
        SmartDashboard.putNumber("leftEncoder", Robot.chassis.getLeftDistance());
        SmartDashboard.putNumber("rightEncoder", Robot.chassis.getRightDistance());
        SmartDashboard.putNumber("Gyro", Robot.chassis.getAngle());
    }
    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        if (!Robot.chassis.getShiftState())
        {
            if (Robot.chassis.leftDrivePIDLow.onTarget() || Robot.chassis.rightDrivePIDLow.onTarget() || isTimedOut())
            {
                return true;            
            }
        }
        else if (Robot.chassis.leftDrivePIDHigh.onTarget() || Robot.chassis.rightDrivePIDHigh.onTarget() || isTimedOut())
        {
                return true;            
        }
        return false;
    }
    // Called once after isFinished returns true
    protected void end() {
        if (stopAtEnd)
        {
            Robot.chassis.gyroPIDLow.disable();
            Robot.chassis.gyroPIDHigh.disable();
            Robot.chassis.leftDrivePIDLow.disable();
            Robot.chassis.rightDrivePIDLow.disable();
            Robot.chassis.leftDrivePIDHigh.disable();
            Robot.chassis.rightDrivePIDHigh.disable();            
            Robot.chassis.tankDrive(0, 0);
        }
    }
    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
        stopAtEnd = true;
        end();
    }
    public void setParam1(double distance) {
        this.distance = distance;
    }
    public void setParam2(double angle) {
        this.angle = angle;
    }
    public void setParam3(double tolerance) {
        this.tolerance = tolerance;
    }
    public void setStopAtEnd(boolean stopAtEnd) {
        this.stopAtEnd = stopAtEnd;
    }
    public AutoSpreadsheetCommand copy() {
        return new DriveEncoderRamp(0,0);
    }
}
