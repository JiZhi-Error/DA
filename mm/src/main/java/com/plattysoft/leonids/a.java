package com.plattysoft.leonids;

import android.graphics.Bitmap;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import com.plattysoft.leonids.b.a;
import com.plattysoft.leonids.b.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.MAlarmHandler;
import java.util.List;

public final class a {
    float SM;
    public float dhh = 1.0f;
    public float gVp;
    public Bitmap gtH;
    public a.C0127a hBT = new a.C0127a();
    public float hFr = 0.0f;
    public float hHo = 0.0f;
    public float hHp = 0.0f;
    public float hHq = 0.0f;
    float hHr;
    float hHs;
    public long hHt;
    public long hHu;
    protected long hHv;
    int hHw;
    int hHx;
    private List<b> hHy;
    public List<ColorFilter> hMT;
    b hNs;
    public float huc;
    public int mAlpha = 255;
    Matrix mMatrix = new Matrix();
    public Paint mPaint = new Paint();
    public long mTimeToLive;

    protected a() {
        AppMethodBeat.i(261906);
        AppMethodBeat.o(261906);
    }

    public final boolean c(long j2) {
        AppMethodBeat.i(261907);
        long j3 = j2 - this.hHv;
        if (j3 > this.mTimeToLive) {
            AppMethodBeat.o(261907);
            return false;
        } else if (this.mAlpha <= 0) {
            AppMethodBeat.o(261907);
            return false;
        } else if (this.mTimeToLive == MAlarmHandler.NEXT_FIRE_INTERVAL) {
            AppMethodBeat.o(261907);
            return true;
        } else {
            float f2 = ((float) j3) / ((float) this.mTimeToLive);
            this.gVp = this.hHr + (this.hHp * f2);
            this.huc = (f2 * this.hHq) + this.hHs;
            this.SM = this.hFr + ((this.hHo * ((float) j3)) / 1000.0f);
            for (int i2 = 0; i2 < this.hHy.size(); i2++) {
                this.hHy.get(i2).a(this, j3);
            }
            AppMethodBeat.o(261907);
            return true;
        }
    }

    public final a c(long j2, List<b> list) {
        this.hHv = j2;
        this.hHy = list;
        return this;
    }
}
