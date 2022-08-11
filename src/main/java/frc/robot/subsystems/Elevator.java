package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import harkerrobolib.wrappers.HSTalon;

public class Elevator extends SubsystemBase{
    private static Elevator instance;

    private static final int M_MOTOR_ID = 0;
    private static final int F1_MOTOR_ID = 1;
    private static final int F2_MOTOR_ID = 2;
    private static final int F3_MOTOR_ID = 3;

    private HSTalon master;
    private HSTalon follower1;
    private VictorSPX follower2;
    private VictorSPX follower3;

    private static final boolean masterInvert = false;
    private static final boolean f1Invert = false;
    private static final boolean f2Invert = false;
    private static final boolean f3Invert = false;

    private Elevator(){
        master = new HSTalon(M_MOTOR_ID);
        follower1 = new HSTalon(F1_MOTOR_ID);
        follower2 = new VictorSPX(F2_MOTOR_ID);
        follower3 = new VictorSPX(F3_MOTOR_ID);
        follower1.follow(master);
        follower2.follow(master);
        follower3.follow(master);
        master.setInverted(masterInvert);
        follower1.setInverted(f1Invert);
        follower2.setInverted(f2Invert);
        follower3.setInverted(f3Invert);
    }

    public void setPercentOutPut(double output){
        master.set(ControlMode.PercentOutput, output);
    }
    
    public static Elevator getInstance(){
        if (instance == null){
            instance = new Elevator();
        }
        return instance;
    }
}
