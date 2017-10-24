package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

/**
 * Created by Administrator on 9/25/2016.
 */
@TeleOp(name="TankDriveTeamCode", group="Opmode")

public class TankDrive extends OpMode {

    DcMotor leftMotor,rightMotor, liftMotor,grabberMotor;
    boolean leftBumper,rightBumper =  false;

    @Override
    public void init() {
        leftMotor = hardwareMap.dcMotor.get("left_drive");
        rightMotor = hardwareMap.dcMotor.get("right_drive");
        liftMotor = hardwareMap.dcMotor.get("lift");
        grabberMotor = hardwareMap.dcMotor.get("grabber");


        rightMotor.setDirection(DcMotor.Direction.REVERSE);
    }

    @Override
    public void loop() {
        float leftY = gamepad1.left_stick_y;
        float rightY = gamepad1.right_stick_y;
//        leftY = (leftY == 0) ? -gamepad2.left_stick_y : leftY;
//        rightY = (rightY == 0) ? -gamepad2.right_stick_y : rightY;

        telemetry.addData("left joystick value", leftY);
        telemetry.addData("right joystick value", rightY);
        leftBumper = gamepad2.left_bumper;
        rightBumper = gamepad2.right_bumper;

        leftMotor.setPower(leftY);
        rightMotor.setPower(rightY);


        if(leftBumper){
            telemetry.addData("left bumper", leftBumper);
            liftMotor.setPower(0.5);
        }
        if(rightBumper){
            telemetry.addData("right bumper", rightBumper);
        }
    }
}