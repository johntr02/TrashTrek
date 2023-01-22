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
import com.revrobotics.SparkMaxRelativeEncoder;
import com.revrobotics.SparkMaxRelativeEncoder.Type;

public class Elevator extends SubsystemBase {
  
  /** Creates a new ExampleSubsystem. */
  public Elevator() {
    //create soft limit 
    m_neoElevatorMotor.setSoftLimit(SoftLimitDirection.kReverse, 0); 
  }

  //motor object
  public final CANSparkMax m_neoElevatorMotor = new CANSparkMax(0, MotorType.kBrushless);

  //limit switch and its encoder 
  private final SparkMaxLimitSwitch m_ElevatorLimitSwitch = m_neoElevatorMotor.getForwardLimitSwitch(Type.kNormallyOpen);
  private final SparkMaxRelativeEncoder m_ElevatorLimitSwitchEncoder = CANSparkMax.getEncoder(Type.kQuadrature, 8192);

  //return if limit switch is pressed
  public boolean limitSwitchPressed(){
    return m_limitSwitch.isPressed();
  }

  //pid method
  public void elevatorPID(double setpoint){
    if()
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
