package android.support.design.widget;

public final class k {
    private static float b(float f2, float f3, float f4, float f5) {
        return (float) Math.hypot((double) (f4 - f2), (double) (f5 - f3));
    }

    public static float lerp(float f2, float f3, float f4) {
        return ((1.0f - f4) * f2) + (f4 * f3);
    }

    public static boolean e(float f2, float f3) {
        return 1.0E-4f + f2 >= f3;
    }

    public static float c(float f2, float f3, float f4, float f5) {
        return d(b(f2, f3, 0.0f, 0.0f), b(f2, f3, f4, 0.0f), b(f2, f3, f4, f5), b(f2, f3, 0.0f, f5));
    }

    private static float d(float f2, float f3, float f4, float f5) {
        if (f2 > f3 && f2 > f4 && f2 > f5) {
            return f2;
        }
        if (f3 <= f4 || f3 <= f5) {
            return f4 > f5 ? f4 : f5;
        }
        return f3;
    }
}
