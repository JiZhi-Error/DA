package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class os extends IEvent {
    public a dUJ;
    public b dUK;

    public static final class a {
        public String dFN;
        public int dUL;
        public int dUM;
        public String pageId;
        public int source;
    }

    public static final class b {
        public String xml;
    }

    public os() {
        this((byte) 0);
    }

    private os(byte b2) {
        AppMethodBeat.i(116039);
        this.dUJ = new a();
        this.dUK = new b();
        this.order = false;
        this.callback = null;
        AppMethodBeat.o(116039);
    }
}
