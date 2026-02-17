package org.firstinspires.ftc.teamcode.pedroPathing;

import com.pedropathing.follower.Follower;
import com.pedropathing.follower.FollowerConstants;
import com.pedropathing.ftc.FollowerBuilder;
import com.pedropathing.ftc.drivetrains.MecanumConstants;
import com.pedropathing.ftc.localization.constants.PinpointConstants;
import com.pedropathing.paths.PathConstraints;
import com.qualcomm.hardware.gobilda.GoBildaPinpointDriver;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.navigation.DistanceUnit;

public class Constants {

    // XAVIER NOTE:  While tuning for Autonomous, the Pedro Pathing documentation will tell you to copy and paste over a "MecanumConstants" declaration statement.
    //   We already did that below, so just add on to it or modify it as necessary. You will still need to copy and paste certain things over, though,
    //   such as a localizerConstants declaration statement

    final static double lbPerKg = 2.205;
    final static double robotWeightInPounds = 15; // TODO: Update with your robot's actual weight
    public static FollowerConstants followerConstants = new FollowerConstants()
            .mass(robotWeightInPounds /lbPerKg)
            .forwardZeroPowerAcceleration(-48.49840723897402)
            .lateralZeroPowerAcceleration(-82.27317786437277);

    public static MecanumConstants driveConstants = new MecanumConstants()
            .maxPower(1)
            .rightFrontMotorName("rightFront") // TODO: Set these names to the drive motor names used in your configuration file
            .rightRearMotorName("rightBack")
            .leftRearMotorName("leftBack")
            .leftFrontMotorName("leftFront")
            .leftFrontMotorDirection(DcMotorSimple.Direction.REVERSE) // TODO: Set these directions based on your robot's drive motors
            .leftRearMotorDirection(DcMotorSimple.Direction.REVERSE)
            .rightFrontMotorDirection(DcMotorSimple.Direction.FORWARD)
            .rightRearMotorDirection(DcMotorSimple.Direction.FORWARD)
            .xVelocity(85.70870659295029)
            .yVelocity(68.19706762118604);


    public static PinpointConstants localizerConstants = new PinpointConstants()
            .forwardPodY(-2.25)
            .strafePodX(-4.5)
            .distanceUnit(DistanceUnit.INCH)
            .hardwareMapName("pinpoint")
            .encoderResolution(GoBildaPinpointDriver.GoBildaOdometryPods.goBILDA_SWINGARM_POD)
            .forwardEncoderDirection(GoBildaPinpointDriver.EncoderDirection.REVERSED)
            .strafeEncoderDirection(GoBildaPinpointDriver.EncoderDirection.FORWARD);

    public static PathConstraints pathConstraints = new PathConstraints(
            0.99,
            100,
            1,
            1);

    public static Follower createFollower(HardwareMap hardwareMap) {
        return new FollowerBuilder(followerConstants, hardwareMap)
                .pinpointLocalizer(localizerConstants)
                .pathConstraints(pathConstraints)
                .mecanumDrivetrain(driveConstants)
                .build();
    }
}