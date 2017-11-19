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
    boolean startGrabber = false;
    boolean grabber = false;
//    TouchSensor touch;


    @Override
    public void init() {
        leftMotor = hardwareMap.dcMotor.get("left_drive");
        rightMotor = hardwareMap.dcMotor.get("right_drive");
        liftMotor = hardwareMap.dcMotor.get("lift");
        grabberMotor = hardwareMap.dcMotor.get("grabber");
//        touch = hardwareMap.touchSensor.get("touch");
        grabber = gamepad2.a;

        rightMotor.setDirection(DcMotor.Direction.REVERSE);
    }

    @Override
    public void loop() {
        float leftY = -gamepad1.left_stick_y;
        float rightY = gamepad1.right_stick_y;
//        telemetry.addData("touch", touch);
        float clawStick = gamepad2.left_stick_y;



        float rightTrigger = gamepad2.right_trigger;
        float leftTrigger = gamepad2.left_trigger;
        float rightStick = gamepad2.right_stick_x;
        float leftStick = gamepad2.left_stick_x; //using this makes it weird controls
        boolean leftBumper = gamepad2.left_bumper;
        boolean rightBumper = gamepad2.right_bumper;


//        leftY = (leftY == 0) ? -gamepad2.left_stick_y : leftY;
//        rightY = (rightY == 0) ? -gamepad2.right_stick_y : rightY;

        telemetry.addData("left joystick value gamepad1", leftY);
        telemetry.addData("right joystick value gamepad1", rightY);
        telemetry.addData("right joystick value gamepad2", rightStick);
        //leftBumper = gamepad2.left_bumper;
        //rightBumper = gamepad2.right_bumper;

        leftMotor.setPower(leftY);
        rightMotor.setPower(-rightY);

        grabberMotor.setPower(clawStick);

        if(leftBumper){
            telemetry.addData("left bumper", leftBumper);
            closeGrabber();
        } else if(rightBumper) {
            telemetry.addData("right bumper", rightBumper);
            openGrabber();
        }


        if(rightTrigger > 0.0) {
            liftMotor.setPower(-rightTrigger);

        }else if(leftTrigger > 0.0) {
            liftMotor.setPower(leftTrigger);
        } else {
            liftMotor.setPower(0.0);
        }

        if(rightStick != 0.0) {
            grabberMotor.setPower(rightStick);
        } else {
            grabberMotor.setPower(0.0);
        }

//        if(rightBumper) {
//            grabberMotor.setPower(0.1);
//        }else if(leftBumper){
//            grabberMotor.setPower(-0.1);
//        }else {
//            grabberMotor.setPower(0.0);
//        }

    }
    public void closeGrabber() {
        grabberMotor.setPower(0.5);
        sleep(500);
    }

    public void openGrabber() {
        grabberMotor.setPower(-0.5);
        sleep(500);
    }

    public final void sleep(long milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

}