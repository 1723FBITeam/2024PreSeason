package frc.robot.Commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.FunnelMotorSubsystem;

public class FunnelIntake extends Command {
  /** Creates a new ElevatorCommand. */
  private FunnelMotorSubsystem funnelMotorSubsystem;

  public FunnelIntake(FunnelMotorSubsystem funnelMotorSubsystem) {
    this.funnelMotorSubsystem = funnelMotorSubsystem;
   
    addRequirements(funnelMotorSubsystem);

  
    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    System.out.println("Funnel intake command");
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
      funnelMotorSubsystem.spin(-1);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    funnelMotorSubsystem.spin(0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}