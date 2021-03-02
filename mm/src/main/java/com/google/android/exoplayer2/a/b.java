package com.google.android.exoplayer2.a;

import android.media.AudioAttributes;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.JsApiGetABTestConfig;

public final class b {
    public static final b beJ;
    public final int beK;
    public final int beL;
    AudioAttributes beM;
    public final int flags;

    public static final class a {
        int beK = 0;
        int beL = 1;
        int flags = 0;
    }

    private /* synthetic */ b(int i2, int i3, int i4, byte b2) {
        this(i2, i3, i4);
    }

    static {
        AppMethodBeat.i(91755);
        a aVar = new a();
        beJ = new b(aVar.beK, aVar.flags, aVar.beL, (byte) 0);
        AppMethodBeat.o(91755);
    }

    private b(int i2, int i3, int i4) {
        this.beK = i2;
        this.flags = i3;
        this.beL = i4;
    }

    public final boolean equals(Object obj) {
        AppMethodBeat.i(91754);
        if (this == obj) {
            AppMethodBeat.o(91754);
            return true;
        } else if (obj == null || getClass() != obj.getClass()) {
            AppMethodBeat.o(91754);
            return false;
        } else {
            b bVar = (b) obj;
            if (this.beK == bVar.beK && this.flags == bVar.flags && this.beL == bVar.beL) {
                AppMethodBeat.o(91754);
                return true;
            }
            AppMethodBeat.o(91754);
            return false;
        }
    }

    public final int hashCode() {
        return ((((this.beK + JsApiGetABTestConfig.CTRL_INDEX) * 31) + this.flags) * 31) + this.beL;
    }
}
