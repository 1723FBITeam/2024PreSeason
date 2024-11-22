// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;
import frc.robot.Constants;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.ctre.phoenix6.hardware.TalonFX;

public class ShooterSubsystem extends SubsystemBase {

  private TalonFX shooterMotorFrontLeft;
  private TalonFX shooterMotorFrontRight;
  private TalonFX shooterMotorRearLeft;
  private TalonFX shooterMotorRearRight;
  /** Creates a new ShooterSubsystem. */
  public ShooterSubsystem() {
    shooterMotorFrontLeft = new TalonFX(Constants.FrontLeftPort);
    shooterMotorFrontRight = new TalonFX(Constants.FrontRightPort);
    shooterMotorRearLeft = new TalonFX(Constants.RearLeftPort);
    shooterMotorRearRight = new TalonFX(Constants.RearRightPort);
    // Use addRequirements() here to declare subsystem dependencies.
  }

  public void shoot(){
    shooterMotorFrontLeft.set(1);
    shooterMotorFrontRight.set(-1);
    shooterMotorRearLeft.set(.9);
    shooterMotorRearRight.set(-.9);
  }

  public void intake(){
    shooterMotorFrontLeft.set(-0.1);
    shooterMotorFrontRight.set(0.1);
    shooterMotorRearLeft.set(-0.1);
    shooterMotorRearRight.set(0.1);
  }

  public void stop(){
    shooterMotorFrontLeft.stopMotor();
    shooterMotorFrontRight.stopMotor();
    shooterMotorRearLeft.stopMotor();
    shooterMotorRearRight.stopMotor();
  }
  // Called when the command is initially scheduled.
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  
  public void execute() {}

  // Called once the command ends or is interrupted.
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  public boolean isFinished() {
    return false;
  }


}

