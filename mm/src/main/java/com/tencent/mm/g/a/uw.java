package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class uw extends IEvent {
    public a ebg;
    public b ebh;

    public static final class a {
        public boolean ebi;
        public String ebj;
        public boolean ebk = false;
        public int type;
        public String videoPath;
    }

    public static final class b {
        public String ebj;
        public String ebl;
    }

    public uw() {
        this((byte) 0);
    }

    private uw(byte b2) {
        AppMethodBeat.i(125631);
        this.ebg = new a();
        this.ebh = new b();
        this.order = false;
        this.callback = null;
        AppMethodBeat.o(125631);
    }
}
