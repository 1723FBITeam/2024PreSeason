package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.TalonSRXControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class ElevatorSubsystem extends SubsystemBase {
  /** Creates a new ElevatorSub. */
  
  private TalonSRX spoolMotorLeft = new TalonSRX(Constants.Elevator.spoolMotorLeftPort); // robot's left (intake motor)
  private TalonSRX spoolMotorRight = new TalonSRX(Constants.Elevator.spoolMotorRightPort); // robot's right (intake motor)

  public ElevatorSubsystem() {
    spoolMotorLeft.setNeutralMode(NeutralMode.Brake);
    spoolMotorRight.setNeutralMode(NeutralMode.Brake);
  }

  public void spool(double multiplier){
    spoolMotorLeft.set(TalonSRXControlMode.PercentOutput, (0.8)*(multiplier));
    spoolMotorRight.set(TalonSRXControlMode.PercentOutput, (0.8)*(multiplier));
  }
  
  public void spoolRight(double multiplier){
    spoolMotorRight.set(TalonSRXControlMode.PercentOutput, (0.8)*(multiplier));
  }

  public void spoolLeft(double multiplier){
    spoolMotorLeft.set(TalonSRXControlMode.PercentOutput, (0.8)*(multiplier));
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run

  }
}