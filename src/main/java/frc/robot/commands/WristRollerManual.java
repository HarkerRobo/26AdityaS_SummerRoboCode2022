package frc.robot.commands;

import frc.robot.subsystems.Intake;
import frc.robot.subsystems.WristRoller;
import frc.robot.util.OI;
import harkerrobolib.commands.IndefiniteCommand;

public class WristRollerManual extends IndefiniteCommand{
    public WristRollerManual(){
        addRequirements(WristRoller.getInstance());
    }
    public void execute(){
        double leftTrigger = OI.getInstance().getDriver().getLeftTrigger();
        double speed;
        if (Intake.getInstance().isIntaking()){
            speed = 0.3;
        }
        else if (leftTrigger>0.5){
            speed = -0.3;
        }
        else{
            speed = 0.1;
        }
        WristRoller.getInstance().setPercentOutPut(speed);
    }
    public void end(boolean interrupted){
        WristRoller.getInstance().setPercentOutPut(0);
    }
}
