package frc.robot.subsystems;


import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkBase.IdleMode;


public class FunnelMotorSubsystem extends SubsystemBase {

  private CANSparkMax spinMotorClockwise;

  public FunnelMotorSubsystem() {

    spinMotorClockwise = new CANSparkMax(Constants.Funnel.spinMotorLeftPort, com.revrobotics.CANSparkLowLevel.MotorType.kBrushless);

    spinMotorClockwise.setIdleMode(IdleMode.kBrake);

  }

  public void spin(double multiplier) {
    spinMotorClockwise.set(.8 * multiplier);
  }

  public void spinMotorClockwise(double multiplier) {
    spinMotorClockwise.set(.8 * multiplier);
  }

 

  public void spinMotors() {
    // Now CANSparkMax objects are initialized
  }
}