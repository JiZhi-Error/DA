package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class zg extends IEvent {
    public a efr;

    public static final class a {
        public int dKy = 0;
        public byte[] efs;
        public int eft = 0;
    }

    public zg() {
        this((byte) 0);
    }

    private zg(byte b2) {
        AppMethodBeat.i(125334);
        this.efr = new a();
        this.order = false;
        this.callback = null;
        AppMethodBeat.o(125334);
    }
}
