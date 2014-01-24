// RobotBuilder Version: 0.0.2
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in th future.
package org.usfirst.frc330.Beachbot2014Java.commands;
import edu.wpi.first.wpilibj.command.AutoSpreadsheetCommand;
import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc330.Beachbot2014Java.Robot;
import org.usfirst.frc330.Beachbot2014Java.commands.TurnGyroAbs;
/*
 * $Log$
 */
 
/**
 *
 */
public class  TurnGyroRel extends TurnGyroAbs{
    
    public TurnGyroRel(double angle) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
        this(angle, 0, 15, false);
    }
    
    public TurnGyroRel(double angle, double tolerance)
    {
        this(angle, tolerance, 15, false);
    }
    
    public TurnGyroRel(double angle, double tolerance, double timeout, boolean stopAtEnd) {
        super(angle,tolerance,timeout,stopAtEnd);
    }
    // Called just before this Command runs the first time
    protected void initialize() {
        super.initialize();
        Robot.chassis.gyroPID.setSetpoint(angle+Robot.chassis.getAngle());
        Robot.chassis.gyroPID.enable();
    }
    public Command copy() {
        return new TurnGyroRel(0);
    }
}
