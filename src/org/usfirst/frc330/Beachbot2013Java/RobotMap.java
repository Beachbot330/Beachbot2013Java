// RobotBuilder Version: 0.0.2
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in th future.
package org.usfirst.frc330.Beachbot2013Java;
    
import edu.wpi.first.wpilibj.AnalogChannel;
import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.CounterBase.EncodingType;
import edu.wpi.first.wpilibj.DigitalOutput;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Encoder.PIDSourceParameter;
import edu.wpi.first.wpilibj.Gyro;
import edu.wpi.first.wpilibj.Jaguar;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    public static SpeedController chassisLeftDriveJaguar1;
    public static SpeedController chassisLeftDriveJaguar2;
    public static SpeedController chassisRightDriveJaguar1;
    public static SpeedController chassisRightDriveJaguar2;
    public static RobotDrive chassisRobotDrive;
    public static Gyro chassisGyro;
    public static Encoder chassisLeftDriveEncoder;
    public static Encoder chassisRightDriveEncoder;
    public static Compressor chassisCompressor;
    public static DoubleSolenoid chassisShiftSolenoid;
    public static SpeedController frisbeePickupFrisbeePickupController;
    public static DoubleSolenoid frisbeePickupPickupSolenoid;
    public static SpeedController shooterHighShooterHighController;
    public static Encoder shooterHighShooterHighEncoder;
    public static SpeedController shooterLowShooterLowController;
    public static DoubleSolenoid shooterLowShooterLoadSolenoid;
    public static Encoder shooterLowShooterLowEncoder;
    public static DigitalOutput visionHighShooterLED;
    public static DigitalOutput visionLowShooterLED;
    public static SpeedController armArmSpeedController;
    public static AnalogChannel armPotentiometer;
    public static DoubleSolenoid armBrakeArmSolenoid;
    public static DigitalOutput lCDmosi;
    public static DigitalOutput lCDcs;
    public static DigitalOutput lCDclk;
    public static DoubleSolenoid armShooterLoadSolenoid;
    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    public static void init() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
        chassisLeftDriveJaguar1 = new Jaguar(1, 1);
	LiveWindow.addActuator("Chassis", "LeftDriveJaguar1", (Jaguar) chassisLeftDriveJaguar1);
        
        chassisLeftDriveJaguar2 = new Jaguar(1, 2);
	LiveWindow.addActuator("Chassis", "LeftDriveJaguar2", (Jaguar) chassisLeftDriveJaguar2);
        
        chassisRightDriveJaguar1 = new Jaguar(1, 3);
	LiveWindow.addActuator("Chassis", "RightDriveJaguar1", (Jaguar) chassisRightDriveJaguar1);
        
        chassisRightDriveJaguar2 = new Jaguar(1, 4);
	LiveWindow.addActuator("Chassis", "RightDriveJaguar2", (Jaguar) chassisRightDriveJaguar2);
        
        chassisRobotDrive = new RobotDrive(chassisLeftDriveJaguar1, chassisLeftDriveJaguar2,
              chassisRightDriveJaguar1, chassisRightDriveJaguar2);
	
        chassisRobotDrive.setSafetyEnabled(true);
        chassisRobotDrive.setExpiration(0.1);
        chassisRobotDrive.setSensitivity(0.5);
        chassisRobotDrive.setMaxOutput(1.0);
        chassisGyro = new Gyro(1, 1);
	LiveWindow.addSensor("Chassis", "Gyro", chassisGyro);
        chassisGyro.setSensitivity(0.007);
        chassisLeftDriveEncoder = new Encoder(1, 5, 1, 6, false, EncodingType.k4X);
	LiveWindow.addSensor("Chassis", "LeftDriveEncoder", chassisLeftDriveEncoder);
        chassisLeftDriveEncoder.setDistancePerPulse(0.07539822368615504);
        chassisLeftDriveEncoder.setPIDSourceParameter(PIDSourceParameter.kDistance);
        chassisLeftDriveEncoder.start();
        chassisRightDriveEncoder = new Encoder(1, 7, 1, 8, true, EncodingType.k4X);
	LiveWindow.addSensor("Chassis", "RightDriveEncoder", chassisRightDriveEncoder);
        chassisRightDriveEncoder.setDistancePerPulse(0.07539822368615504);
        chassisRightDriveEncoder.setPIDSourceParameter(PIDSourceParameter.kDistance);
        chassisRightDriveEncoder.start();
        chassisCompressor = new Compressor(1, 14, 1, 8);
	
        
        chassisShiftSolenoid = new DoubleSolenoid(1, 3, 4);      
	
        
        frisbeePickupFrisbeePickupController = new Victor(1, 8);
	LiveWindow.addActuator("FrisbeePickup", "FrisbeePickupController", (Victor) frisbeePickupFrisbeePickupController);
        
        frisbeePickupPickupSolenoid = new DoubleSolenoid(1, 1, 2);      
	
        
        shooterHighShooterHighController = new Talon(1, 5);
	LiveWindow.addActuator("Shooter High", "ShooterHighController", (Talon) shooterHighShooterHighController);
        
        shooterHighShooterHighEncoder = new Encoder(1, 1, 1, 2, false, EncodingType.k1X);
	LiveWindow.addSensor("Shooter High", "ShooterHighEncoder", shooterHighShooterHighEncoder);
        shooterHighShooterHighEncoder.setDistancePerPulse(1.0);
        shooterHighShooterHighEncoder.setPIDSourceParameter(PIDSourceParameter.kRate);
        shooterHighShooterHighEncoder.start();
        shooterLowShooterLowController = new Victor(1, 6);
	LiveWindow.addActuator("Shooter Low", "ShooterLowController", (Victor) shooterLowShooterLowController);
        
        shooterLowShooterLoadSolenoid = new DoubleSolenoid(1, 5, 6);      
	
        
        shooterLowShooterLowEncoder = new Encoder(1, 3, 1, 4, false, EncodingType.k1X);
	LiveWindow.addSensor("Shooter Low", "ShooterLowEncoder", shooterLowShooterLowEncoder);
        shooterLowShooterLowEncoder.setDistancePerPulse(1.0);
        shooterLowShooterLowEncoder.setPIDSourceParameter(PIDSourceParameter.kRate);
        shooterLowShooterLowEncoder.start();
        visionHighShooterLED = new DigitalOutput(1, 9);
	
        
        visionLowShooterLED = new DigitalOutput(1, 10);
	
        
        armArmSpeedController = new Jaguar(1, 7);
	LiveWindow.addActuator("Arm", "ArmSpeedController", (Jaguar) armArmSpeedController);
        
        armPotentiometer = new AnalogChannel(1, 3);
	LiveWindow.addSensor("Arm", "Potentiometer", armPotentiometer);
        
        armBrakeArmSolenoid = new DoubleSolenoid(1, 7, 8);      
	
        
        lCDmosi = new DigitalOutput(1, 11);
	
        
        lCDcs = new DigitalOutput(1, 12);
	
        
        lCDclk = new DigitalOutput(1, 13);
	
        
    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
    }
}
