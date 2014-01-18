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

public class DriveEncoderRel extends DriveEncoder{
    public DriveEncoderRel(double distance, double tolerance, double timeout, boolean stopAtEnd)
    {
        super(distance, tolerance, timeout, stopAtEnd);
    }
    
    public DriveEncoderRel()
    {
        super(0,0,0,true);
    }

    protected void initialize() {
        leftDistance = leftDistance + Robot.chassis.getLeftDistance();
        rightDistance = rightDistance + Robot.chassis.getRightDistance();
        super.initialize();
    }
    
    public Command copy() {
        return new DriveEncoderRel();
    }
    
    
}
