package io.github.kleongf.cubelib.mathutil;

public class MathUtil {
    public static double nCr(int n, int r) {
        double num = (double)1.0F;
        double denom = (double)1.0F;

        for(int i = n; i > n - r; --i) {
            num *= (double)i;
        }

        for(int i = 1; i <= r; ++i) {
            denom *= (double)i;
        }

        return num / denom;
    }

    public static double clamp(double num, double lower, double upper) {
        if (num < lower) {
            return lower;
        } else {
            return Math.min(num, upper);
        }
    }
    // normalizes an angle between 0 and 2pi
    public static double normalizeAnglePositive(double radians) {
        double angle = radians % (Math.PI * 2D);
        return angle < (double)0.0F ? angle + (Math.PI * 2D) : angle;
    }
    // normalizes an angle between -pi and pi
    public static double normalizeAngleSymmetric(double radians) {
        while (radians > Math.PI) {
            radians -= 2 * Math.PI;
        }
        while (radians < -Math.PI) {
            radians += 2 * Math.PI;
        }
        return radians;
    }

    public static double inToMM(double in) {
        return in * 25.4;
    }
    public static double inToM(double in) {
        return inToMM(in) / 1000d;
    }

    public static double mmToIn(double mm) {
        return mm / 25.4;
    }
}
