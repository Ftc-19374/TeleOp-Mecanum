package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.util.Range;
import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.I2cAddr;

@TeleOp(name="Mecanum Wheels")

public class Mecanum extends LinearOpMode {
    double x;
    double y;
    double p;
    double x2;
    // x is value of wheels, back is -x,  y+x y-x
    DcMotor frontLeft;
    DcMotor frontRight;
    DcMotor backLeft;
    DcMotor backRight;
    @Override
    public void runOpMode() throws InterruptedException{
        frontLeft = hardwareMap.dcMotor.get("frontLeft");
        frontRight = hardwareMap.dcMotor.get("frontRight");
        backLeft = hardwareMap.dcMotor.get("backLeft");
        backRight = hardwareMap.dcMotor.get("backRight");
        waitForStart();
        while (opModeIsActive()){
            y = gamepad1.left_stick_y;
            x = gamepad1.left_stick_x;
            x2 = gamepad1.right_stick_x;
            p = gamepad2.left_stick_y;
            //frontLeft.setPower(Range.clip(-y - (0.5 * x), -1.0, 1.0));
            //frontRight.setPower(Range.clip(y - (0.5 * x), -1.0, 1.0));
            //backLeft.setPower(Range.clip(-y + (0.5 * x), -1.0, 1.0));
            //backRight.setPower(Range.clip(y + (0.5 * x), -1.0, 1.0));
            if(x > y){
                frontLeft.setPower(Range.clip(-x, -1.0, 1.0));
                frontRight.setPower(Range.clip(-x, -1.0, 1.0));
                backLeft.setPower(Range.clip(x, -1.0, 1.0));
                backRight.setPower(Range.clip(x, -1.0, 1.0));
            } else if(y > x){
                frontLeft.setPower(Range.clip(-y, -1.0, 1.0));
                frontRight.setPower(Range.clip(y, -1.0, 1.0));
                backLeft.setPower(Range.clip(-y, -1.0, 1.0));
                backRight.setPower(Range.clip(y, -1.0, 1.0));
            } else if(x2 > x && x2 > y){
                frontLeft.setPower(Range.clip(x2, -1.0, 1.0));
                frontRight.setPower(Range.clip(x2, -1.0, 1.0));
                backLeft.setPower(Range.clip(x2, -1.0, 1.0));
                backRight.setPower(Range.clip(x2, -1.0, 1.0));
            }
        }
    }


}
