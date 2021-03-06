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
import org.usfirst.frc330.Beachbot2013Java.Robot;
import org.usfirst.frc330.Beachbot2013Java.subsystems.Chassis;
/*
 * $Log: DriveEncoderGyro.java,v $
 * Revision 1.8  2013-02-19 10:58:12  jross
 * delete end method, super's end is fine
 *
 * Revision 1.7  2013-02-17 05:16:27  jross
 * whitespace changes from RobotBuilder
 *
 * Revision 1.6  2013-02-17 02:53:43  jross
 * update javadocs
 *
 */
/**
 * Drive the robot a specified distance using encoders and the gyro to keep straight. Finish when
 * one of the encoders is within the specified {@link #setParam2(double) tolerance}. 
 * The {@link #setParam1(double) distance} is relative to the
 * Robot's starting position. The {@link #setParam3(double) angle} is relative 
 * to the angle where the robot started. The angle should be close to the 
 * current angle of the robot (ie this command is not appropriate for both turning and driving).
 * If the robot needs to turn prior to driving straight, use {@link TurnGyroAbs} 
 * first. DriveEncoderGyro should not be used if the robot has previously turned 
 * as the left and right encoders will be at different distances. 
 * {@link DriveEncoderGyroRel} should be used in this case.
 * <p>
 * For example, to drive 10 feet forward, set distance to 120 (inches) and set angle to 0.
 * A reasonable tolerance is 3 inches for normal movements. This will stop the robot
 * when it is between 117 - 123 inches. If a smaller
 * tolerance is used, the robot may not ever reach the tolerance, and the 
 * {@link #setTimeout(double) timeout} will be exceeded. This will slow down the
 * execution of future commands.
 * 
 * @see DriveEncoder
 * @see DriveEncoderRel
 * @see DriveEncoderGyroRamp
 * 
 * @author Joe
 */
public class  DriveEncoderGyro extends DriveEncoder{
    double angle;
    
    public DriveEncoderGyro()
    {
        this(0,0,0,0,true);
    }
    
    public DriveEncoderGyro(double distance, double angle)
    {
        this(distance, 0, angle, 0, true);
    }
    
    public DriveEncoderGyro(double distance, double tolerance, double angle, double timeout, boolean stopAtEnd)
    {
        super(distance, tolerance, timeout, stopAtEnd);
        this.angle = angle;
    }
    // Called just before this Command runs the first time
    protected void initialize() {
        super.initialize();
        if (!Robot.chassis.getShiftState())
        {
            Robot.chassis.gyroPID.setGainName(Chassis.DRIVELOW);
        }
        else
        {
            Robot.chassis.gyroPID.setGainName(Chassis.DRIVEHIGH);
        }
        Robot.chassis.gyroPID.setSetpoint(angle);
        Robot.chassis.gyroPID.enable();            
    }
 
    /**
     * The third parameter in the AutoSpreadsheet, angle.
     * The angle is relative 
     * to the angle where the robot started. The angle should be close to the 
     * current angle of the robot (ie this command is not appropriate for both turning and driving).
     * If the robot needs to turn prior to driving straight, use {@link TurnGyroAbs} 
     * first. 
     * @param angle The angle (in degrees) to maintain while driving
     */
    public void setParam3(double angle) {
        this.angle = angle;
    }
    public Command copy() {
        return new DriveEncoderGyro();
    }
}
