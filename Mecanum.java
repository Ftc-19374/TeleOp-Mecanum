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
            if(abs(x) > abs(y) && abs(x) > abs(x2)){
                frontLeft.setPower(Range.clip(x, -1.0, 1.0));
                frontRight.setPower(Range.clip(-x, -1.0, 1.0));
                backLeft.setPower(Range.clip(x, -1.0, 1.0));
                backRight.setPower(Range.clip(x, -1.0, 1.0));
            } else if(abs(y) > abs(x) && abs(y) > abs(x2)){
                frontLeft.setPower(Range.clip(-y, -1.0, 1.0));
                frontRight.setPower(Range.clip(-y, -1.0, 1.0));
                backLeft.setPower(Range.clip(y, -1.0, 1.0));
                backRight.setPower(Range.clip(-y, -1.0, 1.0));
            } else if(abs(x2) > abs(x) && abs(x2) > abs(y)){
                frontLeft.setPower(Range.clip(-x2, -1.0, 1.0));
                frontRight.setPower(Range.clip(x2, -1.0, 1.0));
                backLeft.setPower(Range.clip(x2, -1.0, 1.0));
                backRight.setPower(Range.clip(x2, -1.0, 1.0));
            }
            frontLeft.setPower(0);
            frontRight.setPower(0);
            backLeft.setPower(0);
            backRight.setPower(0);
        }
    }


}
