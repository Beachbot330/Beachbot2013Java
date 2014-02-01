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
/*
 * $Log: Wait.java,v $
 * Revision 1.3  2013-02-16 06:26:55  jross
 * Copy drive commands from beachbot2012robotbuilder
 *
 * Revision 1.3  2013-01-03 04:54:13  jross
 * Whitespace changes from RobotBuilder
 *
 * Revision 1.2  2013-01-02 04:37:43  jross
 * Import code from Beachbot2012JavaBeta Project
 *
 */
/**
 * Do nothing until the timeout elapses
 * @author Joe Ross
 */
public class Wait extends Command implements AutoSpreadsheetCommand {
    
    public Wait(double timeout) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=REQUIRES
    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=REQUIRES
        setTimeout(timeout);
    }
    // Called just before this Command runs the first time
    protected void initialize() {
    }
    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    }
    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return isTimedOut();
    }
    // Called once after isFinished returns true
    protected void end() {
    }
    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }    
    
    /**
     * The specified timeout, in seconds
     * @param timeout 
     */
    public void setParam1(double timeout) {
        setTimeout(timeout);
    }
    /**
     * Not Used
     * @param param2 
     */
    public void setParam2(double param2) {
    }
    /**
     * Not Used
     * @param param3 
     */
    public void setParam3(double param3) {
    }
    /**
     * Not used
     * @param stopAtEnd 
     */
    public void setStopAtEnd(boolean stopAtEnd) {
    }
    public Command copy() {
        return new Wait(0);
    }
}
