package com.tencent.mm.ui.tools;

import java.lang.reflect.Array;

public final class n {
    public static float[] a(float[][] fArr, float[] fArr2) {
        float[] fArr3 = new float[3];
        for (int i2 = 0; i2 < 3; i2++) {
            float f2 = 0.0f;
            for (int i3 = 0; i3 < 3; i3++) {
                f2 += fArr[i2][i3] * fArr2[i3];
            }
            fArr3[i2] = f2;
        }
        return fArr3;
    }

    public static float[][] c(float[][] fArr) {
        float[][] fArr2 = (float[][]) Array.newInstance(Float.TYPE, 3, 3);
        for (int i2 = 0; i2 < 3; i2++) {
            for (int i3 = 0; i3 < 3; i3++) {
                fArr2[i2][i3] = i2 == i3 ? 1.0f : 0.0f;
            }
        }
        for (int i4 = 0; i4 < 3; i4++) {
            float f2 = fArr[i4][i4];
            if (f2 == 0.0f) {
                int i5 = i4 + 1;
                while (true) {
                    if (i5 >= 3) {
                        break;
                    } else if (fArr[i5][i4] != 0.0f) {
                        for (int i6 = 0; i6 < 3; i6++) {
                            float f3 = fArr[i5][i6];
                            fArr[i5][i6] = fArr[i4][i6];
                            fArr[i4][i6] = f3;
                            float f4 = fArr2[i5][i6];
                            fArr2[i5][i6] = fArr2[i4][i6];
                            fArr2[i4][i6] = f4;
                        }
                    } else {
                        i5++;
                    }
                }
                f2 = fArr[i4][i4];
            }
            for (int i7 = 0; i7 < 3; i7++) {
                fArr[i4][i7] = fArr[i4][i7] / f2;
                fArr2[i4][i7] = fArr2[i4][i7] / f2;
            }
            for (int i8 = 0; i8 < 3; i8++) {
                if (i8 != i4) {
                    float f5 = fArr[i8][i4];
                    for (int i9 = 0; i9 < 3; i9++) {
                        fArr[i8][i9] = fArr[i8][i9] - (fArr[i4][i9] * f5);
                        fArr2[i8][i9] = fArr2[i8][i9] - (fArr2[i4][i9] * f5);
                    }
                }
            }
        }
        return fArr2;
    }
}
