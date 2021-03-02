package com.tencent.soter.a.g;

import android.os.HandlerThread;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.soter.a.f.d;
import com.tencent.soter.core.c.c;

public final class e {
    public d RQZ;
    public String RRa;
    int[] RRb;
    public c RRc;
    public String RRd;
    HandlerThread RRe;

    /* synthetic */ e(byte b2) {
        this();
    }

    private e() {
        this.RRa = "";
        this.RRd = "";
    }

    public static class a {
        public e RRf = new e((byte) 0);

        public a() {
            AppMethodBeat.i(31);
            AppMethodBeat.o(31);
        }

        public final a U(int... iArr) {
            this.RRf.RRb = iArr;
            return this;
        }
    }
}
