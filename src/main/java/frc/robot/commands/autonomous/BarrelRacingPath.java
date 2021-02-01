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

public class BarrelRacingPath extends CommandGroup {
    public BarrelRacingPath() {
        SimplePath path = new SimplePath();
        path.addRotation(12);
        path.addStraightAway(7);
        path.addRotation(38);
        path.addStraightAway(2);
        path.addRotation(90);
        path.addStraightAway(2.5);
        path.addRotation(80);
        path.addStraightAway(13);
        path.addRotation(45);
        path.addStraightAway(3);
        path.addRotation(135);
        path.addStraightAway(6);
        path.addRotation(120);
        path.addStraightAway(3);
        path.addRotation(90);
        path.addStraightAway(20);

        addSequential(
        new FollowPathCommand(Robot.drivetrain, Robot.drivetrain.getModularDrivetrain(), path)
        // Fire
    );

    }
}
