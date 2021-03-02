package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ag.k;
import com.tencent.mm.sdk.event.IEvent;
import com.tencent.mm.storage.ca;

public final class v extends IEvent {
    public a dCL;

    public static final class a {
        public ca dCM;
        public k.b dCN;
    }

    public v() {
        this((byte) 0);
    }

    private v(byte b2) {
        AppMethodBeat.i(19787);
        this.dCL = new a();
        this.order = false;
        this.callback = null;
        AppMethodBeat.o(19787);
    }
}
