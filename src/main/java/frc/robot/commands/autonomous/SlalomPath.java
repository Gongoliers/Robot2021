package frc.robot.commands.autonomous;

import com.thegongoliers.commands.FollowPathCommand;
import com.thegongoliers.paths.SimplePath;

import edu.wpi.first.wpilibj.command.CommandGroup;
import frc.robot.Robot;
import frc.robot.commands.drivetrain.DriveDistance;
import frc.robot.commands.powercell.ShootPowerCellLow;

/**
 * Drives straight forwards to the low goal of the POWER PORT
 * and delivers the three preloaded POWER CELLs.
 */
 

public class SlalomPath extends CommandGroup {

    public SlalomPath() {
        SimplePath path = new SimplePath();
        path.addRotation(-43);
        path.addStraightAway(7.33);
        path.addRotation(47);
        path.addStraightAway(10);
        path.addRotation(47);
        path.addStraightAway(7.33);
        path.addRotation(-78);
        path.addStraightAway(5.58);
        path.addRotation(-93);
        path.addStraightAway(4.54);
        path.addRotation(-90);
        path.addStraightAway(6.5);
        path.addRotation(63);
        path.addStraightAway(12);
        path.addRotation(37);
        path.addStraightAway(10.19);
        

        addSequential(
        new FollowPathCommand(Robot.drivetrain, Robot.drivetrain.getModularDrivetrain(), path)
        // Fire
    );

    }
}
