package com.tencent.mm.pluginsdk.location;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class d {
    public long JTu;
    public int dRt;
    public float iUY;
    public float iUZ;
    public int scene;

    public d(long j2, float f2, float f3, int i2, int i3) {
        this.iUY = f2;
        this.iUZ = f3;
        this.dRt = i2;
        this.scene = i3;
        this.JTu = j2;
    }

    public final String toString() {
        AppMethodBeat.i(151631);
        String format = String.format("%d-%d-%d", Integer.valueOf((int) (this.iUY * 1000000.0f)), Integer.valueOf((int) (this.iUZ * 1000000.0f)), Integer.valueOf(this.dRt));
        AppMethodBeat.o(151631);
        return format;
    }
}
