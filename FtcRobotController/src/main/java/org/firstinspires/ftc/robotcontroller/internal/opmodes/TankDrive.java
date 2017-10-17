package org.firstinspires.ftc.robotcontroller.internal.opmodes;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.eventloop.opmode.AnnotatedOpModeManager;
import com.qualcomm.robotcore.hardware.Servo;

/**
 * Created by Administrator on 9/25/2016.
 */

//@TeleOp(name="TankDrive", group="Opmode")

public class TankDrive extends OpMode {

    DcMotor leftMotor;
    DcMotor rightMotor;
    Servo servo;
    boolean btnPressed;
    boolean previous = false;

    @Override
    public void init() {
        rightMotor = hardwareMap.dcMotor.get("leftMotor");
        leftMotor = hardwareMap.dcMotor.get("rightMotor");
        servo = hardwareMap.servo.get("servo");

        leftMotor.setDirection(DcMotor.Direction.REVERSE);
    }
        @Override
        public void loop() {
        float rightY = -gamepad1.left_stick_y;
        float leftY = -gamepad1.right_stick_y;

        boolean servoPos = gamepad2.a;

        if(servoPos && !previous){
            if(btnPressed){
                btnPressed = false;
            }else {
                btnPressed = true;
            }
        }
        if(btnPressed){
            servo.setPosition(1.0);
        } else{
            servo.setPosition(0.0);
        }
        telemetry.addData("VALUE: ", btnPressed);
        //leftY = (leftY == 0) ? -gamepad1.left_stick_y : leftY;
        //rightY = (rightY == 0) ? -gamepad1.right_stick_y : rightY;

        telemetry.addData("left joystick value", leftY);
        telemetry.addData("right joystick value", rightY);

        leftMotor.setPower(leftY);
        rightMotor.setPower(rightY);
        previous = gamepad2.a;
    }
}