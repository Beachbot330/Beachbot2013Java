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
import org.usfirst.frc330.Beachbot2013Java.RobotMap;
import org.usfirst.frc330.Beachbot2013Java.commands.*;
import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.command.Subsystem;
import org.usfirst.frc330.Beachbot2013Java.Robot;
/**
 *
 */
public class FrisbeePickup extends Subsystem {
    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    SpeedController frisbeePickupController = RobotMap.frisbeePickupFrisbeePickupController;
    DoubleSolenoid pickupSolenoid = RobotMap.frisbeePickupPickupSolenoid;
    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS

    public FrisbeePickup() {
        Robot.frisbeePickup.InitializeSlowFrisbeePickup();
    }
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
    public void initDefaultCommand() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND
    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND
	
        // Set the default command for a subsystem here.
        setDefaultCommand(new PickupUp());
    }
    public void FrisbeePickup()
    {
        if (!Preferences.getInstance().containsKey("FrisbeePickupMotorOutput"))
        {
            Preferences.getInstance().putDouble("FrisbeePickupMotorOutput", 0.6);
            Preferences.getInstance().save();
        }
    }
    
    public void InitializeSlowFrisbeePickup()
    {
        if (!Preferences.getInstance().containsKey("SlowFrisbeePickupMotorOutput"))
        {
            Preferences.getInstance().putDouble("SlowFrisbeePickupMotorOutput", 0.3);
            Preferences.getInstance().save();
        }
    }
    
    
        public void setFrisbeePickupUp()
    {
      pickupSolenoid.set(DoubleSolenoid.Value.kReverse);
//        System.err.println("setFrisbeePickupUp");
    }
    
    public void setFrisbeePickupDown()
    {
        pickupSolenoid.set(DoubleSolenoid.Value.kForward);
//        System.err.println("setFrisbeePickupDown");
    }
    
    public void setFrisbeePickupMotorStop()
    {
        frisbeePickupController.set(0);
//        System.err.println("setFrisbeePickupMotorStop");
    }
    
    public void setFrisbeePickupMotor(double speed)
    {
        frisbeePickupController.set(speed);
//        System.err.println("setFrisbeePickupMotor: " + speed);
    }
    
    public void setFrisbeePickupMotorPickup()
    {
        frisbeePickupController.set(Preferences.getInstance().getDouble("FrisbeePickupMotorOutput", 0.6));
//        System.err.println("setFrisbeePickupMotorPickup");
    }
    
    public void setSlowFrisbeePickupMotorPickup()
    {
        frisbeePickupController.set(Preferences.getInstance().getDouble("SlowFrisbeePickupMotorOutput", 0.3));
//        System.err.println("setSlowFrisbeePickupMotorPickup");
    }
    
    public void setFrisbeePickupMotorReverse()
    {
        frisbeePickupController.set(-Preferences.getInstance().getDouble("FrisbeePickupMotorOutput", 0.6));
//        System.err.println("setFrisbeePickupMotorReverse");
    }
}
