package frc.robot;


import edu.wpi.first.math.trajectory.TrapezoidProfile;

public final class Constants {
    public static final class Elevator{
        
    
        //elevator motors 
        public static final int spoolMotorLeftPort = 2; // robot's left (intake motor side)
        public static final int spoolMotorRightPort = 27;
     
    }
    //shooter motors
    public static final double stickDeadband = 0.1;
    public static final String ROLL_SPEED = null;
     public static final int FrontLeftPort = 19;
     public static final int FrontRightPort = 8; 
     public static final int RearLeftPort = 58;
     public static final int RearRightPort = 9;

     
     //funnel motor
    public static class Funnel {
        public static final int spinMotorLeftPort = 35; 
         
      }
     //angle motors
    public static class Angle {
        public static final int angleMotorLeftPort = 45; 
        public static final int angleMotorRightPort = 57; 
      }
      //swerve things
    public static final class Swerve {
        
    }


    

    public static final class AutoConstants {
        public static final double kMaxSpeedMetersPerSecond = 3;
        public static final double kMaxAccelerationMetersPerSecondSquared = 3;
        public static final double kMaxAngularSpeedRadiansPerSecond = Math.PI;
        public static final double kMaxAngularSpeedRadiansPerSecondSquared = Math.PI;
    
        public static final double kPXController = 1;
        public static final double kPYController = 1;
        public static final double kPThetaController = 1;
    
        // Constraint for the motion profilied robot angle controller
        public static final TrapezoidProfile.Constraints kThetaControllerConstraints =
            new TrapezoidProfile.Constraints(
                kMaxAngularSpeedRadiansPerSecond, kMaxAngularSpeedRadiansPerSecondSquared);
    }
}

