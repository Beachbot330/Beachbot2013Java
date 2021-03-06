// RobotBuilder Version: 0.0.2
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in th future.
package org.usfirst.frc330.Beachbot2013Java.subsystems;
import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import org.usfirst.frc330.Beachbot2013Java.Robot;
import org.usfirst.frc330.Beachbot2013Java.RobotMap;
import org.usfirst.frc330.Beachbot2013Java.commands.*;
/*
 * $Log: ShooterLow.java,v $
 * Revision 1.15  2013-03-30 21:50:48  jross
 * create preference for give up time for shooter
 *
 * Revision 1.14  2013-03-26 05:43:01  jross
 * whitespace change from robotbuilder
 *
 * Revision 1.13  2013-03-21 04:42:45  jross
 * save setpoint preferences and implement PIDSource and PIDwrite
 *
 * Revision 1.12  2013-03-18 06:46:35  jross
 * fix preference of solenoidofftime
 *
 * Revision 1.11  2013-03-17 18:18:08  jross
 * delete ShootLow as default command (was added for debugging)
 *
 * Revision 1.10  2013-03-17 01:57:05  jross
 * fix shooter cylinder positions to match practice robot
 *
 * Revision 1.9  2013-03-15 02:51:40  echan
 * added cvs log comments
 *
 */
 
/**
 *
 */
public class ShooterLow extends Subsystem implements PIDSource, PIDOutput {
    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    DoubleSolenoid shooterLoadSolenoid = RobotMap.shooterLowShooterLoadSolenoid;
    SpeedController shooterLowController = RobotMap.shooterLowShooterLowController;
    DigitalInput shooterLowHallEffectSensor = RobotMap.shooterLowShooterLowHallEffectSensor;
    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    
    Counter ShooterLowHallEffectCounter = RobotMap.shooterLowShooterLowHallEffectCounter;
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
    public void initDefaultCommand() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND
    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND
	
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
//        setDefaultCommand(new ShootLow());
    }
    double counter=0;
    public void shoot(double voltage) {
        if (counter%10==0)
            SmartDashboard.putNumber("voltageLow", voltage);
        counter++;
        shooterLowController.set(voltage);
    }
    
    public void armLoadShooterOn() {
        shooterLoadSolenoid.set(DoubleSolenoid.Value.kReverse);
    }
    
    public void armLoadShooterOff() {
        shooterLoadSolenoid.set(DoubleSolenoid.Value.kForward);
    }
    
    public double launchFrisbeeSolenoidOffTime() {
        if (!Preferences.getInstance().containsKey("solenoidOffTime"))
        {
            Preferences.getInstance().putDouble("solenoidOffTime", 0.5);
            Preferences.getInstance().save();
        }
        return Preferences.getInstance().getDouble("solenoidOffTime", 0.5);
    }
    
    public double getSpeed()
    {
//        return shooterLowEncoder.getRate();
        return (60/ShooterLowHallEffectCounter.getPeriod());
    }
    
    public double getShootLowSetpoint()
    {
        if (!Preferences.getInstance().containsKey("shootLowSetpoint"))
        {
            Preferences.getInstance().putDouble("shootLowSetpoint", 3200);
            Preferences.getInstance().save();
        }
        return Preferences.getInstance().getDouble("shootLowSetpoint", 3200);
    }
    
    public double getShootLowOutput()
    {
        if (!Preferences.getInstance().containsKey("shootLowOutput"))
        {
            Preferences.getInstance().putDouble("shootLowOutput", 0.8);
            Preferences.getInstance().save();
        }
        return Preferences.getInstance().getDouble("shootLowOutput", 0.8);
    }
    
    public double getShootLowOutputSetpointBelow()
    {
        if (!Preferences.getInstance().containsKey("shootLowOutputSetpointBelow"))
        {
            Preferences.getInstance().putDouble("shootLowOutputSetpointBelow", 200);
            Preferences.getInstance().save();
        }
        return Preferences.getInstance().getDouble("shootLowOutputSetpointBelow", 200);
    }
    
    public double getShootLowBangBangMinOutput()
    {
        if (!Preferences.getInstance().containsKey("shootLowBangBangMinOutput"))
        {
            Preferences.getInstance().putDouble("shootLowBangBangMinOutput", 0.8);
            Preferences.getInstance().save();
        }
        return Preferences.getInstance().getDouble("shootLowBangBangMinOutput", 0.8);
    }
    
    public double getShootLowGiveUpTime()
    {
        if (!Preferences.getInstance().containsKey("shootLowGiveUpTime"))
        {
            Preferences.getInstance().putDouble("shootLowGiveUpTime", 1.5);
            Preferences.getInstance().save();
        }
        return Preferences.getInstance().getDouble("shootLowSetpoint", 1.5);
    }
    
    public void ShooterLowMotorToggle(double voltage)
    {
        if ( voltage == 0 )
            Robot.shooterLow.shoot(voltage);
        else
            Robot.shooterLow.shoot(0);
    }
    public double pidGet() {
        return getSpeed();
    }
    public void pidWrite(double output) {
        shoot(output);
    }
    
}
