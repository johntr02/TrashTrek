// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj.motorcontrol.MotorController;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Drivebase extends SubsystemBase {
  /** Creates a new ExampleSubsystem. */
  public Drivebase() {}

  //create motor objects
  MotorController m_leftSlave = new CANSparkMax(1, MotorType.kBrushless);
  MotorController m_leftMiddleMaster = new CANSparkMax(2, MotorType.kBrushless);
  MotorController m_leftBackSlave = new CANSparkMax(3, MotorType.kBrushless);
  MotorController m_rightFrontSlave = new CANSparkMax(4, MotorType.kBrushless);
  MotorController m_rightMiddleMaster = new CANSparkMax(5, MotorType.kBrushless);
  MotorController m_rightBackSlave = new CANSparkMax(6, MotorType.kBrushless);

  //group of motor objects
  MotorControllerGroup m_leftGroup = new MotorControllerGroup(m_leftFrontSlave, m_leftMiddleMaster, m_leftMiddleSlave);
  MotorControllerGroup m_rightGroup = new MotorControllerGroup(m_rightFrontSlave, m_rightMiddleMaster, m_rightMiddleSlave);
  
  //invert so robot so left and right motors go same direction go forward
  m_leftGroup.setInverted(true);

  //differential drive object
  DifferentialDrive m_drive = new DifferentialDrive(m_leftGroup, m_rightGroup);

  //arcadeDrive method
  public void arcadeDrive(double xSpeed, double zRotation){
    m_drive.arcadeDrive(xSpeed, zRotation);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  @Override
  public void simulationPeriodic() {
    // This method will be called once per scheduler run during simulation
  }
}
