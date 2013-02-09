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

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import org.usfirst.frc0330.wpilibj.CFA634SPI;
import org.usfirst.frc330.Beachbot2013Java.Robot;
import org.usfirst.frc330.Beachbot2013Java.RobotMap;

/**
 *
 */
public class  UpdateLCD extends Command {

    public UpdateLCD() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
	
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=REQUIRES
        requires(Robot.lCD);
        // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=REQUIRES
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        SmartDashboard.putNumber("AngleToTarget", 0);
        SmartDashboard.putNumber("RangeToTarget", 0);
        SmartDashboard.putNumber("Gyro Angle", 0);
        SmartDashboard.putNumber("Batt Voltage", 0);
        
        Robot.lCD.lcd.addLine(CFA634SPI.Line.kUser1, "Batt Voltage");
        Robot.lCD.lcd.addLine(CFA634SPI.Line.kUser2, "AngleToTarget");
        Robot.lCD.lcd.addLine(CFA634SPI.Line.kUser3, "RangeToTarget");
        Robot.lCD.lcd.addLine(CFA634SPI.Line.kUser4, "Gyro Angle");
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        SmartDashboard.putNumber("Batt Voltage", DriverStation.getInstance().getBatteryVoltage());
        SmartDashboard.putNumber("Gyro Angle", RobotMap.chassisGyro.getAngle());
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
}
