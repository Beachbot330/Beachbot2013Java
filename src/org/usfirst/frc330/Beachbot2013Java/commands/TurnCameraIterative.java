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
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import org.usfirst.frc330.Beachbot2013Java.Robot;
import org.usfirst.frc330.Beachbot2013Java.subsystems.Chassis;
/*
 * $Log$
 */
 
/**
 *
 */
public class  TurnCameraIterative extends Command {
    public static final int waitingForCamera = 1;
    public static final int checkingCamera = 0;
    public static final int turning = 2;
    private int state;
    double angle = 0;
    double tolerance = 3;
    double stopTime = 0;
    boolean finished = false;
    public TurnCameraIterative() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
	
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=REQUIRES
        requires(Robot.chassis);
    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=REQUIRES
    }
    // Called just before this Command runs the first time
    protected void initialize() {
        state = checkingCamera;
        Robot.chassis.stopDrive();
        Robot.chassis.gyroPID.setAbsoluteTolerance(tolerance);
        if (!Robot.chassis.getShiftState())
        {
            Robot.chassis.gyroPID.setGainName(Chassis.TURNLOW);
        }
        else
        {
            Robot.chassis.gyroPID.setGainName(Chassis.TURNHIGH);
        }
        Robot.chassis.gyroPID.setSetpoint(angle);
        Robot.chassis.gyroPID.enable();
    }
    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        switch (state)
        {
            case checkingCamera:
                //check if camera data is valid by checking centerAge. If valid, turn towards it
                //If not valid, go to wait for camera state
                if (SmartDashboard.getNumber("centerAge", 1) < 0.5)
                {
                    angle = SmartDashboard.getNumber("angleToCenter", 0);
                    state = turning;
                    Robot.chassis.gyroPID.setSetpoint(Robot.chassis.getAngle() + angle);
                    Robot.chassis.gyroPID.enable();
                    if (Robot.chassis.gyroPID.onTarget())
                    {
                        finished = true;
                    }
                }
                else
                {
                    angle = 0;
                    state = waitingForCamera;
                    stopTime = Timer.getFPGATimestamp() + 0.5;
                    Robot.chassis.gyroPID.disable();
                }
                break;
            case waitingForCamera:
                //wait until camera gets a good image or the timer expires. If the timer
                //expires, end the command
                if (Timer.getFPGATimestamp() < stopTime)
                {
                    if (SmartDashboard.getNumber("centerAge", 1) < 0.5)
                    {
                        angle = SmartDashboard.getNumber("angleToCenter", 0);
                        state = turning;
                        Robot.chassis.gyroPID.setSetpoint(Robot.chassis.getAngle() + angle);
                        if (Robot.chassis.gyroPID.onTarget())
                        {
                            finished = true;
                        }
                    }
                }
                else
                    //timed out
                    finished = true;
                break;
            case turning:
                //turn until gyro is on target and then check camera againS
                if (Robot.chassis.gyroPID.onTarget())
                    state = checkingCamera;
                break;
        }
    }
    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return finished;
    }
    // Called once after isFinished returns true
    protected void end() {
    }
    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
