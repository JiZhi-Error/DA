package com.google.a.a;

public final class g {
    public static final String[] EMPTY_STRING_ARRAY = new String[0];
    public static final int[] bYn = new int[0];
    public static final long[] cbp = new long[0];
    public static final float[] cbq = new float[0];
    public static final double[] cbr = new double[0];
    public static final boolean[] cbs = new boolean[0];
    public static final byte[][] cbt = new byte[0][];
    public static final byte[] cbu = new byte[0];

    static int gX(int i2) {
        return i2 & 7;
    }

    public static int gY(int i2) {
        return i2 >>> 3;
    }

    static int bA(int i2, int i3) {
        return (i2 << 3) | i3;
    }

    public static boolean a(a aVar, int i2) {
        return aVar.fG(i2);
    }

    public static final int b(a aVar, int i2) {
        int i3 = 1;
        int position = aVar.getPosition();
        aVar.fG(i2);
        while (aVar.yT() == i2) {
            aVar.fG(i2);
            i3++;
        }
        aVar.gZ(position);
        return i3;
    }
}
