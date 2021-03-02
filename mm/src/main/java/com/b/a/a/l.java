package com.b.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Arrays;

/* access modifiers changed from: package-private */
public final class l {
    float cjo;
    long cjs;
    private final float[] cjt = new float[3];
    private int cju;
    private long cjv;
    long cjw;

    l() {
        AppMethodBeat.i(87949);
        AppMethodBeat.o(87949);
    }

    /* access modifiers changed from: package-private */
    public final void a(float f2, int i2, long j2) {
        AppMethodBeat.i(87950);
        long j3 = j2 - this.cjv;
        if (j3 > this.cjs) {
            Arrays.fill(this.cjt, 0.0f);
            this.cju = 0;
            this.cjv = 0;
            this.cjw = 0;
            this.cjo = 0.0f;
        } else {
            this.cjw = j3 + this.cjw;
        }
        this.cjt[0] = this.cjt[1];
        this.cjt[1] = this.cjt[2];
        this.cjt[2] = f2;
        if (this.cjt[2] != 0.0f) {
            this.cjo = ((((float) i2) / ((this.cjt[0] != 0.0f ? ((this.cjt[0] + this.cjt[1]) + this.cjt[2]) / 3.0f : this.cjt[1] != 0.0f ? (this.cjt[1] + this.cjt[2]) / 2.0f : this.cjt[2]) + (this.cjt[2] * 3.0f))) * y.cnq) + ((y.cnr * ((float) (i2 - this.cju))) / ((float) ((this.cju + i2) + 1)));
        }
        this.cju = i2;
        this.cjv = j2;
        AppMethodBeat.o(87950);
    }
}
