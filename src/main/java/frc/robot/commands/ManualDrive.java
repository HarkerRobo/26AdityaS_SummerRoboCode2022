package frc.robot.commands;

import frc.robot.subsystems.Drivetrain;
import frc.robot.util.OI;
import harkerrobolib.commands.IndefiniteCommand;

public class ManualDrive extends IndefiniteCommand {
    public ManualDrive(){
        addRequirements(Drivetrain.getInstance());
    }

    public void execute(){
        double speed = OI.getInstance().getDriver().getLeftY();
        double turn = OI.getInstance().getDriver().getLeftX();
        Drivetrain.getInstance().setArcadeDrive(speed, turn);
    }
    public void end (boolean interrupted){
        Drivetrain.getInstance().setArcadeDrive(0, 0);
    }
}
