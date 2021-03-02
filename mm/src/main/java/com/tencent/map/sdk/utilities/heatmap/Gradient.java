package com.tencent.map.sdk.utilities.heatmap;

import android.graphics.Color;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;

public class Gradient {
    private static final int DEFAULT_COLOR_MAP_SIZE = 1000;
    public final int mColorMapSize;
    public int[] mColors;
    public float[] mStartPoints;

    /* access modifiers changed from: package-private */
    public class a {

        /* renamed from: a  reason: collision with root package name */
        final int f1305a;

        /* renamed from: b  reason: collision with root package name */
        final int f1306b;

        /* renamed from: c  reason: collision with root package name */
        final float f1307c;

        /* synthetic */ a(Gradient gradient, int i2, int i3, float f2, byte b2) {
            this(i2, i3, f2);
        }

        private a(int i2, int i3, float f2) {
            this.f1305a = i2;
            this.f1306b = i3;
            this.f1307c = f2;
        }
    }

    public Gradient(int[] iArr, float[] fArr) {
        this(iArr, fArr, 1000);
    }

    public Gradient(int[] iArr, float[] fArr, int i2) {
        AppMethodBeat.i(84369);
        if (iArr.length != fArr.length) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("colors and startPoints should be same length");
            AppMethodBeat.o(84369);
            throw illegalArgumentException;
        } else if (iArr.length == 0) {
            IllegalArgumentException illegalArgumentException2 = new IllegalArgumentException("No colors have been defined");
            AppMethodBeat.o(84369);
            throw illegalArgumentException2;
        } else {
            for (int i3 = 1; i3 < fArr.length; i3++) {
                if (fArr[i3] <= fArr[i3 - 1]) {
                    IllegalArgumentException illegalArgumentException3 = new IllegalArgumentException("startPoints should be in increasing order");
                    AppMethodBeat.o(84369);
                    throw illegalArgumentException3;
                }
            }
            this.mColorMapSize = i2;
            this.mColors = new int[iArr.length];
            this.mStartPoints = new float[fArr.length];
            System.arraycopy(iArr, 0, this.mColors, 0, iArr.length);
            System.arraycopy(fArr, 0, this.mStartPoints, 0, fArr.length);
            AppMethodBeat.o(84369);
        }
    }

    private HashMap<Integer, a> generateColorIntervals() {
        AppMethodBeat.i(180750);
        HashMap<Integer, a> hashMap = new HashMap<>();
        if (this.mStartPoints[0] != 0.0f) {
            hashMap.put(0, new a(this, Color.argb(0, Color.red(this.mColors[0]), Color.green(this.mColors[0]), Color.blue(this.mColors[0])), this.mColors[0], this.mStartPoints[0] * ((float) this.mColorMapSize), (byte) 0));
        }
        for (int i2 = 1; i2 < this.mColors.length; i2++) {
            hashMap.put(Integer.valueOf((int) (((float) this.mColorMapSize) * this.mStartPoints[i2 - 1])), new a(this, this.mColors[i2 - 1], this.mColors[i2], (this.mStartPoints[i2] - this.mStartPoints[i2 - 1]) * ((float) this.mColorMapSize), (byte) 0));
        }
        if (this.mStartPoints[this.mStartPoints.length - 1] != 1.0f) {
            int length = this.mStartPoints.length - 1;
            hashMap.put(Integer.valueOf((int) (((float) this.mColorMapSize) * this.mStartPoints[length])), new a(this, this.mColors[length], this.mColors[length], ((float) this.mColorMapSize) * (1.0f - this.mStartPoints[length]), (byte) 0));
        }
        AppMethodBeat.o(180750);
        return hashMap;
    }

    public final int[] generateColorMap(double d2) {
        AppMethodBeat.i(84371);
        HashMap<Integer, a> generateColorIntervals = generateColorIntervals();
        int[] iArr = new int[this.mColorMapSize];
        int i2 = 0;
        a aVar = generateColorIntervals.get(0);
        for (int i3 = 0; i3 < this.mColorMapSize; i3++) {
            if (generateColorIntervals.containsKey(Integer.valueOf(i3))) {
                i2 = i3;
                aVar = generateColorIntervals.get(Integer.valueOf(i3));
            }
            iArr[i3] = interpolateColor(aVar.f1305a, aVar.f1306b, ((float) (i3 - i2)) / aVar.f1307c);
        }
        if (d2 != 1.0d) {
            for (int i4 = 0; i4 < this.mColorMapSize; i4++) {
                int i5 = iArr[i4];
                iArr[i4] = Color.argb((int) (((double) Color.alpha(i5)) * d2), Color.red(i5), Color.green(i5), Color.blue(i5));
            }
        }
        AppMethodBeat.o(84371);
        return iArr;
    }

    static int interpolateColor(int i2, int i3, float f2) {
        AppMethodBeat.i(180751);
        int alpha = (int) ((((float) (Color.alpha(i3) - Color.alpha(i2))) * f2) + ((float) Color.alpha(i2)));
        float[] fArr = new float[3];
        Color.RGBToHSV(Color.red(i2), Color.green(i2), Color.blue(i2), fArr);
        float[] fArr2 = new float[3];
        Color.RGBToHSV(Color.red(i3), Color.green(i3), Color.blue(i3), fArr2);
        if (fArr[0] - fArr2[0] > 180.0f) {
            fArr2[0] = fArr2[0] + 360.0f;
        } else if (fArr2[0] - fArr[0] > 180.0f) {
            fArr[0] = fArr[0] + 360.0f;
        }
        float[] fArr3 = new float[3];
        for (int i4 = 0; i4 < 3; i4++) {
            fArr3[i4] = ((fArr2[i4] - fArr[i4]) * f2) + fArr[i4];
        }
        int HSVToColor = Color.HSVToColor(alpha, fArr3);
        AppMethodBeat.o(180751);
        return HSVToColor;
    }
}
