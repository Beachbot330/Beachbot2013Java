// RobotBuilder Version: 1.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.
package org.usfirst.frc330.Beachbot2014Java.subsystems;
import org.usfirst.frc330.Beachbot2014Java.RobotMap;
import org.usfirst.frc330.Beachbot2014Java.commands.*;
import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.command.Subsystem;
/**
 *
 */
public class Chassis extends Subsystem {
    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    SpeedController leftDrive1 = RobotMap.chassisLeftDrive1;
    SpeedController leftDrive2 = RobotMap.chassisLeftDrive2;
    SpeedController leftDrive3 = RobotMap.chassisLeftDrive3;
    SpeedController rightDrive1 = RobotMap.chassisRightDrive1;
    SpeedController rightDrive2 = RobotMap.chassisRightDrive2;
    SpeedController rightDrive3 = RobotMap.chassisRightDrive3;
    Compressor compressor = RobotMap.chassisCompressor;
    DoubleSolenoid shiftSolenoid = RobotMap.chassisShiftSolenoid;
    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
    double leftManual = 0;
    double rightManual = 0;
    
    public void initDefaultCommand() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND
        setDefaultCommand(new TankDrive());
    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND
	
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    public Chassis (){ 
        compressor.start();
    }
    
     public void tankDrive(Joystick leftJoystick, Joystick rightJoystick)
    {
        leftManual = leftJoystick.getY();
        
        leftDrive1.set(leftManual);
        leftDrive2.set(leftManual);
        leftDrive3.set(leftManual);
        
        rightManual = rightJoystick.getY();
        
        rightDrive1.set(rightManual);
        rightDrive2.set(rightManual);
        rightDrive3.set(rightManual);
    }
    
    public void tankDrive(double left, double right)
    {
        leftManual = left;
        rightManual = right;
    }
    
    public void stopDrive()
    {
        tankDrive(0,0);
    }
    
    public void shiftHigh()
    {
        shiftSolenoid.set(DoubleSolenoid.Value.kForward);
    }
    
    public void shiftLow()
    {
        shiftSolenoid.set(DoubleSolenoid.Value.kReverse);
    }
}