package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class vp extends IEvent {
    public a ebM;

    public static final class a {
        public String dHp;
        public String dRS;
    }

    public vp() {
        this((byte) 0);
    }

    private vp(byte b2) {
        AppMethodBeat.i(125639);
        this.ebM = new a();
        this.order = false;
        this.callback = null;
        AppMethodBeat.o(125639);
    }
}
