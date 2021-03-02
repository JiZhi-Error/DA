package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.SnsObject;
import com.tencent.mm.sdk.event.IEvent;

public final class kc extends IEvent {
    public a dPa;
    public b dPb;

    public static final class a {
        public int dJi;
    }

    public static final class b {
        public SnsObject dPc;
    }

    public kc() {
        this((byte) 0);
    }

    private kc(byte b2) {
        AppMethodBeat.i(125618);
        this.dPa = new a();
        this.dPb = new b();
        this.order = false;
        this.callback = null;
        AppMethodBeat.o(125618);
    }
}
