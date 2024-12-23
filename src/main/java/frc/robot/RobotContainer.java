// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import com.ctre.phoenix6.Utils;
import com.ctre.phoenix6.mechanisms.swerve.SwerveRequest;
import com.ctre.phoenix6.mechanisms.swerve.SwerveModule.DriveRequestType;

import edu.wpi.first.math.geometry.Pose2d;
import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.math.geometry.Translation2d;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import frc.robot.Commands.AngleCommand;
import frc.robot.Commands.ElevatorDownCommand;
import frc.robot.Commands.ElevatorUpCommand;
import frc.robot.Commands.FunnelIntake;
import frc.robot.Commands.ReverseFunnelIntake;
import frc.robot.Commands.ShootCommand;
import frc.robot.generated.TunerConstants;
import frc.robot.subsystems.AngleMotorSubsystem;
import frc.robot.subsystems.CommandSwerveDrivetrain;
import frc.robot.subsystems.ShooterSubsystem;
import frc.robot.subsystems.FunnelMotorSubsystem;
import frc.robot.subsystems.ElevatorSubsystem;

public class RobotContainer {
  private double MaxSpeed = TunerConstants.kSpeedAt12VoltsMps; // kSpeedAt12VoltsMps desired top speed
  private double MaxAngularRate = 1 * Math.PI; // 3/4 of a rotation per second max angular velocity

  private final FunnelMotorSubsystem funnelMotorSubsystem = new FunnelMotorSubsystem();
  /* Setting up bindings for necessary control of the swerve drive platform */
  private final CommandXboxController joystick = new CommandXboxController(0); // My joystick
  private final CommandSwerveDrivetrain drivetrain = TunerConstants.DriveTrain; // My drivetrain
  private final ShootCommand shooter = new ShootCommand(new ShooterSubsystem());
  private final FunnelIntake funnel = new FunnelIntake(funnelMotorSubsystem);
  private final AngleCommand AngleUp = new AngleCommand(new AngleMotorSubsystem());
  private final ReverseFunnelIntake funnelReverse = new ReverseFunnelIntake(funnelMotorSubsystem);
  private final ElevatorDownCommand down = new ElevatorDownCommand(new ElevatorSubsystem());
  private final ElevatorUpCommand up = new ElevatorUpCommand(new ElevatorSubsystem());


  private final SwerveRequest.FieldCentric drive = new SwerveRequest.FieldCentric()
      .withDeadband(MaxSpeed * 0.1).withRotationalDeadband(MaxAngularRate * 0.1) // Add a 10% deadband
      .withDriveRequestType(DriveRequestType.OpenLoopVoltage); // I want field-centric
                                                               // driving in open loop
  private final SwerveRequest.SwerveDriveBrake brake = new SwerveRequest.SwerveDriveBrake();
  private final SwerveRequest.PointWheelsAt point = new SwerveRequest.PointWheelsAt();

  private final Telemetry logger = new Telemetry(MaxSpeed);

  private void configureBindings() {
    drivetrain.setDefaultCommand( // Drivetrain will execute this command periodically
        drivetrain.applyRequest(() -> drive.withVelocityX(-joystick.getLeftY() * MaxSpeed) // Drive forward with
                                                                                           // negative Y (forward)
            .withVelocityY(-joystick.getLeftX() * MaxSpeed) // Drive left with negative X (left)
            .withRotationalRate(-joystick.getRightX() * MaxAngularRate) // Drive counterclockwise with negative X (left)
        ));

    joystick.rightBumper().whileTrue(drivetrain.applyRequest(() -> brake));
    joystick.leftBumper().whileTrue(drivetrain
        .applyRequest(() -> point.withModuleDirection(new Rotation2d(-joystick.getLeftY(), -joystick.getLeftX()))));

    joystick.b().whileTrue(shooter);
    joystick.back().whileTrue(funnel);
    joystick.start().whileTrue(funnelReverse);
    joystick.y().whileTrue(AngleUp);
    joystick.x().whileTrue(AngleUp);
    joystick.leftTrigger().whileTrue(up);
    joystick.rightTrigger().whileTrue(down);


    // reset the field-centric heading on left bumper press
    joystick.a().onTrue(drivetrain.runOnce(() -> drivetrain.seedFieldRelative()));

    if (Utils.isSimulation()) {
      drivetrain.seedFieldRelative(new Pose2d(new Translation2d(), Rotation2d.fromDegrees(90)));
    }
    drivetrain.registerTelemetry(logger::telemeterize);
  }

  public RobotContainer() {
    configureBindings();
  }

  public Command getAutonomousCommand() {
    return Commands.print("No autonomous command configured");
  }
}
