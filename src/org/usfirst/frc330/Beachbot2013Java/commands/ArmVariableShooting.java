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
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.AutoSpreadsheetCommand;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import org.usfirst.frc330.Beachbot2013Java.Robot;
/**
 *
 */
public class  ArmVariableShooting extends Command implements AutoSpreadsheetCommand {
    public ArmVariableShooting() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
	
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=REQUIRES
        requires(Robot.arm);
    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=REQUIRES
    }
    // Called just before this Command runs the first time
    double timer;
    protected void initialize() {
        Robot.frisbeePickup.setFrisbeePickupDown(); 
        timer = Robot.frisbeePickup.getPickupDownTime() + Robot.arm.armWaitShooting();
        Robot.arm.disable();
        //Robot.arm.armSetPointLowShooting();
        Robot.arm.initFilteredDistance();
        Robot.arm.armSetPointLowCheckVision();
        SmartDashboard.putBoolean("BrightCamera", false);
    }
    // Called repeatedly when this Command is scheduled to run
    int counter = 0;
    protected void execute() {
        if (Robot.frisbeePickup.isPickupDown() && Timer.getFPGATimestamp() > timer) {
            if (!Robot.arm.isEnable() && LaunchFrisbee.isShooting() == false)
                Robot.arm.enable();
            else if (LaunchFrisbee.isShooting() == true)
                Robot.arm.disable();
            
            Robot.arm.armSetPointLowCheckVision();
        }
        if (counter%5 == 0)
            SmartDashboard.putNumber("ArmPosition", Robot.arm.getArmPosition());
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
    public void setParam1(double armSetpoint) {
    }
    public void setParam2(double param2) {
    }
    public void setParam3(double param3) {
    }
    public void setStopAtEnd(boolean stopAtEnd) {
    }
    public Command copy() {
        return new ArmVariableShooting();
    }
}
