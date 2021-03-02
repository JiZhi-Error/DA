package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class fj extends IEvent {
    public a dII;
    public b dIJ;

    public static final class a {
        public String brandName;
        public byte[] data;
        public String mac;
    }

    public static final class b {
        public boolean dGX;
    }

    public fj() {
        this((byte) 0);
    }

    private fj(byte b2) {
        AppMethodBeat.i(19802);
        this.dII = new a();
        this.dIJ = new b();
        this.order = false;
        this.callback = null;
        AppMethodBeat.o(19802);
    }
}
