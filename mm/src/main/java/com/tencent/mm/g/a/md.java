package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class md extends IEvent {
    public a dRC;

    public static final class a {
        public String dRD;
        public int opType;
        public int viewId = 1;
    }

    public md() {
        this((byte) 0);
    }

    private md(byte b2) {
        AppMethodBeat.i(19818);
        this.dRC = new a();
        this.order = false;
        this.callback = null;
        AppMethodBeat.o(19818);
    }
}
