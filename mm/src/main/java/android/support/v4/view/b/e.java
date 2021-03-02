package android.support.v4.view.b;

import android.graphics.Path;
import android.graphics.PathMeasure;
import android.view.animation.Interpolator;

public final class e implements Interpolator {
    private final float[] xi;
    private final float[] xj;

    e(Path path) {
        PathMeasure pathMeasure = new PathMeasure(path, false);
        float length = pathMeasure.getLength();
        int i2 = ((int) (length / 0.002f)) + 1;
        this.xi = new float[i2];
        this.xj = new float[i2];
        float[] fArr = new float[2];
        for (int i3 = 0; i3 < i2; i3++) {
            pathMeasure.getPosTan((((float) i3) * length) / ((float) (i2 - 1)), fArr, null);
            this.xi[i3] = fArr[0];
            this.xj[i3] = fArr[1];
        }
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public e() {
        /*
            r7 = this;
            r4 = 1065353216(0x3f800000, float:1.0)
            r1 = 0
            android.graphics.Path r0 = new android.graphics.Path
            r0.<init>()
            r0.moveTo(r1, r1)
            r2 = 1056964608(0x3f000000, float:0.5)
            r3 = 1045220557(0x3e4ccccd, float:0.2)
            r5 = r4
            r6 = r4
            r0.cubicTo(r1, r2, r3, r4, r5, r6)
            r7.<init>(r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v4.view.b.e.<init>():void");
    }

    public final float getInterpolation(float f2) {
        if (f2 <= 0.0f) {
            return 0.0f;
        }
        if (f2 >= 1.0f) {
            return 1.0f;
        }
        int length = this.xi.length - 1;
        int i2 = 0;
        while (length - i2 > 1) {
            int i3 = (i2 + length) / 2;
            if (f2 < this.xi[i3]) {
                length = i3;
            } else {
                i2 = i3;
            }
        }
        float f3 = this.xi[length] - this.xi[i2];
        if (f3 == 0.0f) {
            return this.xj[i2];
        }
        float f4 = (f2 - this.xi[i2]) / f3;
        float f5 = this.xj[i2];
        return (f4 * (this.xj[length] - f5)) + f5;
    }
}
