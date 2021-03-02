package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.sdk.event.IEvent;

public final class kf extends IEvent {
    public a dPf;
    public b dPg;

    public static final class a {
        public String dHp;
    }

    public static final class b {
        public TimeLineObject dPh;
    }

    public kf() {
        this((byte) 0);
    }

    private kf(byte b2) {
        AppMethodBeat.i(125621);
        this.dPf = new a();
        this.dPg = new b();
        this.order = false;
        this.callback = null;
        AppMethodBeat.o(125621);
    }
}
