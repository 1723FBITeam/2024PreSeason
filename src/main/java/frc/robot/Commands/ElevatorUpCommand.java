package frc.robot.Commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.ElevatorSubsystem;

public class ElevatorUpCommand extends Command {
  /** Creates a new ElevatorCommand. */
  private ElevatorSubsystem elevatorSubsystem;

  public ElevatorUpCommand(ElevatorSubsystem elevatorSubsystem) {
    this.elevatorSubsystem = elevatorSubsystem;
   
    addRequirements(elevatorSubsystem);

  
    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    System.out.println("elevator up command");
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
      elevatorSubsystem.spool(-1);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    elevatorSubsystem.spool(0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}