// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandScheduler;

import com.ctre.phoenix6.hardware.*;
import edu.wpi.first.wpilibj.motorcontrol.PWMSparkMax;

import com.ctre.phoenix.motorcontrol.VictorSPXControlMode;
// import com.ctre.phoenix6.hardware.*;
// import com.ctre.phoenix6.mechanisms.*;
import com.ctre.phoenix.motorcontrol.can.*;
// import com.ctre.phoenix.signals.*;
import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.VictorSPXControlMode;


/**
 * The methods in this class are called automatically corresponding to each mode, as described in
 * the TimedRobot documentation. If you change the name of this class or the package after creating
 * this project, you must also update the Main.java file in the project.
 */
public class Robot extends TimedRobot {
  private static final String kDefaultAuto = "Default";
  private static final String kCustomAuto = "My Auto";
  private String m_autoSelected;
  private final SendableChooser<String> m_chooser = new SendableChooser<>();
  private final RobotContainer m_robotContainer;
  // private final XboxController controller = new XboxController(0);

  // private final TalonFX gripperMotor = new TalonFX(0);
  // private final TalonFX armRotateMotor = new TalonFX(1);
  // private final TalonFX lowerSegmentMotor = new TalonFX(2);
  // private final TalonFX upperSegmentMotor = new TalonFX(3);
  // private final TalonFX gripperMotorRotate = new TalonFX(4);

  // private final WPI_VictorSPX testMotor = new WPI_VictorSPX(5);

  // private static double lowerSegMotorRatio = 0.0;
  // private static double upperSegMotorRatio = 0.0;
  // private static double gripperMotorRotateRatio = 0.0;

  // double gripperRotateSpeed = 0.0;

  /**
   * This function is run when the robot is first started up and should be used for any
   * initialization code.
   */
  public Robot() {
    m_chooser.setDefaultOption("Default Auto", kDefaultAuto);
    m_chooser.addOption("My Auto", kCustomAuto);
    SmartDashboard.putData("Auto choices", m_chooser);
    m_robotContainer = new RobotContainer();
  }

  /**
   * This function is called every 20 ms, no matter the mode. Use this for items like diagnostics
   * that you want ran during disabled, autonomous, teleoperated and test.
   *
   * <p>This runs after the mode specific periodic functions, but before LiveWindow and
   * SmartDashboard integrated updating.
   */
  @Override
  public void robotPeriodic() {
    CommandScheduler.getInstance().run(); 
    
  }

  /**
   * This autonomous (along with the chooser code above) shows how to select between different
   * autonomous modes using the dashboard. The sendable chooser code works with the Java
   * SmartDashboard. If you prefer the LabVIEW Dashboard, remove all of the chooser code and
   * uncomment the getString line to get the auto name from the text box below the Gyro
   *
   * <p>You can add additional auto modes by adding additional comparisons to the switch structure
   * below with additional strings. If using the SendableChooser make sure to add them to the
   * chooser code above as well.
   */
  @Override
  public void autonomousInit() {
    m_autoSelected = m_chooser.getSelected();
    // m_autoSelected = SmartDashboard.getString("Auto Selector", kDefaultAuto);
    System.out.println("Auto selected: " + m_autoSelected);
  }

  /** This function is called periodically during autonomous. */
  @Override
  public void autonomousPeriodic() {
    // testMotor.set(1.0);
    switch (m_autoSelected) {
      case kCustomAuto:
        // Put custom auto code here
        break;
      case kDefaultAuto:
      default:
        // Put default auto code here
        break;
    }
  }

  /** This function is called once when teleop is enabled. */
  @Override
  public void teleopInit() {
    // gripperRotateSpeed = 0.0;
  }

  /** This function is called periodically during operator control. */
  @Override
  public void teleopPeriodic() {
    // if(Math.abs(gripperRotateSpeed) <= 1.0){
    //   if (controller.getPOV() == 0){
    //     gripperRotateSpeed+= 0.2;
    //   }
    //   else if (controller.getPOV() == 180){
    //     gripperRotateSpeed -= 0.2;
    //   }
    // }
    // gripperMotorRotate.set(gripperRotateSpeed);
    // lowerSegmentMotor.set(-controller.getLeftY());
    // upperSegmentMotor.set(-controller.getRightY());
  }

  /** This function is called once when the robot is disabled. */
  @Override
  public void disabledInit() {}

  /** This function is called periodically when disabled. */
  @Override
  public void disabledPeriodic() {}

  /** This function is called once when test mode is enabled. */
  @Override
  public void testInit() {}

  /** This function is called periodically during test mode. */
  @Override
  public void testPeriodic() {}

  /** This function is called once when the robot is first started up. */
  @Override
  public void simulationInit() {}

  /** This function is called periodically whilst in simulation. */
  @Override
  public void simulationPeriodic() {}
}
