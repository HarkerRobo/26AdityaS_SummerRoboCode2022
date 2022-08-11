package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import harkerrobolib.wrappers.HSTalon;

public class Wrist extends SubsystemBase{
    private static Wrist instance;

    private static final int MASTER_MOTOR_ID = 0;
    private static final int FOLLOWER_MOTOR_ID = 1;

    private HSTalon master;
    private VictorSPX follower;

    private static final boolean masterInvert = false;
    private static final boolean followerInvert = false;

    private Wrist(){
        master = new HSTalon(MASTER_MOTOR_ID);
        follower = new VictorSPX(FOLLOWER_MOTOR_ID);
        follower.follow(master);
        master.setInverted(masterInvert);
        follower.setInverted(followerInvert);
    }

    public void setPercentOutPut(double output){
        master.set(ControlMode.PercentOutput, output);
    }
    
    public static Wrist getInstance(){
        if (instance == null){
            instance = new Wrist();
        }
        return instance;
    }
}
