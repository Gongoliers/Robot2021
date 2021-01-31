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

public class GalacticSearchPath extends CommandGroup {

    public GalacticSearchPath(boolean red) {
        SimplePath path = new SimplePath();
        path.addStraightAway(10);
        path.addRotation(45);
        path.addStraightAway(5);

        addSequential(
        new FollowPathCommand(Robot.drivetrain, Robot.drivetrain.getModularDrivetrain(), path)
        // Fire
    );

    }
}
