// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import com.revrobotics.CANSparkMax.SoftLimitDirection;
import com.revrobotics.SparkMaxLimitSwitch;
import com.revrobotics.SparkMaxLimitSwitch.Type;
import com.revrobotics.SparkMaxAlternateEncoder;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Elevator extends SubsystemBase {
  
  /** Creates a new ExampleSubsystem. */
  public Elevator() {
    //create soft limit 
    m_neoElevatorMotor.enableSoftLimit(SoftLimitDirection.kForward, true);
    m_neoElevatorMotor.setSoftLimit(SoftLimitDirection.kForward, 0); 
  }

  //motor object
  public final CANSparkMax m_neoElevatorMotor = new CANSparkMax(0, MotorType.kBrushless);

  //limit switch and its encoder 
  private final SparkMaxLimitSwitch m_ElevatorLimitSwitch = m_neoElevatorMotor.getForwardLimitSwitch(Type.kNormallyOpen);
  private final SparkMaxRelativeEncoder m_ElevatorLimitSwitchEncoder = m_neoElevatorMotor.getEncoder(Type.kQuadrature, 8192);

  //elevator getPosition
  private double elevatorPosition = m_neoElevatorMotor.getPosition()*m_neoElevatorMotor.getPositionConversionFactor();

  //return if limit switch is pressed
  public boolean limitSwitchPressed(){
    return m_limitSwitch.isPressed();
  }

  //max height method
  public void maxHeight(){
    while(limitSwitchPressed() == false){
      m_neoElevatorMotor.set(0.6);
    }
    m_neoElevatorMotor.set(0);
  }

  //min height method
  public void minHeight(){
    while(elevatorPosition>m_neoElevatorMotor.getSoftLimit(null)){
      m_neoElevatorMotor.set(-0.6);
    }
    m_neoElevatorMotor.set(0);
  }

  //mid height method
  public voiid midHeight(){
    if(elevatorPosition<500){
      while(elevatorPosition<500){
        m_neoElevatorMotor.set(0.6);
      }
      m_neoElevatorMotor.set(0);
    }
    
    if(elevatorPosition>500){
      while(elevatorPosition>500){
        m_neoElevatorMotor.set(0.6);
      }
      m_neoElevatorMotor.set(0);
    }
  }
  

  @Override
  public void periodic() {
    // This method will be called once per scheduler run

    //smartdashboard limit switch status and height of elevator
    SmartDashboard.putBoolean("LimitSwitchStatus", m_neoElevatorMotor.isLimitSwitchEnabled());
    SmartDashboard.putNumber("Elevator Height", elevatorPosition);
  }

  @Override
  public void simulationPeriodic() {
    // This method will be called once per scheduler run during simulation
  }
}
