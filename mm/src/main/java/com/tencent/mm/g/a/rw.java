package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class rw extends IEvent {
    public a dYr;

    public static final class a {
        public String appId;
        public String dYs;
        public String mediaTagName;
        public String pkgName;
    }

    public rw() {
        this((byte) 0);
    }

    private rw(byte b2) {
        AppMethodBeat.i(116043);
        this.dYr = new a();
        this.order = false;
        this.callback = null;
        AppMethodBeat.o(116043);
    }
}
