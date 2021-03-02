package com.tencent.mm.cm.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class l {
    public static final float[] Rft = {0.0f, 1.0f, 1.0f, 1.0f, 0.0f, 0.0f, 1.0f, 0.0f};
    public static final float[] RgD = {1.0f, 1.0f, 1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f};
    public static final float[] RgE = {1.0f, 0.0f, 0.0f, 0.0f, 1.0f, 1.0f, 0.0f, 1.0f};
    public static final float[] RgF = {0.0f, 0.0f, 0.0f, 1.0f, 1.0f, 0.0f, 1.0f, 1.0f};

    public static float[] a(j jVar, boolean z) {
        float[] fArr;
        AppMethodBeat.i(190284);
        switch (jVar) {
            case ROTATION_90:
                fArr = RgD;
                break;
            case ROTATION_180:
                fArr = RgE;
                break;
            case ROTATION_270:
                fArr = RgF;
                break;
            default:
                fArr = Rft;
                break;
        }
        float[] fArr2 = z ? new float[]{fArr[0], cJ(fArr[1]), fArr[2], cJ(fArr[3]), fArr[4], cJ(fArr[5]), fArr[6], cJ(fArr[7])} : fArr;
        AppMethodBeat.o(190284);
        return fArr2;
    }

    private static float cJ(float f2) {
        if (f2 == 0.0f) {
            return 1.0f;
        }
        return 0.0f;
    }
}
