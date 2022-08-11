package frc.robot.commands;

import frc.robot.subsystems.Wrist;
import frc.robot.util.OI;
import harkerrobolib.commands.IndefiniteCommand;

public class WristManual extends IndefiniteCommand{
    public WristManual(){
        addRequirements(Wrist.getInstance());
    }
    public void execute(){
        double speed;
        boolean upDPad = OI.getInstance().getDriver().getUpDPadButton().get();
        boolean downDPad = OI.getInstance().getDriver().getDownDPadButton().get();
        if (upDPad){
            speed = 0.7;
        }
        else if (downDPad){
            speed = -0.7;
        }
        else{
            speed = 0.2;
        }
        Wrist.getInstance().setPercentOutPut(speed);
    }
    public void end(boolean interrupted){
        Wrist.getInstance().setPercentOutPut(0);
    }
}
