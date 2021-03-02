package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class hg extends IEvent {
    public a dLJ;

    public static final class a {
        public int dLK;
        public long id;
        public long localId;
    }

    public hg() {
        this((byte) 0);
    }

    private hg(byte b2) {
        AppMethodBeat.i(168878);
        this.dLJ = new a();
        this.order = false;
        this.callback = null;
        AppMethodBeat.o(168878);
    }
}
