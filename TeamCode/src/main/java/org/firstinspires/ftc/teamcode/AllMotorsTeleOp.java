package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotorEx;

@TeleOp(name = "All Motors Test", group = "TeleOp")
public class AllMotorsTeleOp extends OpMode {
    // Initialize motors 0-7
    private DcMotorEx motor0, motor1, motor2, motor3, motor4, motor5, motor6, motor7;

    @Override
    public void init() {
        // Set up motors from hardwareMap using names "motor0" through "motor7"
        motor0 = hardwareMap.get(DcMotorEx.class, "motor0");
        motor1 = hardwareMap.get(DcMotorEx.class, "motor1");
        motor2 = hardwareMap.get(DcMotorEx.class, "motor2");
        motor3 = hardwareMap.get(DcMotorEx.class, "motor3");
        motor4 = hardwareMap.get(DcMotorEx.class, "motor4");
        motor5 = hardwareMap.get(DcMotorEx.class, "motor5");
        motor6 = hardwareMap.get(DcMotorEx.class, "motor6");
        motor7 = hardwareMap.get(DcMotorEx.class, "motor7");

        // Set all motors to BRAKE mode and reset encoders
        DcMotorEx[] motors = {motor0, motor1, motor2, motor3, motor4, motor5, motor6, motor7};
        for (DcMotorEx motor : motors) {
            motor.setZeroPowerBehavior(DcMotorEx.ZeroPowerBehavior.BRAKE);
            motor.setMode(DcMotorEx.RunMode.STOP_AND_RESET_ENCODER);
            motor.setMode(DcMotorEx.RunMode.RUN_USING_ENCODER);
        }
    }

    @Override
    public void loop() {
        // Use gamepad1 left stick Y to control power (up is negative in SDK, so we negate it)
        double power = -gamepad1.left_stick_y;

        // Apply power to all motors
        motor0.setPower(power);
        motor1.setPower(power);
        motor2.setPower(power);
        motor3.setPower(power);
        motor4.setPower(power);
        motor5.setPower(power);
        motor6.setPower(power);
        motor7.setPower(power);

        // Display power and encoder values for debugging
        telemetry.addData("Motor Power", power);
        telemetry.addData("m0 pos", motor0.getCurrentPosition());
        telemetry.addData("m1 pos", motor1.getCurrentPosition());
        telemetry.addData("m2 pos", motor2.getCurrentPosition());
        telemetry.addData("m3 pos", motor3.getCurrentPosition());
        telemetry.addData("m4 pos", motor4.getCurrentPosition());
        telemetry.addData("m5 pos", motor5.getCurrentPosition());
        telemetry.addData("m6 pos", motor6.getCurrentPosition());
        telemetry.addData("m7 pos", motor7.getCurrentPosition());
        telemetry.update();
    }
}