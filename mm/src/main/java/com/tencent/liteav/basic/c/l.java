package com.tencent.liteav.basic.c;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class l {

    /* renamed from: a  reason: collision with root package name */
    public static final float[] f340a = {0.0f, 1.0f, 1.0f, 1.0f, 0.0f, 0.0f, 1.0f, 0.0f};

    /* renamed from: b  reason: collision with root package name */
    public static final float[] f341b = {1.0f, 1.0f, 1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f};

    /* renamed from: c  reason: collision with root package name */
    public static final float[] f342c = {1.0f, 0.0f, 0.0f, 0.0f, 1.0f, 1.0f, 0.0f, 1.0f};

    /* renamed from: d  reason: collision with root package name */
    public static final float[] f343d = {0.0f, 0.0f, 0.0f, 1.0f, 1.0f, 0.0f, 1.0f, 1.0f};

    /* renamed from: e  reason: collision with root package name */
    public static final float[] f344e = {-1.0f, -1.0f, 1.0f, -1.0f, -1.0f, 1.0f, 1.0f, 1.0f};

    public static float[] a(k kVar, boolean z, boolean z2) {
        float[] fArr;
        AppMethodBeat.i(222257);
        switch (kVar) {
            case ROTATION_90:
                fArr = (float[]) f341b.clone();
                break;
            case ROTATION_180:
                fArr = (float[]) f342c.clone();
                break;
            case ROTATION_270:
                fArr = (float[]) f343d.clone();
                break;
            default:
                fArr = (float[]) f340a.clone();
                break;
        }
        float[] fArr2 = z ? new float[]{a(fArr[0]), fArr[1], a(fArr[2]), fArr[3], a(fArr[4]), fArr[5], a(fArr[6]), fArr[7]} : fArr;
        float[] fArr3 = z2 ? new float[]{fArr2[0], a(fArr2[1]), fArr2[2], a(fArr2[3]), fArr2[4], a(fArr2[5]), fArr2[6], a(fArr2[7])} : fArr2;
        AppMethodBeat.o(222257);
        return fArr3;
    }

    private static float a(float f2) {
        if (f2 == 0.0f) {
            return 1.0f;
        }
        return 0.0f;
    }
}
