package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.robotcontroller.external.samples.HardwarePushbot;


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
HardwarePushbot robot   = new HardwarePushbot();   // Use a Pushbot's hardware
    private ElapsedTime runtime = new ElapsedTime();

    static final double     COUNTS_PER_MOTOR_REV    = 1440 ;    // eg: TETRIX Motor Encoder
    static final double     DRIVE_GEAR_REDUCTION    = 2.0 ;     // This is < 1.0 if geared UP
    static final double     WHEEL_DIAMETER_INCHES   = 4.0 ;     // For figuring circumference
    static final double     COUNTS_PER_INCH         = (COUNTS_PER_MOTOR_REV * DRIVE_GEAR_REDUCTION) /
            (WHEEL_DIAMETER_INCHES * 3.1415);
    static final double     DRIVE_SPEED             = 0.6;
    static final double     TURN_SPEED              = 0.5;


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

//        encoderDrive(DRIVE_SPEED,  34,  -34, 3.0);  // S1: Forward 34 Inches with 3 Sec timeout
//        encoderDrive(TURN_SPEED,   12, 12, 4.0);  // S2: Turn Right 12 Inches with 4 Sec timeout
//        encoderDrive(DRIVE_SPEED, 6, -6, 4.0);  // S3: Forward 6 Inches with 4 Sec timeout
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

    /*
  *  Method to perfmorm a relative move, based on encoder counts.
  *  Encoders are not reset as the move is based on the current position.
  *  Move will stop if any of three conditions occur:
  *  1) Move gets to the desired position
  *  2) Move runs out of time
  *  3) Driver stops the opmode running.
  */

    public void encoderDrive(double speed,
                             double leftInches, double rightInches,
                             double timeoutS) {
        int newLeftTarget;
        int newRightTarget;

        // Determine new target position, and pass to motor controller
        newLeftTarget = leftMotor.getCurrentPosition() + (int)(leftInches * COUNTS_PER_INCH);
        newRightTarget = leftMotor.getCurrentPosition() + (int)(rightInches * COUNTS_PER_INCH);
        leftMotor.setTargetPosition(newLeftTarget);
        rightMotor.setTargetPosition(newRightTarget);

        // Turn On RUN_TO_POSITION
        leftMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        rightMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        // reset the timeout time and start motion.
//            runtime.reset();
        leftMotor.setPower(speed);
        rightMotor.setPower(speed);

        // keep looping while we are still active, and there is time left, and both motors are running.
        // Note: We use (isBusy() && isBusy()) in the loop test, which means that when EITHER motor hits
        // its target position, the motion will stop.  This is "safer" in the event that the robot will
        // always end the motion as soon as possible.
        // However, if you require that BOTH motors have finished their moves before the robot continues
        // onto the next step, use (isBusy() || isBusy()) in the loop test.

            // Display it for the driver.
            telemetry.addData("Path1",  "Running to %7d :%7d", newLeftTarget,  newRightTarget);
            telemetry.addData("Path2",  "Running at %7d :%7d",
                    leftMotor.getCurrentPosition(),
                    rightMotor.getCurrentPosition());
            telemetry.update();

            // Stop all motion;
            leftMotor.setPower(0);
            rightMotor.setPower(0);

            // Turn off RUN_TO_POSITION
            leftMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
            rightMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

            //  sleep(250);   // optional pause after each move
    }

}