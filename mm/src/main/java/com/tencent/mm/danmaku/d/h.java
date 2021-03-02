package com.tencent.mm.danmaku.d;

import android.graphics.Point;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class h {
    public final int gQF;
    public float gQG = 0.0f;
    public float gQH = 0.0f;
    public final Point mPoint;
    public final long mTime;

    public h(long j2, Point point, int i2) {
        this.mTime = j2;
        this.mPoint = point;
        this.gQF = 0;
    }

    public final String toString() {
        AppMethodBeat.i(241754);
        String str = "TouchPoint{mTime=" + this.mTime + ", mPoint=" + this.mPoint + ", mDistanceOfError=" + this.gQF + '}';
        AppMethodBeat.o(241754);
        return str;
    }
}
