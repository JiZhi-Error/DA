package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class ew extends IEvent {
    public a dIh;
    public b dIi;

    public static final class a {
        public String brandName;
        public String dGL;
        public byte[] data;
    }

    public static final class b {
        public boolean dGX;
    }

    public ew() {
        this((byte) 0);
    }

    private ew(byte b2) {
        AppMethodBeat.i(116006);
        this.dIh = new a();
        this.dIi = new b();
        this.order = false;
        this.callback = null;
        AppMethodBeat.o(116006);
    }
}
