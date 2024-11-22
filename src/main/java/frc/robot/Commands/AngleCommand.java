package frc.robot.Commands;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import frc.robot.subsystems.AngleMotorSubsystem;

public class AngleCommand extends Command {
  /** Creates a new ElevatorCommand. */
  private AngleMotorSubsystem angleMotorSubsystem;
  private final CommandXboxController joystick = new CommandXboxController(0); // My joystick

  public AngleCommand(AngleMotorSubsystem angleMotorSubsystem) {
    this.angleMotorSubsystem = angleMotorSubsystem;

    addRequirements(angleMotorSubsystem);

    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    System.out.println("angle up command");
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    if (joystick.y().getAsBoolean()) {
      angleMotorSubsystem.Angle(-0.2);
    } else {
      angleMotorSubsystem.Angle(0.1);
    }

  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    angleMotorSubsystem.Angle(0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}