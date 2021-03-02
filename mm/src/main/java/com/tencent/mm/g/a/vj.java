package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class vj extends IEvent {
    public a ebG;

    public static final class a {
        public String dHp;
        public String dRS;
    }

    public vj() {
        this((byte) 0);
    }

    private vj(byte b2) {
        AppMethodBeat.i(125634);
        this.ebG = new a();
        this.order = false;
        this.callback = null;
        AppMethodBeat.o(125634);
    }
}
