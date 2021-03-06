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
import com.sun.squawk.util.MathUtils;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.Preferences;
import edu.wpi.first.wpilibj.buttons.NetworkButton;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import org.usfirst.frc330.Beachbot2013Java.Robot;
/*
 * $Log: ControlLEDs.java,v $
 * Revision 1.9  2013-03-17 01:57:22  jdavid
 * Added pickup sensor
 *
 * Revision 1.8  2013-03-16 02:23:30  jross
 * fix logic errors
 *
 * Revision 1.7  2013-03-15 02:59:19  echan
 * robotbuilder update
 *
 * Revision 1.6  2013-03-15 02:50:30  echan
 * added cvs log comments
 *
 */
/**
 *
 */
public class  ControlLEDs extends Command {
    
    public ControlLEDs() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
	
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=REQUIRES
        requires(Robot.vision);
    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=REQUIRES
        setRunWhenDisabled(true);
        Robot.vision.turnOffHighShooterLED();
        Robot.vision.turnOnLowShooterLED();
    }
    // Called just before this Command runs the first time
    double LEDOffangle;
    double LEDOnangle;
    protected void initialize() {
        LEDOffangle = Robot.vision.turnOffLEDAngle();
        LEDOnangle = Robot.vision.turnOnLEDAngle();
    }
    // Called repeatedly when this Command is scheduled to run
    protected void execute() {       
//        if (Robot.vision.getLEDOverride() ||  DriverStation.getInstance().isFMSAttached())
        {
            Robot.vision.turnOnHighShooterLED();
            Robot.vision.turnOnLowShooterLED();
        }
 /*       else
        {
            Robot.vision.turnOffHighShooterLED();
            Robot.vision.turnOffLowShooterLED();
        }*/
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
