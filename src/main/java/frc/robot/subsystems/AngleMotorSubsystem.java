package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkBase.IdleMode;


public class AngleMotorSubsystem extends SubsystemBase {

  private CANSparkMax AngleUp;
  private CANSparkMax AngleDown;

  public AngleMotorSubsystem() {

    AngleUp = new CANSparkMax(Constants.Angle.angleMotorLeftPort, com.revrobotics.CANSparkLowLevel.MotorType.kBrushless);
    AngleDown = new CANSparkMax(Constants.Angle.angleMotorRightPort, com.revrobotics.CANSparkLowLevel.MotorType.kBrushless);

    AngleUp.setIdleMode(IdleMode.kBrake);
    AngleDown.setIdleMode(IdleMode.kBrake);

  }

  public void Angle(double multiplier) {
    AngleUp.set(0.3 * multiplier);
    AngleDown.set(0.3 * multiplier);
  }

  public void AngleUp(double multiplier) {
    AngleUp.set(0.3 * multiplier);
  }

  public void AngleDown(double multiplier) {
    AngleDown.set(0.3 * multiplier);
  }

  public void angleMotors() {
    // Now CANSparkMax objects are initialized
  }
}