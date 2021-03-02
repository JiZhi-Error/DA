package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;
import java.util.List;

public final class pr extends IEvent {
    public a dVH;

    public static final class a {
        public int dJY = 0;
        public boolean dLQ = false;
        public long dVI = 0;
        public List list;
        public int scene = 0;
    }

    public pr() {
        this((byte) 0);
    }

    private pr(byte b2) {
        AppMethodBeat.i(125623);
        this.dVH = new a();
        this.order = false;
        this.callback = null;
        AppMethodBeat.o(125623);
    }
}
