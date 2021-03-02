package android.support.v4.graphics;

import android.graphics.Color;

public final class b {
    private static final ThreadLocal<double[]> JQ = new ThreadLocal<>();

    public static int v(int i2, int i3) {
        int alpha = Color.alpha(i3);
        int alpha2 = Color.alpha(i2);
        int i4 = 255 - (((255 - alpha) * (255 - alpha2)) / 255);
        return Color.argb(i4, c(Color.red(i2), alpha2, Color.red(i3), alpha, i4), c(Color.green(i2), alpha2, Color.green(i3), alpha, i4), c(Color.blue(i2), alpha2, Color.blue(i3), alpha, i4));
    }

    private static int c(int i2, int i3, int i4, int i5, int i6) {
        if (i6 == 0) {
            return 0;
        }
        return (((i2 * 255) * i3) + ((i4 * i5) * (255 - i3))) / (i6 * 255);
    }

    private static double w(int i2, int i3) {
        if (Color.alpha(i3) != 255) {
            throw new IllegalArgumentException("background can not be translucent: #" + Integer.toHexString(i3));
        }
        if (Color.alpha(i2) < 255) {
            i2 = v(i2, i3);
        }
        double aw = aw(i2) + 0.05d;
        double aw2 = aw(i3) + 0.05d;
        return Math.max(aw, aw2) / Math.min(aw, aw2);
    }

    public static int d(int i2, int i3, float f2) {
        int i4 = 255;
        if (Color.alpha(i3) != 255) {
            throw new IllegalArgumentException("background can not be translucent: #" + Integer.toHexString(i3));
        } else if (w(x(i2, 255), i3) < ((double) f2)) {
            return -1;
        } else {
            int i5 = 0;
            for (int i6 = 0; i6 <= 10 && i4 - i5 > 1; i6++) {
                int i7 = (i5 + i4) / 2;
                if (w(x(i2, i7), i3) < ((double) f2)) {
                    i5 = i7;
                } else {
                    i4 = i7;
                }
            }
            return i4;
        }
    }

    public static void a(int i2, int i3, int i4, float[] fArr) {
        float f2;
        float abs;
        float f3 = ((float) i2) / 255.0f;
        float f4 = ((float) i3) / 255.0f;
        float f5 = ((float) i4) / 255.0f;
        float max = Math.max(f3, Math.max(f4, f5));
        float min = Math.min(f3, Math.min(f4, f5));
        float f6 = max - min;
        float f7 = (max + min) / 2.0f;
        if (max == min) {
            abs = 0.0f;
            f2 = 0.0f;
        } else {
            if (max == f3) {
                f2 = ((f4 - f5) / f6) % 6.0f;
            } else if (max == f4) {
                f2 = ((f5 - f3) / f6) + 2.0f;
            } else {
                f2 = ((f3 - f4) / f6) + 4.0f;
            }
            abs = f6 / (1.0f - Math.abs((2.0f * f7) - 1.0f));
        }
        float f8 = (f2 * 60.0f) % 360.0f;
        if (f8 < 0.0f) {
            f8 += 360.0f;
        }
        fArr[0] = i(f8, 360.0f);
        fArr[1] = i(abs, 1.0f);
        fArr[2] = i(f7, 1.0f);
    }

    public static void d(int i2, float[] fArr) {
        a(Color.red(i2), Color.green(i2), Color.blue(i2), fArr);
    }

    public static int c(float[] fArr) {
        int round;
        int round2;
        int i2;
        float f2 = fArr[0];
        float f3 = fArr[1];
        float f4 = fArr[2];
        float abs = f3 * (1.0f - Math.abs((2.0f * f4) - 1.0f));
        float f5 = f4 - (0.5f * abs);
        float abs2 = abs * (1.0f - Math.abs(((f2 / 60.0f) % 2.0f) - 1.0f));
        switch (((int) f2) / 60) {
            case 0:
                round = Math.round((abs + f5) * 255.0f);
                int round3 = Math.round((abs2 + f5) * 255.0f);
                round2 = Math.round(255.0f * f5);
                i2 = round3;
                break;
            case 1:
                round = Math.round((abs2 + f5) * 255.0f);
                int round4 = Math.round((abs + f5) * 255.0f);
                round2 = Math.round(255.0f * f5);
                i2 = round4;
                break;
            case 2:
                round = Math.round(255.0f * f5);
                int round5 = Math.round((abs + f5) * 255.0f);
                round2 = Math.round((abs2 + f5) * 255.0f);
                i2 = round5;
                break;
            case 3:
                round = Math.round(255.0f * f5);
                int round6 = Math.round((abs2 + f5) * 255.0f);
                round2 = Math.round((abs + f5) * 255.0f);
                i2 = round6;
                break;
            case 4:
                round = Math.round((abs2 + f5) * 255.0f);
                int round7 = Math.round(255.0f * f5);
                round2 = Math.round((abs + f5) * 255.0f);
                i2 = round7;
                break;
            case 5:
            case 6:
                round = Math.round((abs + f5) * 255.0f);
                int round8 = Math.round(255.0f * f5);
                round2 = Math.round((abs2 + f5) * 255.0f);
                i2 = round8;
                break;
            default:
                round2 = 0;
                i2 = 0;
                round = 0;
                break;
        }
        return Color.rgb(ax(round), ax(i2), ax(round2));
    }

    public static int x(int i2, int i3) {
        if (i3 >= 0 && i3 <= 255) {
            return (16777215 & i2) | (i3 << 24);
        }
        throw new IllegalArgumentException("alpha must be between 0 and 255.");
    }

    private static float i(float f2, float f3) {
        if (f2 < 0.0f) {
            return 0.0f;
        }
        return f2 <= f3 ? f2 : f3;
    }

    private static int ax(int i2) {
        if (i2 < 0) {
            return 0;
        }
        if (i2 > 255) {
            return 255;
        }
        return i2;
    }

    private static double aw(int i2) {
        double[] dArr = JQ.get();
        if (dArr == null) {
            dArr = new double[3];
            JQ.set(dArr);
        }
        int red = Color.red(i2);
        int green = Color.green(i2);
        int blue = Color.blue(i2);
        if (dArr.length != 3) {
            throw new IllegalArgumentException("outXyz must have a length of 3.");
        }
        double d2 = ((double) red) / 255.0d;
        double pow = d2 < 0.04045d ? d2 / 12.92d : Math.pow((d2 + 0.055d) / 1.055d, 2.4d);
        double d3 = ((double) green) / 255.0d;
        double pow2 = d3 < 0.04045d ? d3 / 12.92d : Math.pow((d3 + 0.055d) / 1.055d, 2.4d);
        double d4 = ((double) blue) / 255.0d;
        double pow3 = d4 < 0.04045d ? d4 / 12.92d : Math.pow((d4 + 0.055d) / 1.055d, 2.4d);
        dArr[0] = 100.0d * ((0.4124d * pow) + (0.3576d * pow2) + (0.1805d * pow3));
        dArr[1] = 100.0d * ((0.2126d * pow) + (0.7152d * pow2) + (0.0722d * pow3));
        dArr[2] = ((pow3 * 0.9505d) + (pow2 * 0.1192d) + (pow * 0.0193d)) * 100.0d;
        return dArr[1] / 100.0d;
    }
}
